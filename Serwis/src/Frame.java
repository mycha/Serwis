import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class Frame extends JFrame {
	private int szerokosc = 800;
	private  int wysokosc = 600;
	
		public Frame(){
			super();
			setPreferredSize(new Dimension(szerokosc,wysokosc));
			
			//setResizable(false);
			
			JMenuBar menu = new Menu();
			JPanel loginPanel = new Logowanie();
			JPanel ActionB = new ActionButton();
			JPanel glownyPanel = new Panel();
			add(menu, BorderLayout.NORTH);
			
		//	setLayout(new FlowLayout(FlowLayout.LEADING));
			add(loginPanel, BorderLayout.EAST);
			add(ActionB, BorderLayout.WEST);
			add(glownyPanel, BorderLayout.SOUTH);
			pack();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			setVisible(true);
		}
}
