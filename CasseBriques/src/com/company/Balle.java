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
    private int positionInitaleX=250;
    private int positionInitialeY=450;



    //le constructeur de la classe balle :
    public Balle() {
        setPositionX(positionInitaleX);
        setPositionY(positionInitialeY);
        setLargeur(10);
        setHauteur(10);
        setRayon(5);
        setVitesseHorizontale(-2);
        setVitesseVerticale(-3);
        remplirlistePointSphere();
    }

    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(Color.MAGENTA);
        super.dessiner(dessin);

    }

    //on inverse la vitesse horizontale en cas de colision avec la paroie droite de la fenetre:
    public void collisionDroite(){
        if(getPositionX()>=490) {
            inverseVitesseHorizontale();
        }
    }

    //on inverse la vitesse horizontale en cas de colision avec la paroie gauche de la fenetre:
    public void collisionGauche(){
        if(getPositionX()<=0){
            inverseVitesseHorizontale();
        }
    }

    //on inverse la vitesse verticale en cas de colision avec la paroie supérieure de la fenetre:
    public void collisionHaut(){
        if (getPositionY()<=0){
            inverseVitesseVerticale();
        }
    }

    //pour test à modifier pour perte vie/game over:
    public void collisionBas(){
        if (getPositionY()>=490){
            inverseVitesseVerticale();
        }
    }

    public void inverseVitesseHorizontale(){
        vitesseHorizontale= -1*vitesseHorizontale;
    }

    public void inverseVitesseVerticale(){
        vitesseVerticale= -1*vitesseVerticale;
    }

    //accesseurs pour la positon initiale et les vitesses:

    public int getPositionInitaleX() {
        return positionInitaleX;
    }

    public int getPositionInitialeY() {
        return positionInitialeY;
    }

    public int getVitesseHorizontale() {
        return vitesseHorizontale;
    }

    public int getVitesseVerticale() {
        return vitesseVerticale;
    }

    public void setPositionInitaleX(int positionInitaleX) {
        this.positionInitaleX = positionInitaleX;
    }

    public void setPositionInitialeY(int positionInitialeY) {
        this.positionInitialeY = positionInitialeY;
    }

    public void setVitesseHorizontale(int vitesseHorizontale) {
        this.vitesseHorizontale = vitesseHorizontale;
    }

    public void setVitesseVerticale(int vitesseVerticale) {
        this.vitesseVerticale = vitesseVerticale;
    }
}
