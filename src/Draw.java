package src;
import javax.swing.*;

import core.Sprite;

import java.awt.*;

class Draw extends JPanel {

    Sprite ship;

    Draw() {
        setBackground(Color.BLACK);

        try {
            ship = new Sprite("sprite/ship.png");
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
