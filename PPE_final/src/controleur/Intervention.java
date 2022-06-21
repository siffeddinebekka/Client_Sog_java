package controleur;

public class Intervention{
	private int codei, codec;
	private String adressei, objet;
	private String nomc, nomt;
	private String datetimei;
	
	public Intervention(int codei , int codec, String adressei, String objet,String nomc, String nomt,String datetimei) {
		this.codei = codei;
		this.codec = codec;
		this.adressei = adressei;
		this.objet = objet;
		this.nomc = nomc;
		this.nomt = nomt;
		this.datetimei = datetimei;
			
	}
	public Intervention(String adressei, String objet, String nomc, String nomt,String datetimei) {
		this.codei = 0;
		this.codec = 0;
		this.adressei = adressei;
		this.objet = objet;
		this.nomc = nomc;
		this.nomt = nomt;
		this.datetimei = datetimei;
			
	}
	public int getCodei() {
		return codei;
	}
	public void setCodei(int codei) {
		this.codei = codei;
	}
	public int getCodec() {
		return codec;
	}
	public void setCodec(int codec) {
		this.codec = codec;
	}
	public String getAdressei() {
		return adressei;
	}
	public void setAdressei(String adressei) {
		this.adressei = adressei;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getNomc() {
		return nomc;
	}
	public void setNomc(String nomc) {
		this.nomc = nomc;
	}
	public String getNomt() {
		return nomt;
	}
	public void setNomt(String nomt) {
		this.nomt = nomt;
	}
	public String getDatetimei() {
		return datetimei;
	}
	public void setDatetimei(String datetimei) {
		this.datetimei = datetimei;
	}
	
	
	
}