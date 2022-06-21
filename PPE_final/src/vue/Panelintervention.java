package vue;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Intervention;
import controleur.Tableau;
import modele.Modele;

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

public class Panelintervention extends PanelDeBase implements ActionListener
{

private JPanel panelForm = new JPanel();
private JPanel panelTable = new JPanel();
private JButton btEnrengister = new JButton("Enrengister");
private JButton btAnnuler = new JButton("Annuler");
private JTextField txtNomClient = new JTextField();
private JTextField txtNomTechnicien = new JTextField();
private JTextField txtObjet = new JTextField();
private JTextField txtAdresse = new JTextField();
private JTextField txtDateIntervention = new JTextField();

private JTable uneTable = null;
private static Tableau unTableau = null;

public Panelintervention() {
	super(new Color(0, 102, 255));
	this.panelForm.setLayout(new GridLayout(6,2));
	this.panelForm.add(new JLabel("Nom du Technicien"));
	this.panelForm.add(this.txtNomTechnicien);
	
	this.panelForm.add(new JLabel("Nom du Client"));
	this.panelForm.add(this.txtNomClient);
	
	this.panelForm.add(new JLabel("Object de l'intervention"));
	this.panelForm.add(this.txtObjet);

	this.panelForm.add(new JLabel("Adresse de l'intervention"));
	this.panelForm.add(this.txtAdresse);
	
	this.panelForm.add(new JLabel("Date de l'intervention"));
	this.panelForm.add(this.txtDateIntervention);
	
	
	this.panelForm.add(this.btAnnuler);
	this.panelForm.add(this.btEnrengister);
	
	this.panelForm.setBounds(20, 20, 300, 320);
	this.add(this.panelForm);
	
	this.panelTable.setBounds(340, 20, 380, 320);
	this.panelTable.setBackground(new Color(0, 102, 255));
	this.panelTable.setLayout(null);
	String entetes[]= {"ID Intervention" ,"ID Client", "NomClient","Objet","Adresse","DateIntervention",};
	Object donnees [][] = this.getLesDonnes();
	unTableau = new Tableau(entetes, donnees);
	
	this.uneTable = new JTable(unTableau);
	JScrollPane uneScroll = new JScrollPane(this.uneTable);
	uneScroll.setBounds(10,10,340,280);
	
	this.panelTable.add(uneScroll);
	this.add(this.panelTable);
	this.uneTable.addMouseListener(new MouseListener() {
		public void mouseClicked(MouseEvent e ){
			int nbclic = e.getClickCount();
			if(nbclic == 2)
			{
				int numLigne = uneTable.getSelectedRow();
				int retour = JOptionPane.showConfirmDialog(null, "Voulez vous supprimer un Client ? ", "Suppresion du Client", JOptionPane.YES_NO_OPTION);
				if(retour == 0)
				{
					int Codei = Integer.parseInt(unTableau.getValueAt(numLigne,0).toString());
					Modele.deleteIntervention(Codei);
					unTableau.supprimerLigne(numLigne);
				}
			}else if(nbclic == 1)
			{
				int numLigne = uneTable.getSelectedRow();
				String nomClient = unTableau.getValueAt(numLigne, 2).toString();
				txtNomClient.setText(nomClient);
				String nomTechnicien  = unTableau.getValueAt(numLigne, 3).toString();
				txtNomTechnicien.setText(nomTechnicien);
				String objet = unTableau.getValueAt(numLigne, 4).toString();
				txtObjet.setText(objet);
				String Adresse = unTableau.getValueAt(numLigne, 5).toString();
				txtAdresse.setText(Adresse);
				String DateIntervention = unTableau.getValueAt(numLigne, 6).toString();
				txtDateIntervention.setText(DateIntervention);
				btEnrengister.setText("Modifier");
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	});
	this.btEnrengister.addActionListener(this);
	this.btAnnuler.addActionListener(this);
	
	


}




private Object[][] getLesDonnes(){
	ArrayList<Intervention> lesInterventions = Modele.selectAllInterventions();
	Object [][] matrice = new Object[lesInterventions.size()][7];
	int i = 0;
	for(Intervention uneIntervention : lesInterventions)
	{
		matrice [i][0] = uneIntervention.getCodei();
		matrice [i][1] = uneIntervention.getCodec();
		matrice [i][2] = uneIntervention.getNomc();
		matrice [i][3] = uneIntervention.getNomt();
		matrice [i][4] = uneIntervention.getAdressei();
		matrice [i][5] = uneIntervention.getObjet();
		matrice [i][6] = uneIntervention.getDatetimei();
		i++;
	}
	return matrice;
}
public void viderChamps()
	{
		this.txtNomClient.setText("");
		this.txtNomTechnicien.setText("");
		this.txtAdresse.setText("");
		this.txtDateIntervention.setText("");
		this.txtObjet.setText("");
		this.btEnrengister.setText("Enrengister");
	}
public Intervention saisirInterventions()
{
	Intervention uneIntervention = null;
	String nomClient = this.txtNomClient.getText();
	String nomTechicien = this.txtNomTechnicien.getText();
	String Adresse = this.txtAdresse.getText();
	String Object = this.txtObjet.getText();
	String Datetimei = this.txtDateIntervention.getText();
	
		JOptionPane.showMessageDialog(this,"Attention au Format");
		this.txtNomClient.setBackground(Color.red);
if(nomClient.equals("")) {
	this.txtNomClient.setBackground(Color.red);
}else {
	this.txtNomClient.setBackground(Color.white);
}if(nomTechicien.equals("")) {
	this.txtNomTechnicien.setBackground(Color.red);
}else {
	this.txtNomTechnicien.setBackground(Color.white);
}if(Adresse.equals("")) {
	this.txtAdresse.setBackground(Color.red);
}else {
	this.txtAdresse.setBackground(Color.white);
}if(Object.equals("")) {
	this.txtObjet.setBackground(Color.red);
}else {
	this.txtObjet.setBackground(Color.white);
}if(Datetimei.equals("")) {
	this.txtDateIntervention.setBackground(Color.red);
}else {
	this.txtDateIntervention.setBackground(Color.white);
}
if(!nomClient.equals("") && ! nomTechicien.equals("") && ! Adresse.equals("") && Object.equals("") && Datetimei.equals(""))
{
	uneIntervention = new Intervention(nomClient, nomTechicien, Adresse, Object, Datetimei);
}else {
	return null;
}
return uneIntervention;
	
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource() == this.btAnnuler)
	{
		this.viderChamps();
	}else if(e.getSource() == this.btEnrengister && e.getActionCommand().equals("Enrengister"))

		{
			Intervention uneIntervention = this.saisirInterventions();
			Modele.insertIntervention(uneIntervention);
			uneIntervention = Modele.selectWhereIntervention(
					uneIntervention.getCodei(),
					uneIntervention.getCodec(),
					uneIntervention.getAdressei(),
					uneIntervention.getObjet(),
					uneIntervention.getNomc(),
					uneIntervention.getNomt(),
					uneIntervention.getDatetimei());
			Object ligne[] = {
					uneIntervention.getCodec(), 
					uneIntervention.getCodei(),
					uneIntervention.getNomc(), 
					uneIntervention.getNomt(),
					uneIntervention.getAdressei(),
					uneIntervention.getObjet(),
					uneIntervention.getDatetimei()
					};
		
					
					unTableau.ajouterLigne(ligne);
					
					
					JOptionPane.showMessageDialog(this, "Insertion Reussie");
					this.viderChamps();
		}
		else if(e.getSource() == this.btEnrengister && e.getActionCommand().equals("Modifier")) {
			Intervention uneIntervention = this.saisirInterventions();
			
			JOptionPane.showMessageDialog(this,"Modification effectuer");
			int numLigne = this.uneTable.getSelectedRow();
			
			int codei = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
			
			uneIntervention.setCodei(codei);
			Modele.updateIntervention(uneIntervention);
			
			int Codei = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
			
			uneIntervention.setCodei(Codei);
			Modele.updateIntervention(uneIntervention);
			
			Object ligne[] = {
					uneIntervention.getCodec(), 
					uneIntervention.getCodei(),
					uneIntervention.getNomc(), 
					uneIntervention.getNomt(),
					uneIntervention.getAdressei(),
					uneIntervention.getObjet(),
					uneIntervention.getDatetimei()
					};
			unTableau.modifierLigne(numLigne, ligne);
			this.btEnrengister.setText("Enrengister");
			}
		}
}
	
	
	
	
	
	
	
	
	
	
	
	