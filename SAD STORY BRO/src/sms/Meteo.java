package sms;
public class Meteo {
	private String MonthName;
	private int[] Temperature = new int[30];
	
	public Meteo(String nameMonth) {
		MonthName = nameMonth;
		int max = 0, min = 0;
		if(nameMonth == "Dicembre" || nameMonth == "Novembre" || nameMonth == "Gennaio" || nameMonth == "Febbraio")
		{
			max = 18;
			min = -5;
		}
		else if(nameMonth == "Ottobre" || nameMonth == "Settembre")
		{
			max = 23;
			min = 7;
		}
		else
		{
			max = 45;
			min = 8;
		}
		
		for(int i = 0; i  < Temperature.length; i++) {
			Temperature[i] = (int) (Math.random() * (max-min) + min);
		}
	}
	
	public void WriteAllData() {
		for(int i = 0; i < Temperature.length; i++)
			System.out.println(Temperature[i]);
	}
	
	public int getMax() {
		int max = Temperature[0];
		for(int i = 0; i < Temperature.length; i++)
		{
			if(Temperature[i] > max)
				max = Temperature[i];
		}
		
		return max;
	}
	
	public int getMin() {
		int min = Temperature[0];
		for(int i = 0; i < Temperature.length; i++)
		{
			if(Temperature[i] < min)
				min = Temperature[i];
		}
		
		return min;
	}
	
	public int getAverage() {
		int media = 0;
		for(int i = 0; i < Temperature.length; i++)
			media += Temperature[i];
		return media / Temperature.length;
	}
}
