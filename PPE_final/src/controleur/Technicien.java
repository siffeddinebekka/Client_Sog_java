package controleur;

public class Technicien {
	private int codet;
	private String nomt, prenomt , mailt;
	int telt;
	private String dateemb;
	
	public Technicien(int codet, String nomt, String prenomt, String mailt, int telt,String dateemb)
	{
		this.codet =codet;
		this.nomt = nomt;
		this.prenomt = prenomt;
		this.mailt = mailt;
		this.telt = telt;
		this.dateemb = dateemb;
		
	}
	public Technicien(String nomt, String prenomt, String mailt, int telt,String dateemb, String adresset)
	{
		this.codet =0;
		this.nomt = nomt;
		this.prenomt = prenomt;
		this.mailt = mailt;
		this.dateemb = dateemb;
		
	}
	public int getCodet() {
		return codet;
	}
	public void setCodet(int codet) {
		this.codet = codet;
	}
	public String getNomt() {
		return nomt;
	}
	public void setNomt(String nomt) {
		this.nomt = nomt;
	}
	public String getPrenomt() {
		return prenomt;
	}
	public void setPrenomt(String prenomt) {
		this.prenomt = prenomt;
	}
	public String getMailt() {
		return mailt;
	}
	public void setMailt(String mailt) {
		this.mailt = mailt;
	}
	public int getTelt() {
		return telt;
	}
	public void setTelt(int telt) {
		this.telt = telt;
	}
	public String getDateemb() {
		return dateemb;
	}
	public void setDateemb(String dateemb) {
		this.dateemb = dateemb;
	}	
}
