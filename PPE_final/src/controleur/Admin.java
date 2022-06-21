package controleur;

public class Admin {
	private int ID;
	private String USERNAME, PASSWORD;
	
	public Admin(int ID, String USERNAME, String PASSWORD)
	{
		this.ID = ID;
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
	}
	public Admin(String USERNAME, String PASSWORD)
	{
		this.ID = 0;
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUSERNAME() {
		return USERNAME;
	}
	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	
	
	
}
