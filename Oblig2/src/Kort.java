
public abstract class Kort {
	private String fornavn, etternavn;
	private int pin;
	private int kortnummer;
	private static int numOfCards = 1000;
	private boolean sperretKort;
	
	public Kort(String fornavn, String etternavn, int pin, int kortnummer, int aksesskode){
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.pin = pin;
		this.kortnummer = ++numOfCards;
		sperretKort = false;
	}
	
	public String getNavn(){
	return fornavn + etternavn;
	}
	
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getPin() {
		return pin;
	}
	
	public int getKortnummer() {
		return kortnummer;
	}
	
	public boolean isSperret() {
		return sperretKort;
	}

	@Override
	public String toString() {
		return "Kort [fornavn=" + fornavn + ", etternavn=" + etternavn + "]";
	}
	
	
}
