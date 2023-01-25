//This is basically just saying that all this code is in a folder called main and we are calling upon that
package main;
//This gets adall the code to work for JFrame
import javax.swing.JFrame;

public class Main{
    public static void main(String[] args) {
        //Here is a window created with JFrame that is going to display our whole game to the player
        JFrame window = new JFrame();
        //This lets the window properly close when the user clicks close ("x") button
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //This makes it so that we cannot resize our window 
        window.setResizable(false);
        //This is to set the window's title to Bullet Run
        window.setTitle("Bullet Run");

        //Here we are adding the new window to our main.java in order to run it
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        //The pack method sizes the frame so that all its contents are at or above their preffered sizes
        window.pack();

        //This is to not specify the location of the window which makes it always centre to the player's screen. We do this by calling it null.
        window.setLocationRelativeTo(null);
        //This is to make the window visible
        window.setVisible(true);

        //gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}
