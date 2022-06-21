package controleur;

public class Client {
	private int codec;
	private String nomc, prenomc, adressec, mailc;
	private int cpc, telc ;
	public Client(int codec, String nomc, String prenomc, String adressec ,String mailc, int cpc, int telc)
	{
		this.codec = codec;
		this.nomc = nomc;
		this.prenomc = prenomc;
		this.adressec = adressec;
		this.mailc = mailc;
		this.cpc = cpc;
		this.telc = telc;
	}
	public Client(String nomc, String prenomc, String adressec, String mailc, int cpc, int telc)
	{
		this.codec =0;
		this.nomc = nomc;
		this.prenomc = prenomc;
		this.adressec = adressec;
		this.mailc = mailc;
		this.cpc = cpc;
		this.telc = telc;
	}
	public int getCodec() {
		return codec;
	}
	public void setCodec(int codec) {
		this.codec = codec;
	}
	public String getNomc() {
		return nomc;
	}
	public void setNomc(String nomc) {
		this.nomc = nomc;
	}
	public String getPrenomc() {
		return prenomc;
	}
	public void setPrenomc(String prenomc) {
		this.prenomc = prenomc;
	}
	public String getAdressec() {
		return adressec;
	}
	public void setAdressec(String adressec) {
		this.adressec = adressec;
	}
	public String getMailc() {
		return mailc;
	}
	public void setMailc(String mailc) {
		this.mailc = mailc;
	}
	public int getCpc() {
		return cpc;
	}
	public void setCpc(int cpc) {
		this.cpc = cpc;
	}
	public int getTelc() {
		return telc;
	}
	public void setTelc(int telc) {
		this.telc = telc;
	}
	

}
