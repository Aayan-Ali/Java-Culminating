package entity;

import main.KeyHandler;



//import java.awt.Color;
import main.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;    

public class Player extends Entity{
    KeyHandler keyH;

    public Player(GamePanel gp, main.KeyHandler keyH) {

        super(gp);

        this.gp = gp;
        this.keyH = keyH;

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;    
        solidArea.width = 32;
        solidArea.height = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        x = 95;
        y = 576-gp.tileSize;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_3.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
        if(y <=0) {
            y=gp.screenHeight-gp.tileSize;
            gp.score++;
        }
        // Here we are making the player move if a certain key is pressed
        // Because in java the upper left corner is X:0 and Y:0...
        // X values increases to the right
        // Y values increases as they go down
        if(keyH.upPressed == true){
            direction = "up";
            y -= speed;
        }
        if(keyH.downPressed == true){
            direction = "down";
            y += speed;
        }

        spriteCounter++;
        if(spriteCounter > 15) {
            if(spriteNum == 1) {
                spriteNum = 2;
            }
            else if(spriteNum == 2) {
                spriteNum = 3;
            }
            else if(spriteNum == 3) {
                spriteNum = 1;
            }
            spriteCounter = 0;

        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.WHITE);

        //Our player character
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image= null; 
        
        switch(direction) {
        case "up":
            if(spriteNum == 1) {
                image = up1;
            }
            if(spriteNum == 2) {
                image = up2;
            }
            if(spriteNum == 3) {
                image = up3;
            }
            break;
        case "down":
            if(spriteNum == 1) {
                image = down1;
            }
            if(spriteNum == 2) {
                image = down2;
            }
            if(spriteNum == 3) {
                image = down3;
            }
            break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
    
}
