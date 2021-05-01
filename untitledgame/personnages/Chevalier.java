package untitledgame.personnages;

import untitledgame.texture.*;

public class Chevalier extends AHero {

	public Chevalier() {
		super();
		setNom("Chevalier");
	}
	public Chevalier(String nom) {
		super(300, 300, 40, 20, 50, 1, new Texture(TexturePath.KNIGHT));
		setNom(nom);
	}
}