public class Animale {
	private int Health;
	private boolean isAlive;
	
	public Animale(int health) {
		if(health > 0) Health = health;
		else Health = (int) (Math.random() * (100+1));
		isAlive = true;
	}
	
	public Animale() {
		Health = (int) (Math.random() * (100+1));
		isAlive = true;
	}
	
	public int getHealth() {
		return Health; 
	}
	
	public boolean IsAlive() {
		return isAlive;
	}
	
	public static void Combattimento(Animale a, Animale n) {
		while(a.IsAlive() && n.isAlive) {
			a.Attacca(n);
			n.Attacca(a);
		}
	}
	
	public void SetHealth(int h) {
		if(isAlive) {
			Health = h;
			isAlive = Health > 0;
		}
	}
		
	public void Attacca(Animale preda) {
		if(isAlive) {
			preda.SetHealth((int) (Math.random() * 30));
		}
	}
	
	public static void main(String[] args) {
		Animale sos = new Animale(95);
		Animale sas = new Animale();
		sos.Attacca(sas);
		System.out.println("VITA DI SAS: " + sas.getHealth() + " - isAlive: " + sas.IsAlive());
		System.out.println("Inizio combattimento:");
		Animale.Combattimento(sos, sas);
		System.out.println("VITA DI SAS: " + sas.getHealth() + " - isAlive: " + sas.IsAlive());
		System.out.println("VITA DI SOS: " + sos.getHealth() + " - isAlive: " + sos.IsAlive());
	}
}
