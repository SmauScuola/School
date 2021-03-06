import java.io.*;

public class Main {
	
	private static void Print(String v, boolean endline) {
		if(endline)
			System.out.println(v);
		else
			System.out.print(v);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader Console = new BufferedReader(input);
		
		Print("Scrivi un numero: ", false);
		int n = Integer.valueOf(Console.readLine());
		int c = 0;
		
		//---*//
		//--**//
		//-****//
		//******//
		for(int x = n - 1; x >= 0; x--) {
			for(int i = 0; i <= x; i++)
				Print(" ", false);
			
			for(int i = -1; i < c; i++)
				Print("*", false);
			Print("", true);
			c += 2;
		}
	}
}
