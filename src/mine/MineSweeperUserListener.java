package mine;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MineSweeperUserListener implements ActionListener, MouseListener{
	private Core			core;
	public MineSweeperUserListener(Core core) {
		this.core = core;
	}
	public void actionPerformed(ActionEvent e) {
		 if(e.getActionCommand().equals("new")){
			 core.startNewGame();
		 }
		
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {
		
	}

	public void mouseExited(MouseEvent arg0) {
		
	}

	public void mousePressed(MouseEvent arg0) {
		
	}

	public void mouseReleased(MouseEvent e) {
		Point p = e.getPoint();
		Cell cell = convertPointToCell(p.x, p.y);
		//TODO 
		if(e.getButton() == MouseEvent.BUTTON1){
			
			core.discover(cell);
		}else if(e.getButton() == MouseEvent.BUTTON3){
			
			core.checkMine(cell);
		}
		
	}
	private Cell convertPointToCell(double x, double y) {
		
		int cellx = 0,celly = 0;
		cellx = (int)(x/20);
		celly = (int)(y/20);
		Cell c = core.getCell(cellx,celly);
		return c;
	}

}
