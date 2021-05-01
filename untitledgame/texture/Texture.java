package untitledgame.texture;

import javax.swing.*;
import java.awt.*;

public class Texture extends ImageIcon {
    public Texture(TexturePath texture) {
        super(texture.path);
    }
}