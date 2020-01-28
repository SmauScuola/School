import java.util.Scanner;

public class Time {
	
	private int Hour;
	private int Minute;
	private int Second;
	
	public Time()
	{
		Hour = 0;
		Minute = 0;
		Second = 0;
	}
	
	public Time(int h, int m, int s)
	{
		Hour = h;
		Minute = m;
		Second = s;
	}
	
	public int getHour()
	{
		return Hour;
	}
	
	public int getMinute()
	{
		return Minute;
	}
	
	public int getSecond()
	{
		return Second;
	}
	
	public void addHour(int val)
	{
		int delta = Hour + val;
		if(delta >= 24)
		{
			Hour = 0;
			Minute = 0;
			Second = 0;
			addSecond(delta - 60);
			addMinute(delta - 60);
			addHour(delta - 24);
			addHour(24 - delta);
		}
		else
			Hour = delta;
			
	}
	
	public void addMinute(int val)
	{
		int delta = Minute + val;
		if(delta >= 60)
		{
			Minute = 0;
			Second = 0;
			addHour(1);
			addMinute(delta - 60);
		}
		else
			Minute = delta;
	}
	
	public void addSecond(int val)
	{
		int delta = Second + val;
		if(delta >= 60)
		{
			Second = 0;
			addMinute(1);
			addSecond(delta - 60);
		}
		else
			Second = delta;
	}
	
	public static Time Compare(Time time1, Time time2)
	{
		int hour = Math.abs(time2.getHour() - time1.getHour());
		int minute = Math.abs(time2.getMinute() - time1.getMinute());
		int second = Math.abs(time2.getSecond() - time1.getSecond());
		
		return new Time(hour, minute, second);
	}
	
	public int getElapsedTime()
	{
		int h = this.Hour * 60 * 60;
		int m = this.Minute * 60;
		
		return h + m + this.Second;
	}
	
	public static void main(String[] args)
	{
		int h, m , s;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Scrivi l' ora: ");
		h = scanner.nextInt();
		
		System.out.print("Scrivi i minuto: ");
		m = scanner.nextInt();
		
		System.out.print("Scrivi i secondi: ");
		s = scanner.nextInt();
		
		Time time = new Time(h, m, s);
		Time elapsedTime = Time.Compare(new Time(6, 30, 0), time);
		
		System.out.println("Inserito: " + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
		System.out.println("Compare: " + elapsedTime.getHour() + ":" + elapsedTime.getMinute() + ":" + elapsedTime.getSecond());
		System.out.println("Elapsed in secondi: " + time.getElapsedTime());
	}
}
