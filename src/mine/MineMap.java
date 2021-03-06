package mine;

import java.util.Random;

public class MineMap {
	Cell[][] mapArray;
	int size;

	
	public void newMap() {
		newMapArray();
		assignMines();
		assignNumber();
		
	}

	private void assignNumber() {
		int r = 0;
		int c = 0;
		int[] dr = {0, 0, 1, 1, 1, -1, -1, -1};
		int[] dc = {1, -1, 0, -1, 1, 0, -1, 1};
//		while( r+c < size*2-2) {
//			
//		}
		for(r=0; r<size;r++) {
			for(c=0;c<size;c++) {
				if(mapArray[r][c] == null) {
					int property = 0;
					for(int i=0;i<8;i++) {
						if(r+dr[i]<0||c+dc[i]<0||r+dr[i]>=size||c+dc[i]>=size) {
							continue;
						}
						else {
							if(mapArray[r+dr[i]][c+dc[i]] != null && mapArray[r+dr[i]][c+dc[i]].getProperty() == Cell.Mine) {
								property++;
							}
						}
					}
					mapArray[r][c] = new Cell(r, c, property);
					
				}
				
				
			}
		}
		
		
	}

	private void assignMines() {
		int num = 0;
		Random random = new Random();
		while(num<30) {
			int x = random.nextInt(20);
			int y = random.nextInt(20);
			if(mapArray[x][y] != null){
				continue;
			}
			else {
				mapArray[x][y] = new Cell(x, y, Cell.Mine); 
				num++;
			}
		}
		

	}

	private void newMapArray() {
		size = 20;
		mapArray = new Cell[size][size];
		
	}

	public Cell get(int x, int y) {
		
		return mapArray[x][y];
		
	}

}
