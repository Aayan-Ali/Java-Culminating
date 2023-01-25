//This is basically just saying that all this code is in a folder called main and we are calling upon that
package main;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

//This allows all the code to work for JFrame
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;
import entity.Bullet;
import entity.Bullet2;
import entity.Bullet3;
import entity.Bullet4;
import entity.Bullet5;
import entity.Bullet6;
import entity.Bullet7;
import entity.Bullet8;
import entity.Bullet9;
import entity.Bullet10;

import entity.Player;
import entity.Player_2;
import tile.TileManager;
//This means that this class GamePanel inherits the JPanel class
public class GamePanel extends JPanel implements Runnable{
    
    // SCREEN SETTINGS
    final static int originalTileSize = 16; // 16 x 16 tile
    final static int scale = 3; // This is to to scale the tile so that it doesn't lose it's value but also becomes larger to the eye

    public final int tileSize = originalTileSize * scale; // 48 x 48 tiles which is the actual tile that is going to be 
    // This is our screen size and it is going to be a ratio of 4:3 meaning that we are going to multiply the tile size with the starting values of our max col and our max width
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; //48 x 16 = 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 48 x 12 = 576 pixels

    //Instantiate the KeyHandler
    KeyHandler keyH = new KeyHandler(this);
    //Thread is something you can start and also stop and it basically keeps your program running until you stop it
    public Thread gameThread;
    // FPS
    int FPS = 60;
    //This is get the time in nanoseconds to be more precise
    long currentTime = System.nanoTime();

    //Collision Checker
//    public CollisionChecker checker = new CollisionChecker(this);
    //public AssetSetter aSetter = new AssetSetter(this);

    //Instantiate TileManager
    TileManager tileM = new TileManager(this);
    //To create bullets
    Bullet bullet = new Bullet(this);
    Bullet2 bullet2 = new Bullet2(this);
    Bullet3 bullet3 = new Bullet3(this);
    Bullet4 bullet4 = new Bullet4(this);
    Bullet5 bullet5 = new Bullet5(this);
    Bullet6 bullet6 = new Bullet6(this);
    Bullet7 bullet7 = new Bullet7(this);
    Bullet8 bullet8 = new Bullet8(this);
    Bullet9 bullet9 = new Bullet9(this);
    Bullet10 bullet10 = new Bullet10(this);

    //To create players
    Player player = new Player(this, keyH);
    Player_2 player_2 = new Player_2(this, keyH);

    // GAME STATE
    public int gameState;
    public final int playState = 0;
    public final int pauseState = 1;
    public int score = 0;

    //Instantiate random
    Random random;


    //Constructor of this GamePanel
    public GamePanel() {
        //Set the size of this class
        this.setPreferredSize(new DimensionUIResource(screenWidth, screenHeight));
        //To set the screen's backgorund color to black
        this.setBackground(Color.BLACK);
        //If set to true, all the drawing from this component will be done in an offscreen painting buffer
        //If we enable this then that can improve the game's rendering performance
        this.setDoubleBuffered(true);
        //Here we are basically just recognizing the key input
        this.addKeyListener(keyH);
        this.setFocusable(true);


    }

    //When we start the gameThread we would automatically call the run thread
    public void startGameThread() {
        //We are absically passing this GamePanel to this thread's constructor which causes the instantiation of a thread 
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();

        // This means that as long as this gameThread exists, it repeats the process that is written inside of these brackets
        while(gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if(delta >= 1) {
                // 1 UPDATE: update information such as character positions
                update();
                // 2 DRAW: draw the scrdaeen with the updated information
                repaint();
                delta--;
            }
        }
    }

    public void update() {
            player.update();
            player_2.update();
            bullet.update();
            bullet2.update();
            bullet3.update();
            bullet4.update();
            bullet5.update();
            bullet6.update();
            bullet7.update();
            bullet8.update();
            bullet9.update();
            bullet10.update();

            random = new Random();


            int randomize = random.nextInt(576); 
            int rando = random.nextInt(10);

            // PLAYER 1 COLLISION EFFECTS
            if(((player.x+24 >= bullet.x) && (player.x < bullet.x + 48)) && ((player.y+24 >= bullet.y) && (player.y <= bullet.y+48))){
                player.y = 576 - tileSize;
                bullet.y = randomize;
                bullet.speed = rando+1;
            }
            if(((player.x+24 >= bullet2.x) && (player.x < bullet2.x + 48)) && ((player.y+24 >= bullet2.y) && (player.y <= bullet2.y+48))){
                player.y = 576 - tileSize;
                bullet2.y = randomize+1;
            }
            if(((player.x+24 >= bullet3.x) && (player.x < bullet3.x + 48)) && ((player.y+24 >= bullet3.y) && (player.y <= bullet3.y+48))){
                player.y = 576 - tileSize;
                bullet3.y = randomize+1;
            }
            if(((player.x+24 >= bullet4.x) && (player.x < bullet4.x + 48)) && ((player.y+24 >= bullet4.y) && (player.y <= bullet4.y+48))){
                player.y = 576 - tileSize;
                bullet4.y = randomize+1;
            }
            if(((player.x+24 >= bullet5.x) && (player.x < bullet5.x + 48)) && ((player.y+24 >= bullet5.y) && (player.y <= bullet5.y+48))){
                player.y = 576 - tileSize;
                bullet5.y = randomize+1;
            }
            if(((player.x+24 >= bullet6.x) && (player.x < bullet6.x + 48)) && ((player.y+24 >= bullet6.y) && (player.y <= bullet6.y+48))){
                player.y = 576 - tileSize;
                bullet6.y = randomize+1;
            }
            if(((player.x+24 >= bullet7.x) && (player.x < bullet7.x + 48)) && ((player.y+24 >= bullet7.y) && (player.y <= bullet7.y+48))){
                player.y = 576 - tileSize;
                bullet7.y = randomize+1;
            }
            if(((player.x+24 >= bullet8.x) && (player.x < bullet8.x + 48)) && ((player.y+24 >= bullet8.y) && (player.y <= bullet8.y+48))){
                player.y = 576 - tileSize;
                bullet8.y = randomize+1;
            }
            if(((player.x+24 >= bullet9.x) && (player.x < bullet9.x + 48)) && ((player.y+24 >= bullet9.y) && (player.y <= bullet9.y+48))){
                player.y = 576 - tileSize;
                bullet9.y = randomize+1;
            }
            if(((player.x+24 >= bullet10.x) && (player.x < bullet10.x + 48)) && ((player.y+24 >= bullet10.y) && (player.y <= bullet10.y+48))){
                player.y = 576 - tileSize;
                bullet10.y = randomize+1;
            }
            // PLAYER 2 COLLISION EFFECTS
            if(((player_2.x+24 >= bullet.x) && (player_2.x < bullet.x + 48)) && ((player_2.y+24 >= bullet.y) && (player_2.y <= bullet.y+48))){
                player_2.y = 576 - tileSize;
                bullet.y = randomize;
                bullet.speed = rando+1;
            }
            if(((player_2.x+24 >= bullet2.x) && (player_2.x < bullet2.x + 48)) && ((player_2.y+24 >= bullet2.y) && (player_2.y <= bullet2.y+48))){
                player_2.y = 576 - tileSize;
                bullet2.y = randomize+1;
            }
            if(((player_2.x+24 >= bullet3.x) && (player_2.x < bullet3.x + 48)) && ((player_2.y+24 >= bullet3.y) && (player_2.y <= bullet3.y+48))){
                player_2.y = 576 - tileSize;
                bullet3.y = randomize+1;
            }
            if(((player_2.x+24 >= bullet4.x) && (player_2.x < bullet4.x + 48)) && ((player_2.y+24 >= bullet4.y) && (player_2.y <= bullet4.y+48))){
                player_2.y = 576 - tileSize;
                bullet4.y = randomize+1;
            }
            if(((player_2.x+24 >= bullet5.x) && (player_2.x < bullet5.x + 48)) && ((player_2.y+24 >= bullet5.y) && (player_2.y <= bullet5.y+48))){
                player_2.y = 576 - tileSize;
                bullet5.y = randomize+1;
            }
            if(((player_2.x+24 >= bullet6.x) && (player_2.x < bullet6.x + 48)) && ((player_2.y+24 >= bullet6.y) && (player_2.y <= bullet6.y+48))){
                player_2.y = 576 - tileSize;
                bullet6.y = randomize+1;
            }
            if(((player_2.x+24 >= bullet7.x) && (player_2.x < bullet7.x + 48)) && ((player_2.y+24 >= bullet7.y) && (player_2.y <= bullet7.y+48))){
                player_2.y = 576 - tileSize;
                bullet7.y = randomize+1;
            }
            if(((player_2.x+24 >= bullet8.x) && (player_2.x < bullet8.x + 48)) && ((player_2.y+24 >= bullet8.y) && (player_2.y <= bullet8.y+48))){
                player_2.y = 576 - tileSize;
                bullet8.y = randomize+1;
            }
            if(((player_2.x+24 >= bullet9.x) && (player_2.x < bullet9.x + 48)) && ((player_2.y+24 >= bullet9.y) && (player_2.y <= bullet9.y+48))){
                player_2.y = 576 - tileSize;
                bullet9.y = randomize+1;
            }
            if(((player.x+24 >= bullet10.x) && (player_2.x < bullet10.x + 48)) && ((player_2.y+24 >= bullet10.y) && (player_2.y <= bullet10.y+48))){
                player_2.y = 576 - tileSize;
                bullet10.y = randomize+1;
            }
            
    }

    public void paintComponent(Graphics g) {

        super.paintComponent((g));

        Graphics2D g2 = (Graphics2D)g;

        //Call draw method inside of TileManager. This goes before player.draw() because we draw tiles first and then player because if we do player first it will get hidden by the tiles
        tileM.draw(g2);

        //Our player character
        player.draw(g2);
        player_2.draw(g2);
        //Our bullet characters
        bullet.draw(g2);
        bullet2.draw(g2);
        bullet3.draw(g2);
        bullet4.draw(g2);
        bullet5.draw(g2);
        bullet6.draw(g2);
        bullet7.draw(g2);
        bullet8.draw(g2);
        bullet9.draw(g2);
        bullet10.draw(g2);

        //We dispose this graphics once used in order to save memory and also because it is a good practice
        g2.dispose();
    }
}

