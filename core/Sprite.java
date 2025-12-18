package core;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;

public class Sprite {

    private BufferedImage image;
    Vector2 position, size;
    public float rotation;


    public Sprite(String src) {
        this.position = new Vector2(200,200);
        this.size = new Vector2(32,32);
        this.rotation = 0f;
        try {
            this.image = ImageIO.read(new File("assets/" + src));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public Sprite(String src, Vector2 position) {
        this.position = position;
        this.size = new Vector2(32,32);
        this.rotation = 0f;
        try {
            this.image = ImageIO.read(new File("assets/" + src));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void translate(Vector2 amount) {
        this.position.x += amount.x;
        this.position.y += amount.y;
    }
    public void setPosition(Vector2 position){
        this.position = position;

    }

    public void rotate(float radians) {
        rotation += radians;
    }

    public void setRotation(float radians) {
        rotation = radians;
    }

    public void draw(Graphics2D g) {
        AffineTransform old = g.getTransform();

        int w = image.getWidth();
        int h = image.getHeight();

        g.translate(position.x + w / 2f, position.y + h / 2f);

        g.rotate(rotation);

        g.drawImage(image, -w / 2, -h / 2, null);

        g.setTransform(old);    }

}
