package sms;
public class Person {
	
	private String Name;
    private Dog ownDog;
    private Vector2D Position = new Vector2D(0, 0);
    private float elapsedTime;
    
    public Person(String name, Dog dog)
    {
    	Name = name;
    	ownDog = dog;
    }
    
    public String GetName()
    {
    	return Name;
    }
    
    public void StartDay()
    {
    	System.out.println("Mi sono svegliato e ho deciso di fare una passeggiata con il cane, " + ownDog.GetName() + " inzia a correre e inciampa dopo aver rubato il mio dado preferito!");
    	this.Run();
    	int valDice = ownDog.Fall();
    	System.out.print("Dopo aver corso per " + String.format("%.2f", Position.Distance()));
    	if((int) Position.Distance() == 1) System.out.print(" metri in ");
    	else System.out.print(" metri in ");
    	System.out.println(String.format("%.2f", elapsedTime) + " minuti raccolgo il dado e vedo che il valore è " + valDice + "");
    	if(valDice == 6 || valDice == 1) System.out.println("... Wow il mio numero preferito!");
    }
    
    public void Run()
    {
    	Position.Translate((int)(Math.random()*300+1), 
    			(int)(Math.random()*300+1));
    	
    	//Spazio fratto km/h
    	elapsedTime = (float) ((Position.Distance()) / 250);
    }
}
