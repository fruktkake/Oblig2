import java.util.Calendar;
import java.util.GregorianCalendar;

public class Ansatt extends Kort implements Konstanter {

	private final double kreditt = 0.05;
	private final int bonus = 3;
	private double timelønn;
	private int ansiennitet;
	private String type;
	
	public Ansatt(){
		this("", 0, 0, 0);
	}
	
	public Ansatt(String navn, int pin, double timelønn, int ansiennitet){
		super(navn, pin);
		this.timelønn = timelønn;
		this.ansiennitet = ansiennitet;
		type = "A";
	}

	@Override
	public boolean checkPin(int pin) {
		return super.getPin() == pin;
	}

	@Override
	public boolean pinRequired() {
		GregorianCalendar now = new GregorianCalendar();
		return (now.get(Calendar.DAY_OF_WEEK) > 1 && now.get(Calendar.DAY_OF_WEEK) < 7
				&& now.get(Calendar.HOUR_OF_DAY) > 6 && now.get(Calendar.HOUR_OF_DAY) < 17) ? false : true;
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
	public void setFornavn(String fornavn) {
		super.setNavn(fornavn + " " + getEtternavn());
	}

	@Override
	public void setEtternavn(String etternavn) {
		super.setNavn(getFornavn() + " " + etternavn);
	}
	
	@Override
	public void setFulltNavn(String navn) {
		super.setNavn(navn);
	}

	@Override
	public String getFulltNavn() {
		return super.getNavn();
	}

	@Override
	public double beregnKreditt() {
		return kreditt * timelønn;
	}

	@Override
	public double beregnBonus() {
		return bonus * ansiennitet;
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
		return "| " + type + " |\t" + super.toString();
	}

}
