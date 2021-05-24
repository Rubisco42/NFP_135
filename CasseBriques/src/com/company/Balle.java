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
    private int positionInitaleX;
    private int positionInitialeY;

    //les booléens suivant serviront à éviter des collisions multiples dans les boucles de gestions des collisions de la
    //avec les briques

    private boolean collisionBriqueHaut;
    private boolean collisionBriqueBas;
    private boolean collisionBriqueGauche;
    private boolean collisionBriqueDroite;

    // le constructeur de la classe balle,fait apparaitre la balle au milieu de la batte :
    public Balle(Barre barre) {
        setPositionX(barre.getMilieuX()-5); // on soustrait le rayon pour que le milieu de la balle match le milieu de la barre
        setPositionY(barre.getMilieuY()-10); //on soustrait le diamètre pour que la balle soit sur la barre.
        setLargeur(10);
        setHauteur(10);
        setRayon(5);
        setPositionCentreX();
        setPositionCentreY();
        setVitesseHorizontale(-1);//il y a une limite à ma méthode de gestion des collisions (barre/briques): ne fonctionne
        setVitesseVerticale(-2);//plus avec des vitesses supérieures.
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
        if(getPositionX()>=480) {
            inverseVitesseHorizontale();
            setCollisionBriqueHaut(false);
            setCollisionBriqueBas(false);
            setCollisionBriqueGauche(false);
            setCollisionBriqueDroite(false);
        }
    }

    // on inverse la vitesse horizontale en cas de colision avec la paroie gauche de la fenetre:
    public void collisionGauche(){
        if(getPositionX()<=10){
            inverseVitesseHorizontale();
            setCollisionBriqueHaut(false);
            setCollisionBriqueBas(false);
            setCollisionBriqueGauche(false);
            setCollisionBriqueDroite(false);
        }
    }

    // on inverse la vitesse verticale en cas de colision avec la paroie supérieure de la fenetre:
    public void collisionHaut(){
        if (getPositionY()<=60){
            inverseVitesseVerticale();
            setCollisionBriqueHaut(false);
            setCollisionBriqueBas(false);
            setCollisionBriqueGauche(false);
            setCollisionBriqueDroite(false);
        }
    }

    // on modifie le nombre de vies si la balle tombe dans la lave et la restart sur la barre:
    public void collisionBas(Attributs attributs, Barre barre){
        if (getPositionY()>=490){
            attributs.setNbrVies(attributs.getNbrVies()-1);
            //on applique une pénalité de 500 points par balle perdue
            attributs.setScore(attributs.getScore()-500);
            attributs.setStart(false);
            attributs.setLancement(false);
            barre.setPremiereCollision(0);
            setCollisionBriqueHaut(false);
            setCollisionBriqueBas(false);
            setCollisionBriqueGauche(false);
            setCollisionBriqueDroite(false);
        }
    }

    // méthode pour gérer la collision de la balle avec le coté supérieur de la barre
    public void collisionBarreHaut(Barre barre,Balle balle){
        int balleX, balleY;
        int barreX, barreY;
        for(int i=0;i<balle.getListePointSphere().size();i++){
            balleX=balle.getListePointSphere().get(i).getPointX();
            balleY=balle.getListePointSphere().get(i).getPointY();
            for(int j=0;j<barre.getCoteHaut().size(); j++){
                barreX=barre.getCoteHaut().get(j).getPointX();
                barreY=barre.getCoteHaut().get(j).getPointY();
                if((balleX==barreX)&&(balleY==barreY)){
                    // on modifie la direction de la balle selon la zone de la barre touchée

                    if(barre.getPremiereCollision()==1) {
                        if(balleX<barre.getMilieuX()){
                            balle.inverseVitesseVerticale();
                            barre.setPremiereCollision(barre.getPremiereCollision()+1);
                        }else if(balleX>barre.getMilieuX()){
                            balle.inverseVitesseVerticale();
                            balle.inverseVitesseHorizontale();
                            barre.setPremiereCollision(barre.getPremiereCollision()+1);
                        }else if(balleX==barre.getMilieuX()){
                        balle.inverseVitesseVerticale();
                        //on ne modifie pas lma valeur de première collision,permet un tir vertical
                            // tant que le centre de la barre est touché. Ne marche pas, sera corrigé plus tard
                        }
                    }else if(balle.getVitesseHorizontale()<0){
                        if(balleX<barre.getMilieuX()){
                            balle.inverseVitesseVerticale();
                            setCollisionBriqueHaut(false);
                            setCollisionBriqueBas(false);
                            setCollisionBriqueGauche(false);
                            setCollisionBriqueDroite(false);
                        }else if(balleX>barre.getMilieuX()){
                            balle.inverseVitesseVerticale();
                            balle.inverseVitesseHorizontale();
                            setCollisionBriqueHaut(false);
                            setCollisionBriqueBas(false);
                            setCollisionBriqueGauche(false);
                            setCollisionBriqueDroite(false);
                        }else if(balleX==barre.getMilieuX()){
                            balle.inverseVitesseVerticale();
                        }
                    }else if(balle.getVitesseHorizontale()>0){
                        if(balleX<barre.getMilieuX()){
                            balle.inverseVitesseVerticale();
                            balle.inverseVitesseHorizontale();
                            setCollisionBriqueHaut(false);
                            setCollisionBriqueBas(false);
                            setCollisionBriqueGauche(false);
                            setCollisionBriqueDroite(false);
                        }else if(balleX>barre.getMilieuX()){
                            balle.inverseVitesseVerticale();
                            setCollisionBriqueHaut(false);
                            setCollisionBriqueBas(false);
                            setCollisionBriqueGauche(false);
                            setCollisionBriqueDroite(false);
                        }else if(balleX==barre.getMilieuX()){
                            balle.inverseVitesseVerticale();
                        }
                    }
                }
            }
        }
    }

    // méthode pour gérer la collision de la balle avec le coté gauche de la barre,permet eventuellement de rattraper
    // la balle, dans une certaine mesure
    public void collisionBarreGauche(Barre barre,Balle balle){
        int balleX, balleY;
        int barreX, barreY;
        for(int i=0;i<balle.getListePointSphere().size();i++){
            balleX=balle.getListePointSphere().get(i).getPointX();
            balleY=balle.getListePointSphere().get(i).getPointY();
            for(int j=0;j<barre.getCoteGauche().size(); j++){
                barreX=barre.getCoteGauche().get(j).getPointX();
                barreY=barre.getCoteGauche().get(j).getPointY();
                if((balleX==barreX)&&(balleY==barreY)){
                    // on modifie la direction de la balle selon la zone de la barre touchée
                    if(balleY<barre.getMilieuGY()){
                        if(balle.getVitesseHorizontale()<0) {
                            balle.inverseVitesseVerticale();
                            setCollisionBriqueHaut(false);
                            setCollisionBriqueBas(false);
                            setCollisionBriqueGauche(false);
                            setCollisionBriqueDroite(false);
                        }else if(balle.getVitesseHorizontale()>0) {
                            balle.inverseVitesseVerticale();
                            balle.inverseVitesseHorizontale();
                            setCollisionBriqueHaut(false);
                            setCollisionBriqueBas(false);
                            setCollisionBriqueGauche(false);
                            setCollisionBriqueDroite(false);
                        }
                    }else{
                        inverseVitesseHorizontale();
                        setCollisionBriqueHaut(false);
                        setCollisionBriqueBas(false);
                        setCollisionBriqueGauche(false);
                        setCollisionBriqueDroite(false);
                    }
                }
            }
        }
    }

    // méthode pour gérer la collision de la balle avec le coté gauche de la barre,permet eventuellement de rattraper
    // la balle, dans une certaine mesure
    public void collisionBarreDroit(Barre barre,Balle balle){
        int balleX, balleY;
        int barreX, barreY;
        for(int i=0;i<balle.getListePointSphere().size();i++){
            balleX=balle.getListePointSphere().get(i).getPointX();
            balleY=balle.getListePointSphere().get(i).getPointY();
            for(int j=0;j<barre.getCoteDroit().size(); j++){
                barreX=barre.getCoteDroit().get(j).getPointX();
                barreY=barre.getCoteDroit().get(j).getPointY();
                if((balleX==barreX)&&(balleY==barreY)){
                    // on modifie la direction de la balle selon la zone de la barre touchée
                    if(balleY<barre.getMilieuDY()){
                        if(balle.getVitesseHorizontale()<0) {
                            balle.inverseVitesseVerticale();
                            balle.inverseVitesseHorizontale();
                            setCollisionBriqueHaut(false);
                            setCollisionBriqueBas(false);
                            setCollisionBriqueGauche(false);
                            setCollisionBriqueDroite(false);
                        }else if(balle.getVitesseHorizontale()>0) {
                            balle.inverseVitesseVerticale();
                            setCollisionBriqueHaut(false);
                            setCollisionBriqueBas(false);
                            setCollisionBriqueGauche(false);
                            setCollisionBriqueDroite(false);
                        }
                    }else{
                        inverseVitesseHorizontale();
                        setCollisionBriqueHaut(false);
                        setCollisionBriqueBas(false);
                        setCollisionBriqueGauche(false);
                        setCollisionBriqueDroite(false);
                    }
                }
            }
        }
    }

    // accesseurs pour la positon initiale, les vitesses et les collisions avec les briques:

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

    public boolean isCollisionBriqueHaut() {
        return collisionBriqueHaut;
    }

    public boolean isCollisionBriqueBas() {
        return collisionBriqueBas;
    }

    public boolean isCollisionBriqueGauche() {
        return collisionBriqueGauche;
    }

    public boolean isCollisionBriqueDroite() {
        return collisionBriqueDroite;
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

    public void setCollisionBriqueHaut(boolean collisionBriqueHaut) {
        this.collisionBriqueHaut = collisionBriqueHaut;
    }

    public void setCollisionBriqueBas(boolean collisionBriqueBas) {
        this.collisionBriqueBas = collisionBriqueBas;
    }

    public void setCollisionBriqueGauche(boolean collisionBriqueGauche) {
        this.collisionBriqueGauche = collisionBriqueGauche;
    }

    public void setCollisionBriqueDroite(boolean collisionBriqueDroite) {
        this.collisionBriqueDroite = collisionBriqueDroite;
    }

    //on implémenete les méthodes de l'interface

}
