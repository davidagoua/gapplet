package com.aplt;

import com.aplt.objets.Balle;

import java.applet.Applet;
import java.awt.*;

public class Game extends Applet implements Runnable {

    Thread animation;
    Balle balle;
    public int raqX, raqY, raqWidth=5, raqHeight=55;


    @Override
    public void init() {
        setBackground(Color.BLACK);
        setSize(700, 600);
        balle = new Balle(this);
        raqX = getWidth()-35;
    }

    @Override
    public boolean mouseMove(Event evt, int x, int y) {
        this.raqY = y;
        return super.mouseMove(evt, x, y);
    }

    @Override
    public void start() {
        animation = new Thread(this);
        if(animation != null){
            animation.start();
        }
    }

    public void updateScene(){
        balle.update();
    }

    @Override
    public void stop() {
        if(animation != null){
            animation.stop();
        }
        animation = null;
        super.stop();
    }

    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillRect(raqX, raqY, raqWidth, raqHeight);
        g.setColor(Color.red);
        balle.paint(g);
    }

    public void run(){
        while(true){
            repaint();
            updateScene();
            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
