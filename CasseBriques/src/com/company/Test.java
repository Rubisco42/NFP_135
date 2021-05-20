package com.company;

import java.awt.*;

public class Test {

    private int x=100;
    private int y=100;
    private int l=20;
    private int h=20;

    public void dessiner(Graphics2D dessin){
        dessin.setColor(Color.CYAN);
        dessin.fillOval(x,y,l,h);

    }
}
