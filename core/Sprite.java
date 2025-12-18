package core;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;
import javax.imageio.ImageIO;

public class Sprite {

    private BufferedImage image;
    Vector2 position;

    public Sprite(String src) {
        this.position = new Vector2(200,200);
        try {
            this.image = ImageIO.read(new File("assets/ship.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g) {
        g.drawImage(image, (int) position.x, (int) position.y, null);
    }

}
