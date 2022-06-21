package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Client;
import controleur.Tableau;
import modele.Modele;

public class PanelClient  extends PanelDeBase implements ActionListener
{
	private static final Object[] ligne = null;
	private JPanel panelForm = new JPanel();
	private JPanel panelTable = new JPanel();
	private JButton btEnrengister = new JButton("Enrengister");
	private JButton btAnnuler = new JButton("Annuler");
	private JTextField txtNomc = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtMail = new JTextField();
	private JTextField txtAdresse = new JTextField();
	private JTextField txtCp = new JTextField();
	private JTextField txttel = new JTextField();
	
	private JTable uneTable = null;
	
	private static Tableau unTableau = null;
	
	public PanelClient()
	{
		super(new Color(0, 102, 255));
		this.panelForm.setLayout(new GridLayout(6,2));
		this.panelForm.add(new JLabel("Nom du Client"));
		this.panelForm.add(this.txtNomc);
		
		this.panelForm.add(new JLabel("Prenom du Client"));
		this.panelForm.add(this.txtPrenom);
		
		this.panelForm.add(new JLabel("Mail du Client"));
		this.panelForm.add(this.txtMail);
		
		this.panelForm.add(new JLabel("Code Postal du Client"));
		this.panelForm.add(this.txtCp);
		
		this.panelForm.add(new JLabel("Telephone du Client"));
		this.panelForm.add(this.txttel);
		
		this.panelForm.add(new JLabel("Adresse du Client"));
		this.panelForm.add(this.txtAdresse);
		
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnrengister);
		
		this.panelForm.setBounds(20, 20, 300, 320);
		this.add(this.panelForm);
		
		
		this.panelTable.setBounds(340, 20, 380, 320);
		this.panelTable.setBackground(new Color(0, 102, 255));
		this.panelTable.setLayout(null);
		String entetes[] = {"ID Client", "Nom", "Prenom", "Mail", "Code Postal", "Telephone", "Adresse"};
		Object donnees [][] = this.getLesDonnees();
		unTableau = new Tableau(entetes, donnees);
		
		this.uneTable = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(this.uneTable);
		uneScroll.setBounds(0, 60, 380, 200);
		
		this.panelTable.add(uneScroll);
		this.add(this.panelTable);
		this.uneTable.addMouseListener(new MouseListener() {
			public void MouseReleased(MouseEvent e) {
				
			}

			
			public void mouseClicked(MouseEvent e) {
				int nbclic = e.getClickCount();
				if(nbclic == 2)
				{
					int numLigne = uneTable.getSelectedRow();
					int retour = JOptionPane.showConfirmDialog(null, "Voulez vous supprimer un Client ?","Suppression du Client",JOptionPane.YES_NO_OPTION);
					if (retour == 0)
					{
						int codec = Integer.parseInt(unTableau.getValueAt(numLigne,0).toString());
						unTableau.supprimerLigne(numLigne);
					}
							
				}else if(nbclic==1)
				{
					int numLigne = uneTable.getSelectedRow();
					String nom = unTableau.getValueAt(numLigne,1).toString();
					txtNomc.setText(nom);
					String prenom = unTableau.getValueAt(numLigne,2).toString();
					txtPrenom.setText(prenom);
					String mail = unTableau.getValueAt(numLigne,3).toString();
					txtMail.setText(mail);
					String adresse = unTableau.getValueAt(numLigne,3).toString();
					txtMail.setText(adresse);
					String cp = unTableau.getValueAt(numLigne,4).toString();
					txtCp.setText(cp);
					String telephone = unTableau.getValueAt(numLigne,5).toString();
					txttel.setText(telephone);
					btEnrengister.setText("Modifier");
				}
				
			}


			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}


			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}


			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}


			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.btEnrengister.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		
	}
		
		
		
		

		
	

	

	private Object[][] getLesDonnees() {
		ArrayList<Client> lesClients = Modele.selectAllClients();
		Object [][] matrice = new Object[lesClients.size()][6];
		int i = 0;
		for (Client unClient : lesClients)
		{
			matrice[i][0] = unClient.getCodec();
			matrice[i][1] = unClient.getNomc();
			matrice[i][2] = unClient.getPrenomc();
			matrice[i][3] = unClient.getAdressec();
			matrice[i][4] = unClient.getMailc();
			matrice[i][5] = unClient.getCpc();
			matrice[i][6] = unClient.getTelc();
			i++;
		}
		return matrice;
	}

	public void viderChamps()
	{
		this.txtNomc.setText("");
		this.txtPrenom.setText("");
		this.txtAdresse.setText("");
		this.txtMail.setText("");
		this.txtCp.setText("");
		this.txttel.setText("");
		this.btEnrengister.setText("Enrengistrer");
	}
	
	public Client saisirClient()
	{
		Client unClient = null;
		String nom = this.txtNomc.getText();
		String prenom = this.txtPrenom.getText();
		String mail = this.txtMail.getText();
		String adresse = this.txtAdresse.getText();
		int cp = 0;
		int tel = 0;
		try {
			cp =Integer.parseInt(this.txtCp.getText());
		}
		catch(NumberFormatException exp)
		{
			JOptionPane.showMessageDialog(this, "Attention au format du nombre");
			this.txtCp.setBackground(Color.red);
		}if(nom.equals("")) {
			this.txtNomc.setBackground(Color.red);
		}else {
			this.txtNomc.setBackground(Color.white);
		}if(prenom.equals("")) {
			this.txtPrenom.setBackground(Color.red);
		}else {
			this.txtPrenom.setBackground(Color.white);
		}if(mail.equals("")) {
			this.txtMail.setBackground(Color.red);
		}else {
			this.txtMail.setBackground(Color.white);
		}if(adresse.equals("")) {
			this.txtAdresse.setBackground(Color.red);
		}else {
			this.txtAdresse.setBackground(Color.white);
		}
		if(cp > 0) {
			this.txtCp.setBackground(Color.white);
		}if(! nom.equals("") && ! prenom.equals("") && ! mail.equals("") && ! adresse.equals("") &&  cp >0)
		{
			unClient = new Client(nom, prenom, mail,adresse, cp, tel);
		}else {
			return null;
		}
			return unClient;		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btAnnuler)
		{
			this.viderChamps();
		}else if(e.getSource() == this.btEnrengister && e.getActionCommand().equals("Enrengister"))
		{
			{
				Client unClient = this.saisirClient();
				Modele.insertClient(unClient);
				unClient = Modele.selectWhereClient(null);
						{unClient.getNomc();
						unClient.getPrenomc();
						 unClient.getMailc();
						unClient.getCpc();
						unClient.getTelc();
						};
						Object ligne []={
								unClient.getNomc(),
								unClient.getPrenomc(),
								unClient.getMailc(),
								unClient.getCpc(), 
								unClient.getTelc()};
						
						unTableau.ajouterLigne(ligne);
						
					JOptionPane.showMessageDialog(this,"Insertion Reussie");
					this.viderChamps();
			}
		}
		 if (e.getSource() == this.btEnrengister && e.getActionCommand().equals("Modifier")) {
			Client unClient =this.saisirClient();
			JOptionPane.showMessageDialog(this,"Moddification Effectuer");
			int numLigne = this.uneTable.getSelectedRow();
			int codec = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
			
			unClient.setCodec(codec);
			Modele.updateClient(unClient);
			
			Object ligne []={
					unClient.getNomc(),
					unClient.getPrenomc(),
					unClient.getMailc(),
					unClient.getCpc(), 
					unClient.getTelc()};
			unTableau.modifierLigne(numLigne,ligne);
			this.btEnrengister.setText("Enrengister");

		 }
	}
}
	

 

