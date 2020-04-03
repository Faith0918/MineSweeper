package mine;

public class ViewElement {
	private final int x;
	private final int y;
	private int property;
	private int state;
	// 0~8,9 = mine
	public static final int Mine = 9;
	public static final int Closed = 0;
	public static final int Opend = 1;
	public static final int Checked = 2;
	
	public ViewElement (int x, int y, int state) {
		this.x = x;
		this.y = y;
		this.state = state;
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
	
	public void setProperty(int property) {
		this.property = property;
	}
	
	public void setState(int state) {
		this.state = state;
		
	}
	public int getState(){
		return state;
	}
}
