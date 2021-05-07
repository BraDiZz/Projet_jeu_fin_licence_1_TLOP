public enum ObjetType {
    SUPERPOTION("assets/textures/objet_logo/SuperPotion.png"),
    POTION("assets/textures/objet_logo/Potion.png"),
    POULET("assets/textures/objet_logo/Poulet.png"),
    POMME("assets/textures/objet_logo/Pomme.png"),
    PAIN("assets/textures/objet_logo/Pain.png"),
    JUS("assets/textures/objet_logo/NoixCoco.png");

    public String path;

    private ObjetType(String path) {
        this.path = path;
    }
}