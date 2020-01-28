public class Date {
	
	public enum Months
	{
		Gennaio,
		Febbraio,
		Marzo,
		Aprile,
		Maggio,
		Giugno,
		Luglio,
		Agosto,
		Settembre,
		Ottobre,
		Novembre,
		Dicembre
	}
	
	private int Day;
	private int Month;
	private int Year;
	
	public Date(int d, int m, int y)
	{
		Day = d;
		Month = m;
		Year = y;
	}
	
	public Date()
	{
		Day = 0;
		Month = 0;
		Year = 0;
	}
	
	public boolean isNull()
	{
		return Day == 0 && Month == 0 && Year == 0;
	}
	
	public String getMonth()
	{
		switch(Month)
		{
			case 1:
				return "Gennaio";
			case 2:
				return "Febbraio";
			case 3:
				return "Marzo";
			case 4:
				return "Aprile";
			case 5:
				return "Maggio";
			case 6:
				return "Giugno";
			case 7:
				return "Luglio";
			case 8:
				return "Agosto";
			case 9:
				return "Settembre";
			case 10:
				return "Ottobre";
			case 11:
				return "Novembre";
			case 12:
				return "Dicembre";
			default:
				return "Error";
		}
	}
	
	public boolean isBisestile()
	{
		boolean res;
		if(Year % 4 == 0)
		{
			if(Year % 100 == 0 && Year % 400 == 0)
				res = true;
			else if(Year % 100 != 0)
				res = true;
			else
				res = false;
		}
		else
			res = false;
		return res;
	}
	
	public int getDay()
	{
		return Day;
	}
	
	public int getMonthByNumber()
	{
		return Month;
	}
	
	public int getYear()
	{
		return Year;
	}
	
	private int getEndDay()
	{
		try
		{
			int day = 0;
			Months actualMonth = Months.values()[Month - 1];
			
			switch(actualMonth)
			{
				case Gennaio:
					day = 31;
					break;
				case Febbraio:
					if(isBisestile()) day = 29;
					else day = 28;
					break;
				case Marzo:
					day = 31;
					break;
				case Aprile:
					day = 30;
					break;
				case Maggio:
					day = 31;
					break;
				case Giugno:
					day = 30;
					break;
				case Luglio:
					day = 31;
					break;
				case Agosto:
					day = 31;
					break;
				case Settembre:
					day = 30;
					break;
				case Ottobre:
					day = 31;
					break;
				case Novembre:
					day = 30;
					break;
				case Dicembre:
					day = 31;
					break;
			}
			
			return day;
		}
		catch(Exception ex)
		{
			return -1;
		}
	}
	
	public void addDays(int days)
	{
		int delta = this.Day + days;
		if(delta > getEndDay())
		{
			this.Day = delta - getEndDay();
			addMonths(1);
		}
		else
			this.Day = delta;
	}
	
	public void addMonths(int months)
	{
		int delta = this.Month + months;
		if(delta > 12)
		{
			this.Month = 1;
			this.Day = 1;
			addYears(1);
		}
		else 
			this.Month = delta;
	}
	
	public void addYears(int years)
	{
		this.Year += years;
	}

	public static Date Compare(Date d1, Date d2)
	{
		int d = Math.abs(d2.getDay() - d1.getDay());
		int m = Math.abs(d2.getMonthByNumber() - d1.getMonthByNumber());
		int y = Math.abs(d2.getYear() - d1.getYear());
		
		return new Date(d, m, y);
	}

	public int CalcolaInGiorni()
	{
		int originalMonth = this.Month;
		int elapsedDays = 0;
		for(int m = 0; m < originalMonth - 1; m++)
		{
			this.Month = m+1;
			elapsedDays += this.getEndDay();
		}
		
		this.Month = originalMonth;
		return this.Day + elapsedDays;
	}
	
	public static void main(String[] args)
	{
		Date date = new Date(12, 11, 2019);
		System.out.println(date.getYear() + " Bisestile: " + date.isBisestile());
		date.addYears(2);
		date.addMonths(2);
		date.addDays(33);
		System.out.println("New date: " + date.getDay() + "/" + date.getMonth() + "/" + date.getYear());
		System.out.println("Elapsed Days: " + date.CalcolaInGiorni());
	}
}
