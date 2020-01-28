
public class Program {

	public static void main(String[] args) {
		Entity onionEntity = new Entity("John Onion", Entity.EntityAnatomy.Onion);
		Entity garlicEntity = new Entity("Wert Ketten", Entity.EntityAnatomy.Garlic);
		int attempt = 0;
		
		while(onionEntity.getHP() > 0 && garlicEntity.getHP() > 0) {
			if(attempt % 2 == 0)
				onionEntity.Attack(garlicEntity);
			else 
				garlicEntity.Attack(onionEntity);
			
			attempt++;
			//getData(attempt, onionEntity, garlicEntity);
		}
		
		if(onionEntity.getHP() > garlicEntity.getHP())
			System.out.println("Ha vinto " + onionEntity.getName());
		else if(onionEntity.getHP() == garlicEntity.getHP())
			System.out.println("Pareggio!");
		else
			System.out.println("Ha vinto " + garlicEntity.getName());
		System.out.println("Dopo " + (attempt) + " attempt");
	}
	
	private static void getData(int att, Entity en1, Entity en2) {
		System.out.println("\n*** ATTEMPT " + att);
		System.out.println("Name: " + en1.getName());
		System.out.println("Level: " + en1.getLevel());
		System.out.println("HP: " + en1.getHP());
		System.out.println("DEFENCE: " + en1.getDefencence());
		System.out.println("---------------------------------\n");
		System.out.println("Name: " + en2.getName());
		System.out.println("Level: " + en2.getLevel());
		System.out.println("HP: " + en2.getHP());
		System.out.println("DEFENCE: " + en2.getDefencence());
	}

}
