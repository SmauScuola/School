package sms;
public class Dice {
	private int Faces;
	
	public Dice(int faces)
	{
		Faces = faces;
	}
	
	public int GetValue()
	{
		return (int) (Math.random()*Faces+1);
	}
}
