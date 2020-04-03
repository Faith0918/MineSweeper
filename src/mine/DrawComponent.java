package mine;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

public class DrawComponent extends JComponent{
	ViewElement[][] cellView;
	
	public void setViewModel(ViewElement[][] cellView) {
		this.cellView = cellView;
	}
	
	public ViewElement[][] getViewModel() {
		return cellView;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		System.out.println(cellView[0][0].getState());
		for(int r = 0;r < 20; r++) {
			for(int c = 0; c < 20; c++) {
				if(cellView[r][c].getState() == Cell.Closed) {
					g.setColor(Color.black);
					g.drawRect(r*20, c*20, 20, 20);
				}
				else {
					
					switch(cellView[r][c].getProperty()) {
					
						case 0: 
							g.setColor(Color.darkGray);
							g.fillRect(r*20, c*20, 20, 20);
							break;
						case 1: 
							g.setColor(Color.BLACK);
							g.setFont(new Font("¸¼Àº°íµñ", Font.BOLD,25));
							g.drawString("1", r*20, c*20+20);
							break;
						case 2: 
							g.setColor(Color.BLACK);
							g.setFont(new Font("¸¼Àº°íµñ", Font.BOLD,25));
							g.drawString("2", r*20, c*20+20);
							break;
						case 3: 
							g.setColor(Color.BLACK);
							g.setFont(new Font("¸¼Àº°íµñ", Font.BOLD,25));
							g.drawString("3", r*20, c*20+20);
							break;
						case 4: 
							g.setColor(Color.BLACK);
							g.setFont(new Font("¸¼Àº°íµñ", Font.BOLD,25));
							g.drawString("4", r*20, c*20+20);
							break;
						case 5: 
							g.setColor(Color.BLACK);
							g.setFont(new Font("¸¼Àº°íµñ", Font.BOLD,25));
							g.drawString("5", r*20, c*20+20);
							break;
						case 6: 
							g.setColor(Color.BLACK);
							g.setFont(new Font("¸¼Àº°íµñ", Font.BOLD,25));
							g.drawString("6", r*20, c*20+20);
							break;
						case 7: 
							g.setColor(Color.BLACK);
							g.setFont(new Font("¸¼Àº°íµñ", Font.BOLD,25));
							g.drawString("7", r*20, c*20+20);
							break;
						case 8: 
							g.setColor(Color.BLACK);
							g.setFont(new Font("¸¼Àº°íµñ", Font.BOLD,25));
							g.drawString("8", r*20, c*20+20);
							break;
						case 9: 
							g.setColor(Color.RED); 
							g.fillRect(r*20, c*20, 20, 20);
							System.out.println("red" + cellView[r][c].getProperty());
							break;
						default:
					}
						
				}
				
			}
		}
		
	}
	
}
