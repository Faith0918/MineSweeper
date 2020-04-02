package mine;

public class Cell {
	private final int x;
	private final int y;
	private final int property;
	private int	state;
	// 0~8,9 = mine
	public static final int Mine = 9;
	public static final int Closed = 0;
	public static final int Opend = 1;
	public static final int Checked = 2;
	
	public Cell(int x, int y, int property) {
		this.x = x;
		this.y = y;
		this.property = property;
		this.state = 0;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getProperty() {
		return property;
	}
	public void setState(int state) {
		this.state = state;
		
	}
	public int getState(){
		return state;
	}
	
	
}
