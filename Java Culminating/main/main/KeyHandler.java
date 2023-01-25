package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//The KeyListener is a listener interface for recieveing keyboard events (keystrokes)
public class KeyHandler implements KeyListener{

    GamePanel gp;
//Whenever you add KeyListener you have to add these three methods below which are keyTyped, keyReleased, and keyPressed
// This is to set variable names for the event of keyPressed    
    public boolean upPressed, downPressed, upPressed2, downPressed2;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e){
    }
// Here we are checking if the key is being pressed
    @Override
    public void keyPressed(KeyEvent e){
    // here by code we are collecting the input the user makes on their keyboard and are making it usable
        int code = e.getKeyCode();
    // these are the different game keys for one player
        if (code == KeyEvent.VK_W) {
            upPressed = true;
        }
        if (code == KeyEvent.VK_S) {
            downPressed = true;
        }
        if (code == KeyEvent.VK_UP) {
            upPressed2 = true;
        }

        if (code == KeyEvent.VK_DOWN) {
            downPressed2 = true;
        }
    }
// Here we are checking if the key is being released
    @Override
    public void keyReleased(KeyEvent e){
    // here by code we are collecting the input the user makes on their keyboard and are making it usable
    int code = e.getKeyCode();
    // these are the different game keys for one player
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }

        if (code == KeyEvent.VK_UP) {
            upPressed2 = false;
        }

        if (code == KeyEvent.VK_DOWN) {
            downPressed2 = false;
        }

    }
}