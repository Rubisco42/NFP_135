package com.company;

import java.awt.*;

public class Barre extends RectangleCB{
    // champ definissant la vitesse de déplacement horizontale de la barre
    int vitesse;

    // champs stockant les coordonnées X et Y du milieu du coté haut de la barre, sert à régler la position initale
    // de(s) la(les) balle(s)
    int milieuX;
    int milieuY;

    public Barre() {
        setPositionX(220);
        setPositionY(482);
        setLargeur(60);
        setHauteur(10);
        setMilieuX(250);
        setMilieuY(482);
        setVitesse(6);
    }

    // méthode pour dessiner la barre:


    @Override
    public void dessiner(Graphics2D dessin) {
        dessin.setColor(Color.CYAN);
        super.dessiner(dessin);
        dessin.setColor(Color.BLUE);
        dessin.drawLine(getMilieuX(),482,getMilieuX(),491);
    }

    // les methodes de déplacement de la barre, en évitant que la barre ne traverse les paroies latérales:
    public void deplacementGauche(){
        if(getPositionX()>5){
            setPositionX(getPositionX()-getVitesse());
        }
    }

    public void deplacementDroite(){
        if(getPositionX()<(495-getLargeur())){
            setPositionX(getPositionX()+getVitesse());
        }
    }

    public void remplirCoteHaut(Barre barre){
        PointRectangle point;
        for (int i=0;i<barre.getLargeur()+1;i++){
            point=new PointRectangle();
            point.setPointX(barre.getPositionX()+i);
            point.setPointY(barre.getPositionY());
            coteHaut.add(point);
        }
    }

    public void remplirCoteBas(Barre barre){
        PointRectangle point;
        for (int i=0;i<barre.getLargeur()+1;i++){
            point=new PointRectangle();
            point.setPointX(barre.getPositionX()+i);
            point.setPointY(barre.getPositionY()+barre.getHauteur());
            coteBas.add(point);
        }
    }

    public void remplirCoteGauche(Barre barre){
        PointRectangle point;
        for (int i=0;i<barre.getHauteur()+1;i++){
            point=new PointRectangle();
            point.setPointX(barre.getPositionX());
            point.setPointY(barre.getPositionY()+i);
            coteGauche.add(point);
        }
    }

    public void remplirCoteDroit(Barre barre){
        PointRectangle point;
        for (int i=0;i<barre.getHauteur()+1;i++){
            point=new PointRectangle();
            point.setPointX(barre.getPositionX()+barre.getLargeur());
            point.setPointY(barre.getPositionY()+i);
            coteDroit.add(point);
        }
    }

    public void majCoteHaut(Barre barre){
        for (int i=0;i<barre.getCoteHaut().size();i++){
            barre.getCoteHaut().get(i).setPointX(barre.getPositionX()+i);
            barre.getCoteHaut().get(i).setPointY(barre.getPositionY());
        }
    }

    public void majCoteBas(Barre barre){
        for (int i=0;i<barre.getCoteBas().size();i++){
            barre.getCoteBas().get(i).setPointX(barre.getPositionX()+i);
            barre.getCoteBas().get(i).setPointY(barre.getPositionY()+barre.getHauteur());
        }
    }

    public void majCoteGauche(Barre barre){
        for (int i=0;i<barre.getCoteGauche().size();i++){
            barre.getCoteGauche().get(i).setPointX(barre.getPositionX());
            barre.getCoteGauche().get(i).setPointY(barre.getPositionY()+i);
        }
    }

    public void majCoteDroit(Barre barre){
        for (int i=0;i<barre.getCoteDroit().size();i++){
            barre.getCoteDroit().get(i).setPointX(barre.getPositionX()+barre.getLargeur());
            barre.getCoteDroit().get(i).setPointY(barre.getPositionY()+i);
        }
    }
    // methode pour modifier la position du milieu du coté supérieur
    public void modifMilieu(Barre barre){
        barre.setMilieuX(barre.getPositionX()+(barre.getLargeur()/2));
    }



    // les accesseurs pour les propriétés de Barre
    public int getVitesse() {
        return vitesse;
    }

    public int getMilieuX() {
        return milieuX;
    }

    public int getMilieuY() {
        return milieuY;
    }

    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    public void setMilieuX(int milieuX) {
        this.milieuX = milieuX;
    }

    public void setMilieuY(int milieuY) {
        this.milieuY = milieuY;
    }
}

