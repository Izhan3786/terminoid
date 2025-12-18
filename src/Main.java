package src;
import javax.swing.*;
import static core.Say.say;
import java.awt.event.*;

public class Main extends JFrame implements KeyListener {

    private boolean[] keys = new boolean[256];
    private Draw renderer;

    public Main() {
        setTitle("Terminoid");
        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        renderer = new Draw();
        add(renderer);

        addKeyListener(this);
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

    private void update() {
        if (keys[KeyEvent.VK_A]) {
            say("A is held");
        }
    }

    private void render() {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
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