public class Dice {
	public static int Roll(int facce) {
		return (int) (Math.random() * (facce) + 1);
	}
}
