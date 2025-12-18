package src;
import javax.swing.*;

import core.Array;
import core.Sprite;
import core.Vector2;

import static core.Say.say;
import java.awt.event.*;

public class Main extends JFrame implements KeyListener {

    private Draw renderer;

    Array<Sprite> sprites = new Array<>();

    Sprite ship = new Sprite("sprite/ship.png", new Vector2(100, 100));
    Sprite asteroid = new Sprite("sprite/asteroid.png", new Vector2(100, 100));

    Input input = new Input();

    
    /* Core logic here! */
    public void initialize() {
        sprites.add(this.ship);
        sprites.add(this.asteroid);
    }
    private void update() {
        if(input.isKeyDown('a')) {
            ship.translate(new Vector2(-1,0));
            // ship.rotate(0.03f);
        }

        if(input.isKeyDown('d')) {
            ship.translate(new Vector2(1,0));
            // ship.rotate(0.03f);
        }
    }


    /* ye neche wale methods filler methods hai ignore them, but do not remove */

    

    public Main() {
        setTitle("Terminoid");
        setSize(640, 480);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        initialize();
    
        this.renderer = new Draw(this.sprites);
        add(this.renderer);
        addKeyListener(this.input);
        renderer.addMouseListener(this.input);
        renderer.addMouseMotionListener(this.input);
        renderer.addMouseWheelListener(this.input);

        setFocusable(true);
        requestFocusInWindow();

        setVisible(true);
        startGameLoop();
    }
      private void startGameLoop() {
        new Thread(() -> {
            while (true) {
                update();
                render();
                sleep(16); 
            }
        }).start();
    }

    private void render() {
        renderer.repaint();
    }

    public static void main(String[] args) {
        say("[*] Game Started!");
        new Main();
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }
    
    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}