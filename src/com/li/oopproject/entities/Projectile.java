package com.li.oopproject.entities;

import com.li.oopproject.Board;
import com.li.oopproject.GameInterface;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public abstract class Projectile extends Entity implements Mobile{
    private final int speed;
    // this initialization block, like all the others, tries to find the image corresponding to the laser
    {
        try{
            this.setClassIcon(ImageIO.read(new File(GameInterface.class.getProtectionDomain().
                    getCodeSource().getLocation().getPath() + "com/li/oopproject/assets/Projectiles/bullet.jpg")));
            this.setClassIcon(GameInterface.resizeImage(this.getClassIcon(), 50, 25));
        }
        catch (IOException e) {
            System.out.println("No image file found for Bullet");
        }
    }

    // projectiles have 1hp right now but maybe we can make projectiles with more hp so that they can
    // last longer if we want to
    public Projectile(int damage, int speed, Board board){
        super(1, damage, board);
        this.speed = speed;
    }
    public void move(){
        this.setxPos(this.getxPos() + speed);
    }
}
