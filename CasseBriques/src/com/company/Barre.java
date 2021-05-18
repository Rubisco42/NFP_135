package com.company;

public class Barre extends RectangleCB{
    // champ definissant la vitesse de déplacement horizontale de la barre
    int vitesse;

    // champs stockant les coordonnées X et Y du milieu du coté haut de la barre, sert à régler la position initale
    // de(s) la(les) balle(s)
    int milieuX;
    int milieuY;

    public Barre() {
        setPositionX(230);
        setPositionY(482);
        setLargeur(40);
        setHauteur(10);
        setMilieuX(250);
        setMilieuY(482);
        setVitesse(2);
    }

    // les methodes de déplacement de la barre:
    public void deplacementGauche(){
        if(getPositionX()>5){
            setPositionX(getPositionX()-getVitesse());
        }
    }

    public void deplacementDroite(){
        if(getPositionX()<495){
            setPositionX(getPositionX()+getVitesse());
        }
    }

    // methode pour modifier la psotion du milieu du coté supérieur
    public void modifMilieu(){
        setMilieuX(getPositionX()+(getLargeur()/2));
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

