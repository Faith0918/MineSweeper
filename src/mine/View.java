package mine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
	JPanel resetPanel;
	JPanel mapPanel;
	JButton resetButton;
	DrawComponent cmp;

	
	public View() {
		setTitle("MineSweeper");
		this.setSize(425,490);
		this.setLayout(new BorderLayout());
		resetPanel = new JPanel();
		mapPanel = new JPanel();
		resetButton = new JButton("restart");
		resetPanel.add(resetButton);
		cmp = new DrawComponent();
		mapPanel.add(cmp);
		this.add(resetPanel, BorderLayout.NORTH);
		this.add(cmp, BorderLayout.CENTER);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void addListener(MineSweeperUserListener listener) {
		resetButton.addActionListener(listener);
		cmp.addMouseListener(listener);
	}

	public void changeViewModel(Cell cell) {
		ViewElement changedElement = new ViewElement(cell.getX(), cell.getY(), cell.getState());
		changedElement.setProperty(cell.getProperty());
		ViewElement[][] viewModel = cmp.getViewModel();
		viewModel[cell.getX()][cell.getY()] = changedElement;
		cmp.setViewModel(viewModel);
	}
	
	public void resetViewModel() {
		ViewElement[][] viewModel = new ViewElement[20][20];
		for(int r = 0; r < 20 ; r++) {
			for(int c = 0; c < 20; c++) {
				viewModel[r][c] = new ViewElement(r, c, Cell.Closed);
			}
		}
		cmp.setViewModel(viewModel);
	}
	
	public void drawMap() {
		cmp.repaint();
	}
	
	

	public void showAllMine() {
		// TODO Auto-generated method stub
		
	}


	
}
