
public class Weapon {
	public String Name = "";
	private int BasicDamage;
	private int AttackDamage;
	
	public Weapon() {
		BasicDamage = Dice.Roll(8);
		AttackDamage = (int) (Math.random() * (5));
	}
	
	public int AttackDamage() {
		return BasicDamage + AttackDamage + Dice.Roll(6);
	}
	
	public int getResistance() {
		return AttackDamage;
	}
}
