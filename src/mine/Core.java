package mine;

import java.awt.Point;

public class Core {
	private View			view;
	private MineMap			map;
	private MineSweeperUserListener		listener;
	public Core() {
		map = new MineMap();
		listener = new MineSweeperUserListener(this);
		view = new View();
		view.addListener(listener);
		start();
	}
	

	private void start() {
		startNewGame();
		
	}
	
	public void startNewGame(){
		view.resetViewModel();
		view.drawMap();
		map.newMap();
	}


	public static void main(String[] args) {
		new Core();
	}


	public void discover(Cell c) {
		discoverCell(c);
	}


	private void discoverCell(Cell c) {
		ViewElement viewElement = new ViewElement(c.getX(), c.getY(), c.getState());
		viewElement.setProperty(c.getProperty());
		switch(c.getProperty()){
		case 0 : 
			c.setState(Cell.Opend); 
			view.changeViewModel(c); 
			view.drawMap();
			flipAround(c);
			break;
		case 9 : gameOver();
		default : 
			System.out.println("default");
			c.setState(Cell.Opend); 
			view.changeViewModel(c); 
			view.drawMap(); 
			break;
					
		}
//		System.out.println("c state " + c.getState());
	}


	private void gameOver() {
		view.showAllMine();
	}


	


	public void checkMine(Cell c) {
		if(c.getState() == Cell.Closed) {
			c.setState(Cell.Checked);
		}
		else if(c.getState() == Cell.Checked){
			c.setState(Cell.Closed);
		}
		view.changeViewModel(c);
		view.drawMap();
	}
	
	public void discoverAround(Cell c){
		if(checkSatisfaction(c)){
			flipAround(c);
		}
	}


	private void flipAround(Cell c) {
		int cellx = c.getX();
		int celly = c.getY();
		int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
		int[] dy = {1, -1, 0, -1, 1, 0, -1, 1};
		for( int i = 0; i<8; i++) {
			if(cellx + dx[i]>=0 && cellx + dx[i]<20 && celly + dy[i]>=0 && celly + dy[i]<20) {
				Cell temp = map.get(cellx + dx[i],celly + dy[i]);
				
				if(temp.getState() == Cell.Closed && temp.getProperty() == 0) {
					System.out.println("dA");
					discoverCell(temp);
				}
			}
			
		}
		
	}


	private boolean checkSatisfaction(Cell c) {
		int cellx = c.getX();
		int celly = c.getY();
		int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
		int[] dy = {1, -1, 0, -1, 1, 0, -1, 1};
		int cnt = 0;
		for(int i = 0; i < 8; i++) {
			if(cellx + dx[i]>0 && cellx + dx[i]<20 && celly + dy[i]>0 && celly + dy[i]<20) {
				Cell temp = map.get(cellx + dx[i],celly + dy[i]);
				if(temp.getProperty() == Cell.Mine) {
					cnt++;
				}
			}
			
		}
		if(cnt == c.getProperty()) {
			return true;
		}
		else {
			return false;
		}
	}
	public Cell getCell(int x, int y) {
		return map.get(x, y);
	}


}
