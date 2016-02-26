import java.util.Calendar;
import java.util.GregorianCalendar;

public class Gjest extends Kort {

	private GregorianCalendar gyldigTil;
	private String type;

	public Gjest() {
		this("");
	}

	public Gjest(String navn) {
		super(navn, 9999);
		gyldigTil = new GregorianCalendar();
		gyldigTil.add(Calendar.DAY_OF_MONTH, 7);
		type = "G";
	}

	@Override
	public boolean checkPin(int pin) {
		return super.getPin() == pin;
	}

	@Override
	public boolean isSperret() {
		return (gyldigTil.compareTo(new GregorianCalendar()) > 0) ? false : true;
	}

	@Override
	public boolean pinRequired() {
		return true;
	}

	@Override
	public String getFornavn() {
		String fornavn = "";
		for (int i = 0; i < super.getNavn().length(); i++) {
			if (super.getNavn().charAt(i) == ' ')
				break;
			fornavn += super.getNavn().charAt(i);
		}
		return fornavn;
	}
	
	@Override
	public void setFornavn(String fornavn) {
		super.setNavn(fornavn + " " + getEtternavn());
	}

	@Override
	public String getEtternavn() {
		String etternavn = "";
		for (int i = 0; i < super.getNavn().length(); i++) {
			etternavn += super.getNavn().charAt(i);
			if (super.getNavn().charAt(i) == ' ')
				etternavn = "";
		}
		return etternavn;
	}
	
	@Override
	public void setEtternavn(String etternavn) {
		super.setNavn(getFornavn() + " " + etternavn);
	}

	@Override
	public int compareTo(Kort o) {
		if (getEtternavn().compareTo(o.getEtternavn()) != 0)
			return getEtternavn().compareTo(o.getEtternavn());
		else if (getEtternavn().compareTo(o.getEtternavn()) == 0 && getFornavn().compareTo(o.getFornavn()) != 0)
			return getFornavn().compareTo(o.getFornavn());
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "| "+ type + " |\t" + super.toString();
	}
}