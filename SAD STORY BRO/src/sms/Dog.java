package sms;
public class Dog {
	private String Name;
	private Dice stolenDice;
	
	public Dog(String name, Dice dice)
	{
		Name = name;
		stolenDice = dice;
	}
	
	public String GetName()
	{
		return Name;
	}
	
	public int Fall()
	{
		int res = stolenDice.GetValue();
		return res;
	}
}
