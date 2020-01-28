import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sms.*;

public class Main {

	private static void StartMeteoStory(BufferedReader Console) throws IOException {
		String month = "Dicembre";
		Meteo meteo = new Meteo(month);
		
		System.out.println("\nArrivo a casa e controllo il meteo su notfakemeteo.com e sul sito sono riportati i seguenti valori: ");
		System.out.println(" -- " + month + " - Via kiwi --");
		System.out.println(" Temp max: " + meteo.getMax() + "\n Temp min: " + meteo.getMin());
		System.out.println(" Media: " + meteo.getAverage());
		if(meteo.getMin() < 3) {
			System.out.println("Capisco che in questo mese farà freddo e quindi vado a dormire triste e depresso perchè sono solo e non ce nessuno che mi vuole comprare una stufa!");
		}
		else {
			BankAccount bank = new BankAccount();
			
			System.out.println(" Ho deciso di comprare una stufa per i giorni più freddi quindi controllo sotto il letto per vedere quanto ho risparmiato!");
			System.out.println("Quanto ho trovato? ");
			int bigMoney = Integer.parseInt(Console.readLine());
			bank.Deposits(bigMoney);
			if(bigMoney >= 300)
				System.out.println("Wow ho trovato i soldi necessari! Ora vado e compro una stufa");
			else
				System.out.println("Nooo non mi bastano... li deposito lo stesso e poi vado a deprimerimi!");
		}
	}
	
	public static void main(String[] args) throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader Console = new BufferedReader(input);
		
		Dice favouriteDice = new Dice(6);
		Dog dog = new Dog("Rex", favouriteDice);
		Person me = new Person("Alex", dog);
		System.out.println(me.GetName() + " diary...");
		me.StartDay();
		
		StartMeteoStory(Console);
	}
}
