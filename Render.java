import javax.swing.*;

import core.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

class Renderer extends JPanel {

    Sprite ship;

    Renderer() {
        setBackground(Color.BLACK);

        try {
            ship = new Sprite("assets/ship.png");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void render(Graphics2D g) {
        ship.draw(g);
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render((Graphics2D) g);
    }
}
