package untitledgame.personnages;

public class Loup extends AVilain {
     
    public Loup(){
    	super();
    	setNom("Loup");
    }
    public Loup(String nom){
    	super(120, 120, 30, 0, 0, 1, MobType.WOLF);
    }

}