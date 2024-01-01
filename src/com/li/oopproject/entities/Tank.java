package com.li.oopproject.entities;

import com.li.oopproject.Board;
import com.li.oopproject.GameInterface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tank extends Human {

    public static final int GOLD_COST = 200;
    private final static int reloadTime = 4000;  // reload delay in ms
    private final static int maxHP = 300;
    private final static int damage = 100;

    private static BufferedImage classIcon;

    static {

        try{
            classIcon = ImageIO.read(new File(GameInterface.class.getProtectionDomain().
                    getCodeSource().getLocation().getPath() + "com/li/oopproject/assets/Humans/Tank.png"));
            classIcon = GameInterface.resizeImage(Tank.classIcon, getLength(), getHeight());
        }
        catch (IOException e) {
            System.out.println("No image file found for Tank");
        }

    }

    public Tank(Board board){
        super (maxHP, damage, board, reloadTime);
        setInstanceIcon(Tank.classIcon);
        setGoldCost(GOLD_COST);
    }

    @Override
    public void upgrade(){
        super.upgrade();
    }

    public Projectile attack(){
        this.setReloadTimeRemaining(reloadTime);
        Projectile bomb = new Bomb(damage, this.getBoard());
        bomb.setHp(2);
        bomb.setxPos(this.getxPos()+getLength());
        bomb.setyPos(this.getyPos());
        return bomb;
    }

}
