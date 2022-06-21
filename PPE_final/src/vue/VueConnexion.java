package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Admin;
import controleur.Sog;

public class VueConnexion  extends JFrame implements ActionListener, KeyListener
{
	private JPanel panelConenxion = new JPanel();
	private JButton btSeConnecter = new JButton("Se Connecter");
	private JButton btAnnuler = new JButton("Annuler");
	private JTextField txtAdmin = new JTextField("s@gmail.com");
	private JPasswordField txtPASSWORD = new JPasswordField("123");
	
	public VueConnexion()
	{
		this.setTitle("Administration SOG");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 102, 255));
		this.setBounds(300, 300, 600, 250);
		this.setLayout(null);
		this.panelConenxion.setLayout(new GridLayout(3,2));
		this.panelConenxion.setBounds(300,40,260,150);
		this.panelConenxion.setBackground(new Color(0, 102, 255));
		
		
		this.panelConenxion.add(new JLabel("Email"));
		this.panelConenxion.add(this.txtAdmin);
		
		this.panelConenxion.add(new JLabel("MDP : "));
		this.panelConenxion.add(this.txtPASSWORD);
		
		this.panelConenxion.add(this.btAnnuler);
		this.panelConenxion.add(this.btSeConnecter);
		
		this.add(this.panelConenxion);
		
		
		//installation du logo 
				ImageIcon leLogo = new ImageIcon("src/images/logo.png"); 
				JLabel lbLogo = new JLabel(leLogo); 
				lbLogo.setBounds(20, 40, 250, 150);
				this.add(lbLogo); 
		
		
		
		
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		this.txtAdmin.addKeyListener(this);
		this.txtPASSWORD.addKeyListener(this);
		
		this.setVisible(true);
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}

	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() ==  KeyEvent.VK_ENTER)
		{
			traitement();
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		
	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.txtAdmin.setText("");
			this.txtPASSWORD.setText("");
		}
		else if (e.getSource() == this.btSeConnecter)
		{
			traitement();
		}
		
	}
	public void traitement() {
		String USERNAME = this.txtAdmin.getText();
		String PASSWORD = new String(this.txtPASSWORD.getPassword());
		
		Admin unAdmin = Sog.selectWhereAdmin(USERNAME,PASSWORD);
		if(unAdmin == null)
		{
			JOptionPane.showMessageDialog(this,"Veuillez vérifier vos identifiant");
			this.txtAdmin.setText("");
			this.txtPASSWORD.setText("");
		}else
		{
			JOptionPane.showMessageDialog(this,"Bienvenue M./MM" + unAdmin.getID()
			+ "\n Vous avez le rôle : " +unAdmin.getID());
			Sog.instancierVueGenerale(unAdmin);
			
			Sog.rendreVisibleVueConnexion(false);
			
		}
	}

}
