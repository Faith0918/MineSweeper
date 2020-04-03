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


	public void discover(Point p) {
		double x = p.getX();
		double y = p.getY();
		
		Cell c = convertPointToCell(x,y);
		System.out.println("c_x : "+ c.getX());
		discoverCell(c);
		
	}


	private void discoverCell(Cell c) {
		Point p = new Point(c.getX(),c.getY());
		ViewElement viewElement = new ViewElement(p.x, p.y, c.getState());
		viewElement.setProperty(c.getProperty());
		switch(c.getProperty()){
		case 0 : discoverAround(p); view.changeViewModel(c); view.drawMap();
		case 9 : gameOver();
		default : c.setState(Cell.Opend); view.changeViewModel(c); view.drawMap();
					
		}
		System.out.println("c state " + c.getState());
	}


	private void gameOver() {
		view.showAllMine();
	}


	private Cell convertPointToCell(double x, double y) {
		
		int cellx = 0,celly = 0;
		cellx = (int)(x/20);
		celly = (int)(y/20);
		Cell c = map.get(cellx,celly);
		return c;
	}


	public void checkMine(Point p) {
		double x = p.getX();
		double y = p.getY();
		
		Cell c = convertPointToCell(x,y);
		c.setState(Cell.Checked);
		view.changeViewModel(c);
	}
	public void discoverAround(Point p){
		
		Cell c = convertPointToCell(p.getX(),p.getY());
		int cellx = c.getX();
		int celly = c.getY();
		
		if(checkSatisfaction(c)){
			int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
			int[] dy = {1, -1, 0, -1, 1, 0, -1, 1};
			for( int i = 0; i<8; i++) {
				Cell temp = map.get(cellx + dx[i],celly + dy[i]);
				if(temp.getState() == Cell.Closed) {
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


}
