package mine;

import java.awt.Point;

public class Core {
	private View			view;
	private MineMap			map;
	public Core() {
		map = new MineMap();
		view = new View();
		start();
	}
	

	private void start() {
		// TODO Auto-generated method stub
		
	}
	
	public void startNewGame(){
		map.newMap();
	}


	public static void main(String[] args) {
		new Core();
	}


	public void discover(Point p) {
		double x = p.getX();
		double y = p.getY();
		
		Cell c = convertPointToCell(x,y);
		discoverCell(c);
		
	}


	private void discoverCell(Cell c) {
		switch(c.getProperty()){
		case 0 : //discoverAround();
		case 9 : //gameOver();
		default : c.setState(Cell.Opend);
		}
		
	}


	private Cell convertPointToCell(double x, double y) {
		
		int cellx = 0,celly = 0;
		Cell c = map.get(cellx,celly);
		return c;
	}


	public void checkMine(Point p) {
		double x = p.getX();
		double y = p.getY();
		Cell c = convertPointToCell(x,y);
		c.setState(Cell.Checked);
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
			Cell temp = map.get(cellx + dx[i],celly + dy[i]);
			if(temp.getProperty() == Cell.Mine) {
				cnt++;
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
