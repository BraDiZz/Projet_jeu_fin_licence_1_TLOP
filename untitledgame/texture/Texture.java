package untitledgame.texture;

import javax.swing.*;
import java.awt.*;

public class Texture extends ImageIcon {
    private TexturePath textureName;

    public Texture(TexturePath textureName) {
        super(textureName.path);
        this.textureName = textureName;
    }

    public TexturePath getTextureName() {
        return textureName;
    }
}