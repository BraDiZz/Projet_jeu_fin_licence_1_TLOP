package untitledgame.texture;

import untitledgame.terrain.SquareType;
import untitledgame.personnages.MobType;

import javax.swing.*;
import java.awt.*;

public class Texture extends ImageIcon {
    private SquareType textureName;
    private MobType mobName;

    public Texture(SquareType textureName) {
        super(textureName.path);
        this.textureName = textureName;
    }

    public Texture(MobType mobName) {
        super(mobName.path);
        this.mobName = mobName;
    }

    public SquareType getTextureName() {
        return textureName;
    }
}