package src;
import javax.swing.*;

import core.Array;
import core.Sprite;
import core.Vector2;

import static core.Say.say;
import java.awt.event.*;

public class Main extends JFrame implements KeyListener {

    private boolean[] keys = new boolean[256];
    private Draw renderer;

    Array<Sprite> sprites = new Array<>();

    Sprite ship = new Sprite("sprite/ship.png");

    Input input = new Input();

    public void initialize() {
        sprites.add(this.ship);
    }

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
                if(input.isKeyDown('a')) {
                    say("a pressed");
                    ship.translate(new Vector2(-1,0));
                    renderer.repaint();
                }

                if(input.isKeyDown('d')) {
                    say("d pressed");
                    ship.translate(new Vector2(1,0));
                    renderer.repaint();
                }
                
                update();
                render();
                sleep(16); 
            }
        }).start();
    }

    private void update() {
        if (keys[KeyEvent.VK_A]) {
            say("A is held");
        }
    }

    private void render() {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // keys[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    private void sleep(long ms) {
        try { Thread.sleep(ms); } catch (Exception ignored) {}
    }

    public static void main(String[] args) {
        new Main();
    }
}