package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class Entity {
    
    GamePanel gp;
    public int x;
    public int y;
    public int speed;

    public BufferedImage up1, up2, up3, down1, down2, down3, bullet1, bullet2, bullet3, bullet4;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNum = 1;

    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public Entity(GamePanel gp) {
        this.gp = gp;
    }
}
