package com.company;

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

public class Balle extends Sphere{

    // on determine les valeurs de déplacement horizontal et vertical de la balle:
    private int vitesseHorizontale;
    private int vitesseVerticale;
    private int positionInitaleX;
    private int positionInitialeY;



    //on determine la position initiale de la balle:


    public Balle() {
        setPositionX(positionInitaleX);
        setPositionY(positionInitialeY);
        remplirlistePointSphere();
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        super.dessiner(dessin);
        dessin.setColor(Color.MAGENTA);
    }

    //on modifie les accesseurs de la classe Sprite pour gérer le déplacement de(s) la(es) balle(s).
    @Override
    public void setPositionX(int positionX) {
        super.setPositionX(positionX+vitesseHorizontale);
    }

    @Override
    public void setPositionY(int positionY) {
        super.setPositionY(positionY+vitesseVerticale);
    }

    public void inverseVitesseHorizontale(){
        vitesseHorizontale=+1*vitesseHorizontale;
    }

    public void inverseVitesseVerticale(){
        vitesseVerticale=-1*vitesseVerticale;
    }
}
