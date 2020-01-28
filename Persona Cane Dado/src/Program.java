public class Program {			
	public static void main(String[] args)
	{
		Dice favouriteDice = new Dice(6);
		Dog dog = new Dog("Rex", favouriteDice);
		Person me = new Person("Alex", dog);
		System.out.println(me.GetName() + " diary...");
		me.StartDay();
	}
}
