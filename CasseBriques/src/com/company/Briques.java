package com.company;

import java.awt.*;

public class Briques extends RectangleCB{
    //on servira du booleen pour afficher la brique/gerer les collisions avec la balle
    boolean estdetruite;

    // la resistance permettra de determiner si la brique à besoin de plusieurs touches pour est détruite
    private int resistance;

    // constructeur
    public Briques() {
        setEstdetruite(false);
        generationResistance();
        setLargeur(48);
        setHauteur(30);
    }

    // methode pour dessiner les briques en fonction de leur resistance
    @Override
    public void dessiner(Graphics2D dessin) {
        if(isEstdetruite()==false){
            if(getResistance()==1){
                dessin.setColor(Color.GREEN);
            }else if(getResistance()==2){
                dessin.setColor(Color.BLUE);
            }else if(getResistance()==3){
                dessin.setColor(Color.ORANGE);
            }
            super.dessiner(dessin);
        }
    }

    // methode pour générer aléatoirement la valeur de resistance (soit le nombre de touches nécessaires pour détruire la brique
    public void generationResistance(){
        //avec ces bornes, la resistance varir bien de 1 à 3.
        int min=1;
        int max=4;

        int alea = (int)(Math.random()*(max-min))+min;//la fonction math.random utilise des floats, on ajoute le minimum
        //pour que le cast (int) arrondisse à l'entier supérieur.
        setResistance(alea);
    }

    public void setEstdetruite(boolean estdetruite) {
        this.estdetruite = estdetruite;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public boolean isEstdetruite() {
        return estdetruite;
    }

    public int getResistance() {
        return resistance;
    }
}
