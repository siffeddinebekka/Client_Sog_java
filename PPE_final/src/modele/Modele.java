package modele;
 



import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Admin;
import controleur.Client;
import controleur.Intervention;
import controleur.Technicien;

public class Modele {
	private static Bdd uneBdd=new Bdd("localhost:8890","orange","root", "root");
	
	

	
	public static int countClients()
	{
		int nbclients = 0;
		String requete = "select count(*) as nb from Client ;";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbclients = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur de requete : "+requete);
		}
		return nbclients;
	}
	public static Admin selectWhereAdmin (String USERNAME, String PASSWORD)  {
		Admin unAdmin = null;  
		String requete = "select * from admin where USERNAME='"+USERNAME
				+"'   and  PASSWORD ='" + PASSWORD + "' ; ";
				 ;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete);
			//extraction d'un user : fetch en PHP 
			if (unResultat.next()) //s'il y a un resultat 
			{
				 unAdmin = new Admin (
					unResultat.getString("USERNAME"), unResultat.getString("PASSWORD")
					
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return unAdmin; 
}
	public static int countIntervention() {
		int nbinterventions=0;
		String requete ="select count(*) as nb from intervention ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbinterventions = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbinterventions;
	}
	public static void deleteIntervention(int Codei) {
		 
		String requete ="delete from intervention where Codei  ="+Codei;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		
	}
	public static int countTechnicien() {
		int nbtechniciens=0;
		String requete ="select count(*) as nb from technicien; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbtechniciens = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbtechniciens;
	}
	public static void insertClient (Client unClient)
	{
		String requete ="insert into client values (null, '"
				+ unClient.getNomc()+"','" + unClient.getPrenomc()+"','"
				+ unClient.getAdressec()+"','" + unClient.getMailc()+"','"
				+ unClient.getTelc()+"');"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	
	public static void updateClient (Client unClient)
	{
		String requete ="update pilote set nom = '"
				+ unClient.getNomc()+"', prenom='" + unClient.getPrenomc()+"',adresse='"
				+ unClient.getAdressec()+"',mail='" + unClient.getMailc()+"',tel='"
				+ unClient.getTelc()+"'  where Codec="+unClient.getCodec()+";"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	
	public static ArrayList<Client> selectAllClients ()
	{
		ArrayList<Client> lesClients = new ArrayList<Client>(); 
		String requete = "select * from client;  ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
			//extraction des pilotes : fetchAll en PHP 
			while (desResultats.next()) //tant qu'il un resultat suivant
			{
				Client unClient = new Client (
						desResultats.getString("tel"), 
						desResultats.getString("nomc"), 
						desResultats.getString("prenom"),
						desResultats.getString("adressec"), 
						desResultats.getInt("mail"), 
						desResultats.getInt("codec")
						);
				//on ajoute le pilote dans la liste des pilotes 
				lesClients.add(unClient); 
			}
			
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesClients; 
	}

	
	
	
	public static void insertIntervention (Intervention uneIntervention)
	{
		String requete ="insert into intervention values (null, '"
				+ uneIntervention.getDatetimei()+"','" + uneIntervention.getObjet()+"','"
				+ uneIntervention.getAdressei()+"','" + uneIntervention.getNomc()+"','"
				+ uneIntervention.getCodec()+"','" +uneIntervention.getNomt()+"');"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	public static void insertTechnicien (Technicien unTechncien)
	{
		String requete ="insert into technicien values (null, '"
				+ unTechncien.getNomt()+"','" + unTechncien.getPrenomt()+"','"
				+ unTechncien.getDateemb()+"','" + unTechncien.getMailt()+"','"
				+ unTechncien.getTelt()+"');"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	public static void updateTechnicien (Technicien unTechnicien)
	{
		String requete ="update technicien set nom = '"
				+ unTechnicien.getNomt()+"', prenom='" + unTechnicien.getPrenomt()+"',date='"
				+ unTechnicien.getDateemb()+"',mail='" + unTechnicien.getMailt()+"',tel='"
				+ unTechnicien.getTelt()+"'  where Codec="+unTechnicien.getCodet()+";"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	public static void updateIntervention(Intervention uneIntervention)
	{
		String requete ="update intervention set nom = '"
				+ uneIntervention.getNomc()+"', object='" + uneIntervention.getObjet()+"',date='"
				+ uneIntervention.getDatetimei()+"',adresse='" + uneIntervention.getAdressei()
				+"'  where Codec="+uneIntervention.getCodec()+"'  where Codec="+uneIntervention.getCodec()+ ";"; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
	}
	public static ArrayList<Technicien> selectAllTechniciens ()
	{
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>(); 
		String requete = "select * from technicien ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
			//extraction des pilotes : fetchAll en PHP 
			while (desResultats.next()) //tant qu'il un resultat suivant
			{
				Technicien unTechnicien = new Technicien (
						desResultats.getInt("codet"),
						desResultats.getString("nomt"),
						desResultats.getString("prenomt"),
						desResultats.getString("mailt"),
						desResultats.getInt("telt"),
						desResultats.getString("dateemb")
						);
				//on ajoute le pilote dans la liste des pilotes 
				lesTechniciens.add(unTechnicien); 
			}
			
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesTechniciens; 
	}
	
	public static ArrayList<Intervention> selectAllInterventions ()
	{
		ArrayList<Intervention> lesInterventions = new ArrayList<Intervention>(); 
		String requete = "select * from intervention ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
			//extraction des pilotes : fetchAll en PHP 
			while (desResultats.next()) //tant qu'il un resultat suivant
			{
				Intervention uneIntervention = new Intervention(
						desResultats.getInt("codei"),
						desResultats.getInt("codec"),
						desResultats.getString("adressei"),
						desResultats.getString("objet"),
						desResultats.getString("nomc"),
						desResultats.getString("nomt"),
						desResultats.getString("datetimei")
						);
				//on ajoute le pilote dans la liste des pilotes 
				lesInterventions.add(uneIntervention); 
			}
			
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return lesInterventions; 
	}
	public static Intervention selectWhereIntervention (int codei,  int codec, String adressei, String objet,String nomc, String nomt,String datetimei)  {
		Intervention uneIntervention = null;  
		String requete = "select * from intervention where codei='"+codei + "' ; ";
			
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete);
			//extraction d'un user : fetch en PHP 
			if (unResultat.next()) //s'il y a un resultat 
			{
				
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return uneIntervention; 
}
	public static Technicien selectWhereTechnicien (int codet, String nomt, String prenomt, String Mailt, String Dateemb)  {
		Technicien unTechnicien = null;  
		String requete = "select * from technicien where codet='"+codet + "' ; ";
				 ;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete);
			//extraction d'un user : fetch en PHP 
			if (unResultat.next()) //s'il y a un resultat 
			{
				unTechnicien = new Technicien (
						unResultat.getInt("codet"),
						unResultat.getString("nomt"),
						unResultat.getString("prenomt"),
						unResultat.getString("mailt"),
						unResultat.getInt("telt"),
						unResultat.getString("dateemb")	
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return unTechnicien; 
	
}
	public static Client selectWhereClient (String nomc)  {
	Client unClient = null;  
		String requete = "select * from client where nomc='"+nomc
				 + "' ; ";
				 ;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat = unStat.executeQuery(requete);
			//extraction d'un user : fetch en PHP 
			if (unResultat.next()) //s'il y a un resultat 
			{
				unClient = new Client (
				
								unResultat.getString("tel"), 
								unResultat.getString("nomc"), 
								unResultat.getString("prenom"),
								unResultat.getString("adresse"), 
								unResultat.getInt("mail"), 
								unResultat.getInt("codec")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		return unClient; 
	}
}

