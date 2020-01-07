package com.aplt.objets;

import com.aplt.Game;

import java.applet.Applet;
import java.awt.*;

public class Balle {

    public int x, y, vx, vy;
    public Game parent;

    public Balle(Game parent){
        this.parent = parent;
        this.x = 100;
        this.y = 100;
        this.vx = 10;
        this.vy = 13;
    }

    public void updatePosition(){
        x += vx;
        y += vy;
    }

    public void update(){
        if(x < 5){
            vx = -vx;
        }
        if(x > parent.getWidth()-30){
            parent.stop();
        }

        if(y > parent.getHeight()-30 || y < 5 ){
            vy = -vy;
        }

        if((this.x+30 >= parent.raqX) && (this.y >= parent.raqY-5) && (this.y+25 <= parent.raqY+parent.raqHeight+10)){
            vx = -vx;
        }

        updatePosition();
    }

    public void paint(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(this.x, this.y, 30, 30);
    }
}
