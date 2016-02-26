import java.util.ArrayList;

public class KortTest {
	public static void main(String[] args) throws CloneNotSupportedException {

		ArrayList<Kort> kortArray = new ArrayList<>();

		Kort k1 = new Ansatt("Ola Normann", 1234, 185, 4);
		Kort k2 = new Gjest("Navn Navnesen");
		Kort k3 = new Ansatt("Daniel Liang", 2567, 178, 6);
		Kort k4 = new Gjest("Hans Hansen");
		Kort k5 = new Ansatt("Jens Jensen", 8494, 195, 8);
		Kort k6 = (Kort) k5.clone();

		kortArray.add(k1);
		kortArray.add(k2);
		kortArray.add(k3);
		kortArray.add(k4);
		kortArray.add(k5);
		kortArray.add(k6);

		System.out.println("k1.compareTo(k2) = " + k1.compareTo(k2));
		System.out.println("k3.compareTo(k4) = " + k3.compareTo(k4));
		System.out.println("k5.compareTo(k6) = " + k5.compareTo(k6));
		System.out.println("k5 == k6 is " + (k5 == k6));

		System.out.println("\n\nUsortert liste:\n");
		for (Kort kort : kortArray)
			System.out.println(kort);

		kortArray.sort(null);

		System.out.println("\n\nSortert liste:\n");
		for (Kort kort : kortArray)
			System.out.println(kort);
	}
}