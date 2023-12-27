package com.li.oopproject.entities;
import com.li.oopproject.Board;
public abstract class Human extends Entity{
    private int reloadTimeRemaining;
    public Human(int damage, int hp, Board board, int reloadTime){
        super (damage, hp, board);
        reloadTimeRemaining = reloadTime;
    }
    public int getReloadTimeRemaining() {
        return reloadTimeRemaining;
    }
    public void reload(int timeElapsed){
        if (reloadTimeRemaining > 0) {
            reloadTimeRemaining -= timeElapsed;
        }
    }

    public abstract Projectile attack();
}
