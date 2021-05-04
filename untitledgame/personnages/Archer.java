package untitledgame.personnages;

import untitledgame.texture.*;

public class Archer extends AHero {
	public Archer() {
		super(200, 200, 60, 10, 25, 1, new Texture(TexturePath.ARCHER));
		setNom("Archer");
	}
	public Archer(String nom) {
		super(200, 200, 60, 10, 25, 1, new Texture(TexturePath.ARCHER));
		setNom(nom);
	}
}