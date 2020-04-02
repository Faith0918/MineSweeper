package mine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
	JPanel resetPanel = new JPanel();
	JPanel mapPanel = new JPanel();
	JButton resetButton = new JButton();
	JButton mapButton[][] = new JButton[20][20];
	
	public View() {
		setTitle("MineSweeper");
		this.init();
		this.start();
		this.setSize(540,625);
		setVisible(true);
	}
	
	
	private void init() {
//		this.setLayout(new GridLayout(20,20));
		for(int i=0;i<20;i++) {
			for(int j=0;j<20;j++) {
				mapButton[i][j] = new JButton();
				mapButton[i][j].setPreferredSize(new Dimension(20,20));
				mapButton[i][j].addMouseListener(new MineSweeperUserListener());
				mapButton[i][j].addActionListener(new MineSweeperUserListener());
				mapButton[i][j].setBackground(Color.DARK_GRAY);
				mapPanel.add(mapButton[i][j]);
			}
		}
		this.add(mapPanel);
	}


	private void start() {
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}


	
}
