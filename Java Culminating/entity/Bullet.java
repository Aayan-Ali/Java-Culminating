
package entity;

import main.GamePanel;

//import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Bullet extends Entity{
        GamePanel gp;
        Random random;
    
    public Bullet(GamePanel gp) {
        super(gp);
        this.gp = gp;
    
        setDefaultValues();
        getBulletImage();
    }
    public void setDefaultValues(){
        random = new Random();
        int randomised = random.nextInt(gp.maxScreenCol);
        int rando = random.nextInt(10);
        x = 0;
        y = randomised;
        solidArea = new Rectangle(0,0,48,48);
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;    
        speed = rando + 1;
        direction = "right";
    }

    public void getBulletImage() {
        try {
            
            bullet1 = ImageIO.read(getClass().getResourceAsStream("/player/bullet_1.png"));
            bullet2 = ImageIO.read(getClass().getResourceAsStream("/player/bullet_2.png"));
            bullet3 = ImageIO.read(getClass().getResourceAsStream("/player/bullet_3.png"));
            bullet4 = ImageIO.read(getClass().getResourceAsStream("/player/bullet_4.png"));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // Here we are making the bullet move from righT to left and vice versa
        // Because in java the upper left corner is X:0 and Y:0...
        // X values increases to the right
        // Y values increases as they go down
        if(x <= 1220){ //We are just gving some more time before the bullet reappers so in actually it owuld loop at 769 but we are intentionally makign it loop at 1220
            x+=speed;
        }    
        else{
            x = 0;
            x+=speed;
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
                spriteNum = 4;
            }
            else if(spriteNum == 4) {
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
                case "right":
                    if(spriteNum == 1) {
                        image = bullet1;
                    }
                    if(spriteNum == 2) {
                        image = bullet2;
                    }
                    if(spriteNum == 3) {
                        image = bullet3;
                    }
                    if(spriteNum == 4) {
                        image = bullet4;
                    }
                    break;
                }
                g2.drawImage(image, x, y+50, gp.tileSize-16, gp.tileSize-16, null);
                g2.drawImage(image, x, y+50, gp.tileSize-16, gp.tileSize-16, null);
                g2.drawImage(image, x, y+50, gp.tileSize-16, gp.tileSize-16, null);
            }
}
