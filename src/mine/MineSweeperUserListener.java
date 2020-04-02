package mine;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MineSweeperUserListener implements ActionListener, MouseListener{
	private Core			core;
	
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
		if(e.getButton() == MouseEvent.BUTTON1){
			core.discover(p);
		}else if(e.getButton() == MouseEvent.BUTTON2){
			core.checkMine(p);
		}
		
	}

}
