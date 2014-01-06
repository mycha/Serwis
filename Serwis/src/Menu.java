import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.peer.MenuPeer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


public class Menu extends JMenuBar{
		

	public Menu(){
			userMenu();	
		}
	
	
	private void userMenu(){
		JMenuBar menuBar = new JMenuBar();
		add(menuBar);
		JMenu menuFile = new JMenu("Plik");
		add(menuFile);
		JMenu menuNaprawy = new JMenu("Naprawy");
		add(menuNaprawy);
		JMenu menuSamochody = new JMenu("Samochody");
		add(menuSamochody);
		JMenu menuUmow = new JMenu("Um�w si�");
		add(menuUmow);
		JMenu menuAbout = new JMenu("Pomoc");
		add(menuAbout);
		
		JMenuItem historiaNapraw = new JMenuItem("Historia napraw");
		JMenuItem ustawienia = new JMenuItem("Ustawienia");
		JMenuItem aktualneNaprawy = new JMenuItem("Aktualne naprawy");
		JMenuItem oProgramie = new JMenuItem("O Programie");
		JMenuItem Samochody = new JMenuItem("Moje samochody");
		JMenuItem Umow = new JMenuItem("Um�w si�");
		menuNaprawy.add(historiaNapraw);
		menuNaprawy.add(aktualneNaprawy);
		menuSamochody.add(Samochody);
		menuUmow.add(Umow);
		menuFile.add(ustawienia);
		menuAbout.add(oProgramie);
		
		
		Samochody.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Klient.ID !=0){
				Klient.Command("Select * from car where client_id = '" +  Klient.ID +"'");
				}else{
					JFrame f = new InfoBox("Zaloguj si� aby korzysta� z funkcji programu");
				}
				
			}
		});
		
		menuNaprawy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(Klient.ID !=0){
					Klient.Command("Select * from serviceHistory where client_id = '" +  Klient.ID +"'");
					}else{
						JFrame f = new InfoBox("Zaloguj si� aby korzysta� z funkcji programu");
					}
				
			}
		});
		Umow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//wyswietla formularz do umawiania sie na uslugi
				
				if(Klient.ID !=0){
					JFrame form = new Formularz();
					}else{
						JFrame f = new InfoBox("Zaloguj si� aby korzysta� z funkcji programu");
					}
			}
		});
		
		menuAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		historiaNapraw.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(Klient.ID !=0){
					Klient.Command("Select * from serviceHistory where client_id = '" +  Klient.ID +"'");
					}else{
						JFrame f = new InfoBox("Zaloguj si� aby korzysta� z funkcji programu");
					}
				
			}
		});
		aktualneNaprawy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//wyswietla aktualnie przeprowadzane naprawy
				
				if(Klient.ID !=0){
					Klient.Command("Select * from serviceHistory where client_id = '" +  Klient.ID +"'");
					}else{
						JFrame f = new InfoBox("Zaloguj si� aby korzysta� z funkcji programu");
					}
				
			}
		});
		oProgramie.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					//wyswietla informacje o programie
					JFrame about = new JFrame();
					JTextArea tf= new JTextArea();
					tf.setText("Program Bosski sie zrobi�");
					about.setPreferredSize(new Dimension(100,100));
					about.setLocation(Frame.sWidth/2-50,Frame.sHeight/2-50);
					about.add(tf);
					about.pack();
					
					about.setVisible(true);
					

				
			}
		});
		ustawienia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
					//wyswietla okno do edycji ustawien 
					JFrame about = new JFrame();
					JTextArea tf= new JTextArea();
					tf.setText("Tutaj powstan� ustawienia");
					about.setPreferredSize(new Dimension(100,100));
					about.setLocation(Frame.sWidth/2-50,Frame.sHeight/2-50);
					about.add(tf);
					about.pack();
					
					about.setVisible(true);
		
				
			}
		});	
	}
	
}
