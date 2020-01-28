public class Statistics {
	private int Force;
	private int Dexterity;
	private int Constitution;
	
	public Statistics() {
		Force = get3d8();
		Dexterity = get3d8();
		Constitution = get3d8();
	}
	
	public int modFOR() {
		return (Force - 10) / 2;
	}
	
	public int modDEX() {
		return (Dexterity - 10) / 2;
	}
	
	public int modCOS() {
		return (Constitution - 10) / 2;
	}
	
	private int get3d8() {
		return Dice.Roll(8) + Dice.Roll(8) + Dice.Roll(8);
	}
}
