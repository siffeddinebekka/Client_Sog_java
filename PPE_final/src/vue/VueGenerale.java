package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.Admin;
import controleur.Sog;

public class VueGenerale extends JFrame implements ActionListener 
{
	
	private JButton btQuitter = new JButton("Deconnexion");
	private JButton btProfils = new JButton("Mon Profil");
	private JButton btClients = new JButton("Gestion des Clients");
	private JButton btInterventions = new JButton("Gestion des Interventions");
	private JButton btTechnicien = new JButton("Gestion des Technicien");
	private JButton btBord = new JButton("Tableau de Bords");
	
	
	private JPanel PanelMenu = new JPanel();
	private JPanel PanelProfil = new JPanel();
	private static PanelClient unPanelClient = new PanelClient();
	private static Panelintervention unPanelIntervention = new Panelintervention();
	private static PanelTechnicien unPanelTechnicien = new PanelTechnicien();
	

	
	
	
	
	
	public VueGenerale(Admin unAdmin)
	{
		this.setTitle("SOG Administration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(0, 102, 255));
		this.setBounds(300, 200, 900, 500);
		this.setLayout(null);
		
		
		this.PanelMenu.setLayout(new GridLayout(1,7));
		this.PanelMenu.setBounds(20,10,860,40);
		this.PanelMenu.setBackground(Color.white);
		this.PanelMenu.add(this.btProfils);
		this.PanelMenu.add(this.btClients);
		this.PanelMenu.add(this.btInterventions);
		this.PanelMenu.add(this.btTechnicien);
		this.PanelMenu.add(this.btBord);
		this.PanelMenu.add(this.btQuitter);
		this.add(this.PanelMenu); 
		
		this.PanelProfil.setLayout(new GridLayout(4,1));
		this.PanelProfil.setBounds(250,100,400,300);
		this.PanelProfil.setBackground (new Color(0, 102, 255));
		this.PanelProfil.setVisible(false);
		this.PanelProfil.add(new JLabel("Nom de l'admin :" +unAdmin.getID()));
		

		
		this.add(this.PanelProfil);
		this.add(unPanelClient);
		this.add(unPanelIntervention);
		this.add(unPanelTechnicien);
		
		
		this.btQuitter.addActionListener(this);
		this.btProfils.addActionListener(this);
		this.btClients.addActionListener(this);
		this.btInterventions.addActionListener(this);
		this.btTechnicien.addActionListener(this);
		this.btBord.addActionListener(this);
		
		
		this.setVisible(true);
	}








	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btQuitter)
		{
			Sog.fermerVueGenerale();
			Sog.rendreVisibleVueConnexion(true);
			
		}
		else if (e.getSource() == this.btProfils)
		{
			this.PanelProfil.setVisible(true);
			unPanelClient.setVisible(false);
			unPanelIntervention.setVisible(false);
			unPanelTechnicien.setVisible(false);
			
		}
		else if (e.getSource() == this.btClients)
		{
			this.PanelProfil.setVisible(false);
			unPanelClient.setVisible(true);
			unPanelIntervention.setVisible(false);
			unPanelTechnicien.setVisible(false);
			
		}
		else if (e.getSource() == this.btInterventions)
		{
			this.PanelProfil.setVisible(false);
			unPanelClient.setVisible(false);
			unPanelIntervention.setVisible(true);
			unPanelTechnicien.setVisible(false);
			
		}
		else if (e.getSource() == this.btTechnicien)
		{
			this.PanelProfil.setVisible(false);
			unPanelClient.setVisible(false);
			unPanelIntervention.setVisible(false);
			unPanelTechnicien.setVisible(true);
			
		}
	}
	
}
	
	
	
	
	

