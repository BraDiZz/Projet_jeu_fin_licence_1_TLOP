package untitledgame.personnages;

public class Assassin extends AHero {
	
	public Assassin() {
	   super();
       setNom("Assassin");
	}

	public Assassin(String nom) {
	   super(150,150,90,0,10,1);
	   setNom(nom);
	}
}