import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Logowanie extends JPanel {

	
	private static JTextField usertf ;
	private static JTextField passwordtf;
	private static JButton zalogujButton;
	private static JButton wylogujButton;
	public static boolean zalogowany = false;
	private String user;
	private JFrame Bframe;
	public static Klient klient;
	private boolean log=false, wylog=false;
	public Logowanie(){
		
		

		
	
			dodajKomponentyniezalogowany();
			zalogujButton.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent arg0) {	
						String user = usertf.getText();
						String password = passwordtf.getText();
						zaloguj(user, password);	
						if(zalogowany)
							dodajKomponentyzalogowany();
							
			}});
		
	
			wylogujButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {	
						System.out.println("dfsd");
						wyloguj();
						
						dodajKomponentyniezalogowany();
				}});
		
		
	}
	private void dodajKomponentyniezalogowany(){
	
		removeAll();
		usertf  = new JTextField("");
		passwordtf  = new JTextField("");
		usertf.setPreferredSize(new Dimension(100,20));
		passwordtf.setPreferredSize(new Dimension(100,20));
		JLabel name = new JLabel("Name: ");
	    JLabel password = new JLabel("Password: ");
	    
	    setPreferredSize(new Dimension(450,30));
		setLayout(new FlowLayout());
		
		if(log == false){
			zalogujButton = new JButton(); 
			//zalogujButton.setBounds(130, 20, 60,20);
			zalogujButton.setText("Zaloguj");
			zalogujButton.setBorder(null);
			wylogujButton = new JButton(); 
			wylogujButton.setText("Wyloguj");
			wylogujButton.setBorder(null);
			log = true;
			}
		
		add(name);
		add(usertf);
		add(password);
		add(passwordtf);
		add(zalogujButton);
		revalidate();
		repaint();
		
	}
	private void dodajKomponentyzalogowany(){
		

		String user = usertf.getText();
		removeAll();
		JLabel login = new JLabel("Zalogowano jako : "+ user );
		setPreferredSize(new Dimension(200,40));
		setLayout(new FlowLayout());
		
		add(login);
		add(wylogujButton);
		setVisible(true);
		revalidate();
		repaint();
		
	}
	
	
	public void zaloguj(String user, String password){
				if(zalogowany== false){
					
					
					klient = new Klient(user,password);
					System.out.println(user + password);
					if(zalogowany)
						klient.Command("Select * from client where client_name = '" + user + "'");
					else	
						Bframe = new BladFrame();
				}				
			}
	public void wyloguj(){
		if(zalogowany){
			klient.stop();
			zalogowany= false;

		}
	}

	

}
