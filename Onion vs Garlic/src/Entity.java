public class Entity {
	
	public enum EntityAnatomy{
		Onion,
		Garlic
	}
	
	private int Level;
	private String Name;
	private int hp;
	private int defence;
	private EntityAnatomy entityAnatomy;
	private Weapon weapon;
	private Armor armor;
	private Statistics stat;
	
	public Entity(String name, EntityAnatomy anatomy) {
		armor = new Armor();
		weapon = new Weapon();
		stat = new Statistics();
		entityAnatomy = anatomy;
		Name = name;
		Level = (int) (Math.random() * (20) + 1); 
		hp = (Dice.Roll(10) + stat.modCOS()) * Level;
		defence = 10 + stat.modDEX() + armor.getValue();
	}
	
	public String getName() {
		return Name;
	}
	
	public int getLevel() {
		return Level;
	}
	
	public int getHP() {
		return hp;
	}
	
	public int getDefencence() {
		return defence;
	}
	
	public int getTxC() {
		return Dice.Roll(20) + Level + stat.modFOR();
	}
	
	public void getDamage(int damage) {
		hp -= damage;
	}
	
	public void Attack(Entity enemy) {
		if(this.getTxC() >= enemy.getDefencence())
			enemy.getDamage(weapon.AttackDamage() + stat.modFOR());
	}
}
