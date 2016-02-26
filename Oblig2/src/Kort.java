
public abstract class Kort implements Comparable<Kort>, Cloneable {

	private String navn;
	private int pin;
	private int kortnummer;
	private static int numOfCards = 1000;
	private boolean sperretKort;
	
	protected Kort(){
	}
	
	protected Kort(String navn, int pin){
		this.navn = navn;
		this.pin = pin;
		this.kortnummer = ++numOfCards;
		sperretKort = false;
	}
	
	public String getNavn(){
	return navn;
	}
	
	public void setNavn(String navn){
		this.navn = navn;
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
		return "Kortinnehaver: " + getEtternavn() + ", " + getFornavn() + "\tKortnummer: " + kortnummer + "\tPIN: "
				+ pin + "\tKort sperret: " + isSperret();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public abstract boolean checkPin(int pin);
	
	public abstract boolean pinRequired();
	
	public abstract String getFornavn();
	
	public abstract String getEtternavn();
	
	public abstract void setFornavn(String fornavn);

	public abstract void setEtternavn(String etternavn);
	
	
}
