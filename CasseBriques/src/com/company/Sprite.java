package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public abstract class Sprite extends Graphics2D {
    //La classe sprite sert de base aux éléments mobiles.
    // Elle contient les methodes de bases pour la position des objets, la couleur et leur dessin dans le JPanel
    // correspondant au jeu.

    //variable de la position sur les axes X et Y du sprite
    protected int positionX;
    private int positionY;


    //couleur du sprite
    private Color color;

    // constructeur vide, les constructeurs des classes filles seront plus spécifiques.
    public Sprite() {
    }

    //methode pour afficher le sprite dans le Jpanel.
    public void dessiner(Graphics2D dessin){
    }


    //les accesseurs qui permettront de modifier les position en X et Y ainsi que la couleur du sprite.

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    @Override
    public Color getColor() {
        return color;
    }


}
