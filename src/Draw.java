package src;
import javax.swing.*;

import core.Array;
import core.Sprite;

import java.awt.*;

class Draw extends JPanel {

    Array<Sprite> sprites;
    

    Draw(Array<Sprite> sprites) {
        setBackground(Color.BLACK);
        this.sprites = sprites;
    }

    void render(Graphics2D g) {
        for(Sprite sprite : sprites) {
            sprite.draw(g);
        }
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render((Graphics2D) g);
        for(Sprite sprite : sprites) {
            sprite.draw((Graphics2D) g);
        }
    }
}
