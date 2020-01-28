import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void Main(String[] args) throws NumberFormatException, IOException {
		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader Console = new BufferedReader(input);
		
		System.out.print("Inserisci un numero: ");
		int n = Integer.valueOf(Console.readLine());
	}
}
