package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Bdd {
	private String serveur, bdd, PASSWORD;
	private String Admin;
	private Connection maConnexion;
	
	public Bdd(String serveur ,String bdd , String Admin, String PASSWORD)
	{
		this.serveur = serveur;
		this.bdd = bdd;
		this.Admin = Admin;	
		this.PASSWORD = PASSWORD;
		this.maConnexion = null;				
	}
	public void seConnecter()
	{
		String url = "jdbc:mysql://"+this.serveur+"/"+this.bdd; 
		url += "?verifyServerCertificate=false&useSSL=false"; 
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException exp)
		{
			System.out.println("Abscence du pilote jdbc");
		}
		try {
			this.maConnexion = DriverManager.getConnection(url,this.Admin,this.PASSWORD);
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur de connexion a : " +url);
			exp.printStackTrace();
		}
	}
	public void seDeconnecter()
	{
		try {
			if (this.maConnexion != null)
			{
				this.maConnexion.close();
			}
		}
		catch(SQLException exp)
		{
			System.out.println("erreur de déconnexion au serveur.");
		}
	}
	public Connection getMaConnexion ()
	{
		return this.maConnexion;
	}
}
