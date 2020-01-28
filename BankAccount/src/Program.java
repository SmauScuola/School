import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Program {
	private static void Scegli(BufferedReader Console, BankAccount conto)
	{	
		try
		{
			System.out.println("Cosa vuoi fare? ");
			String resp = Console.readLine();
			switch(resp)
			{
				case "Deposita": 
					System.out.println("Quanto vuoi depositare?");
					int value = Integer.parseInt(Console.readLine());
					conto.Deposits(value);
					break;
				case "Preleva":
					System.out.println("Quanto vuoi prelevare?");
					value = Integer.parseInt(Console.readLine());
					conto.Taking(value);
					break;
				default:
					System.out.println("Uscita...");
					System.exit(1);
					break;
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args)
	{	
		BankAccount conto = new BankAccount();
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader Console = new BufferedReader(input);
		while(true) //Usato per la richiesta continua... comunque ogni volta che non esegue un comando esistente chiude l' applicazione.
		{
			Scegli(Console, conto);
			System.out.println(conto.getLastTransaction() + " - " + conto.getBalance() + "/" + conto.NormalBalance + " - Hai debiti? " + conto.HaveDebts());
		}
	}
}
