package src;
import java.awt.event.*;
import core.Sprite;

public class Input implements 
        KeyListener, 
        MouseListener, 
        MouseMotionListener, 
        MouseWheelListener {


    
    private final boolean[] keys = new boolean[256];
    private final boolean[] mouseButtons = new boolean[5];

    private int mouseX, mouseY;
    private int mouseDX, mouseDY;
    private int scrollAmount;
   

    // -------- Keyboard Logic--------

    public boolean isKeyDown(char c) {
        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
        if (keyCode == KeyEvent.VK_UNDEFINED) return false;
        return keys[keyCode];
    }

    public boolean isKeyDown(String string) {
        char c = string.charAt(0);
        int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
        if (keyCode == KeyEvent.VK_UNDEFINED) return false;
        return keys[keyCode];
    }

    public boolean isKeyDown(int keyCode) {
        return keys[keyCode];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;    
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    @Override public void keyTyped(KeyEvent e) {}

    // -------- Mouse Button --------
    public boolean isMouseDown(int button) {
        return mouseButtons[button];
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseButtons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseButtons[e.getButton()] = false;
    }

    @Override public void mouseClicked(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}

    // -------- Mouse Move --------
    @Override
    public void mouseMoved(MouseEvent e) {
        mouseDX = e.getX() - mouseX;
        mouseDY = e.getY() - mouseY;
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMoved(e);
    }

    // -------- Scroll --------
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        scrollAmount += e.getWheelRotation();
    }

    // -------- Getters --------
    public int getMouseX() { return mouseX; }
    public int getMouseY() { return mouseY; }
    public int getMouseDX() { return mouseDX; }
    public int getMouseDY() { return mouseDY; }
    public int consumeScroll() {
        int s = scrollAmount;
        scrollAmount = 0;
        return s;
    }
}
