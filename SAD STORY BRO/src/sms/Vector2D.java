package sms;

public class Vector2D {
	private float X;
	private float Y;
	
	public Vector2D(float x, float y)
	{
		X = x;
		Y = y;
	}
	
	public void Translate(float x, float y)
	{
		X = x;
		Y = y;
	}
	
	public float Distance()
	{
		return (float) Math.sqrt(Math.pow(X, 2) + Math.pow(Y, 2));
	}
	
	public float GetX()
	{
		return X;
	}
	
	public float GetY()
	{
		return Y;
	}
}
