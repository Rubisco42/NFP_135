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
import java.util.ArrayList;
import java.util.Map;

public class Balle extends Sphere{

    // les champs suivants correspondent aux valeurs de déplacement horizontal et vertical de la balle:
    private int vitesseHorizontale;
    private int vitesseVerticale;

    // les champs suivants correspondent à la positon initale de la balle (début de partie, création d'un nouvelle balle)
    private int positionInitaleX=250;
    private int positionInitialeY=450;



    // le constructeur de la classe balle,fait apparaitre la balle au milieu de la batte :
    public Balle() {
        setPositionX(positionInitaleX);
        setPositionY(positionInitialeY);
        setLargeur(10);
        setHauteur(10);
        setRayon(5);
        setPositionCentreX();
        setPositionCentreY();
        setVitesseHorizontale(-2);
        setVitesseVerticale(-3);
    }

    // on précise la méthode pour dessiner une balle
    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(Color.MAGENTA);
        super.dessiner(dessin);

    }

    // méthode pour mettre à jour les coordonnées du centre de la sphère:
    public void majCoordoCentre(Balle balle){
        balle.setPositionCentreX();
        balle.setPositionCentreY();
    }

    // méthodes pour modifier la direction de deplacement de la balle:
    public void inverseVitesseHorizontale(){
        vitesseHorizontale= -1*vitesseHorizontale;
    }

    public void inverseVitesseVerticale(){
        vitesseVerticale= -1*vitesseVerticale;
    }

    // on inverse la vitesse horizontale en cas de colision avec la paroie droite de la fenetre:
    public void collisionDroite(){
        if(getPositionX()>=487) {
            inverseVitesseHorizontale();
        }
    }

    // on inverse la vitesse horizontale en cas de colision avec la paroie gauche de la fenetre:
    public void collisionGauche(){
        if(getPositionX()<=0){
            inverseVitesseHorizontale();
        }
    }

    // on inverse la vitesse verticale en cas de colision avec la paroie supérieure de la fenetre:
    public void collisionHaut(){
        if (getPositionY()<=40){
            inverseVitesseVerticale();
        }
    }

    // pour test à modifier pour perte vie/game over:
    public void collisionBas(){
        if (getPositionY()>=490){
            inverseVitesseVerticale();
        }
    }

    // accesseurs pour la positon initiale et les vitesses:

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
