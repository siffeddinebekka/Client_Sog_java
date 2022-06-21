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
import controleur.Technicien;
import modele.Modele;

public class PanelTechnicien  extends PanelDeBase implements ActionListener
{
	private JPanel panelForm = new JPanel();
	private JPanel panelTable = new JPanel();
	private JButton btEnrengister = new JButton("Enrengister");
	private JButton btAnnuler = new JButton("Annuler");
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtMail = new JTextField();
	private JTextField txtDateEmbauche = new JTextField();
	private JTextField txttel = new JTextField();
	private JTable uneTable = null;
	
	private static Tableau unTableau = null;
	
	public PanelTechnicien()
	{
		super(new Color(0, 102, 255));
		this.panelForm.setLayout(new GridLayout(6,2));
		this.panelForm.add(new JLabel("Nom du Technicien"));
		this.panelForm.add(this.txtNom);
		
		this.panelForm.add(new JLabel("Prenom du Technicien"));
		this.panelForm.add(this.txtPrenom);
		
		this.panelForm.add(new JLabel("Mail du Client"));
		this.panelForm.add(this.txtMail);
		
		this.panelForm.add(new JLabel("date d'embauche du Client"));
		this.panelForm.add(this.txtDateEmbauche);
		
		this.panelForm.add(new JLabel("Telephone du Client"));
		this.panelForm.add(this.txttel);
		
	
		
		
		
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnrengister);
		
		this.panelForm.setBounds(20, 20, 300, 320);
		this.add(this.panelForm);
		
		
		this.panelTable.setBounds(340,20,380,320);
		this.panelTable.setBackground(new Color(0, 102, 255));
		this.panelTable.setLayout(null);
		String entetes[] = {"ID Technicien", "Nom", "Prenom", "Mail", "date d'embauche", "Telephone",};
		Object donnees [][] = this.getLesDonnees();
		unTableau = new Tableau(entetes, donnees);
		
		this.uneTable = new JTable(unTableau);
		JScrollPane uneScroll = new JScrollPane(this.uneTable);
		uneScroll.setBounds(10,10,340,280);
		
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
						int codet = Integer.parseInt(unTableau.getValueAt(numLigne,0).toString());
						unTableau.supprimerLigne(numLigne);
					}
							
				}else if(nbclic==1)
				{
					int numLigne = uneTable.getSelectedRow();
					String nom = unTableau.getValueAt(numLigne,1).toString();
					txtNom.setText(nom);
					String prenom = unTableau.getValueAt(numLigne,2).toString();
					txtPrenom.setText(prenom);
					String mail = unTableau.getValueAt(numLigne,3).toString();
					txtMail.setText(mail);
					String DateEmbauche = unTableau.getValueAt(numLigne,4).toString();
					txtDateEmbauche.setText(DateEmbauche);
					String telephone = unTableau.getValueAt(numLigne,5).toString();
					txttel.setText(telephone);
					btEnrengister.setText("Modifier");
				}
				
			
				
			}

			public void mousePressed(MouseEvent e) {
				
			}

			public void mouseReleased(MouseEvent e) {
				
			}

			public void mouseEntered(MouseEvent e) {
				
			}

			public void mouseExited(MouseEvent e) {
				
			}
		});
		this.btEnrengister.addActionListener(this);
		this.btAnnuler.addActionListener(this);

		}



private Object[][] getLesDonnees() {
	ArrayList<Technicien> lesTechniciens = Modele.selectAllTechniciens();
	Object [][] matrice = new Object[lesTechniciens.size()][6];
	int i = 0;
	for (Technicien unTechnicien : lesTechniciens)
	{
		matrice[i][0] = unTechnicien.getCodet();
		matrice[i][1] = unTechnicien.getNomt();
		matrice[i][2] = unTechnicien.getPrenomt();
		matrice[i][3] = unTechnicien.getMailt();
		matrice[i][4] = unTechnicien.getDateemb();
		matrice[i][5] = unTechnicien.getTelt();
		i++;
	}
	return matrice;
}
public void viderChamps()
{
	this.txtPrenom.setText("");
	this.txtDateEmbauche.setText("");
	this.txtMail.setText("");
	this.txttel.setText("");
	this.btEnrengister.setText("Enrengistrer");
}

public Technicien saisirTechnicien()
{
	Technicien unTechnicien = null;
	String nom = this.txtNom.getText();
	String prenom = this.txtPrenom.getText();
	String mail = this.txtMail.getText();
	int Dateemb = 0;
	int tel = 0;
	try {
		Dateemb =Integer.parseInt(this.txtDateEmbauche.getText());
	}
	catch(NumberFormatException exp)
	{
		JOptionPane.showMessageDialog(this, "Attention au format du nombre");
		this.txtDateEmbauche.setBackground(Color.red);
	}if(nom.equals("")) {
		this.txtNom.setBackground(Color.red);
	}else {
		this.txtNom.setBackground(Color.white);
	}if(prenom.equals("")) {
		this.txtPrenom.setBackground(Color.red);
	}else {
		this.txtPrenom.setBackground(Color.white);
	}if(mail.equals("")) {
		this.txtMail.setBackground(Color.red);
	}else {
		this.txtMail.setBackground(Color.white);
	} 
	if(Dateemb > 0) {
		this.txtDateEmbauche.setBackground(Color.white);
	}if(! nom.equals("") && ! prenom.equals("") && ! mail.equals("") )
	{
		unTechnicien = new Technicien(tel, nom, prenom, mail , Dateemb, null );
	}else {
		return null;
	}
		return unTechnicien;		
}

public void actionPerformed(ActionEvent e) {
	if(e.getSource() == this.btAnnuler)
	{
		this.viderChamps();
	}else if(e.getSource() == this.btEnrengister && e.getActionCommand().equals("Enrengister"))
	{
		{
			Technicien unTechnicien = this.saisirTechnicien();
			Modele.insertTechnicien(unTechnicien);
			unTechnicien = Modele.selectWhereTechnicien(						 
						unTechnicien.getCodet(),
						unTechnicien.getNomt(),
						unTechnicien.getPrenomt(),
						unTechnicien.getDateemb(),
						unTechnicien.getMailt());	
						
			Object ligne []={
					unTechnicien.getCodet(),
					unTechnicien.getNomt(),
					unTechnicien.getPrenomt(),
					unTechnicien.getDateemb(),
					unTechnicien.getMailt(),
					unTechnicien.getTelt()
					};
		
					
					unTableau.ajouterLigne(ligne);
					
				JOptionPane.showMessageDialog(this,"Insertion Reussie");
				this.viderChamps();
		}
	}

	
		else if (e.getSource() == this.btEnrengister && e.getActionCommand().equals("Modifier")) {
		Technicien unTechnicien =this.saisirTechnicien();
		JOptionPane.showMessageDialog(this,"Moddification Effectuer");
		int numLigne = this.uneTable.getSelectedRow();
		int codet = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
		
		unTechnicien.setCodet(codet);
		Modele.updateTechnicien(unTechnicien);
		
		Object ligne []={
				unTechnicien.getCodet(),
				unTechnicien.getNomt(),
				unTechnicien.getPrenomt(),
				unTechnicien.getDateemb(),
				unTechnicien.getMailt(),
				unTechnicien.getTelt()
				};
		unTableau.modifierLigne(numLigne,ligne);
		this.btEnrengister.setText("Enrengister");

	 }
	}
}




