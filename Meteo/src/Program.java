
public class Program {
	public static void main(String[] args) {
		Meteo meteo = new Meteo("Novembre");
		meteo.WriteAllData();
		int max = meteo.getMax();
		int min = meteo.getMin();
		int average = meteo.getAverage();
		System.out.println("MAX: " + max + " MIN: " + min + " AVERAGE: " + average);
	}
}
