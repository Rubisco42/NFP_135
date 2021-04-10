package com.company;

public class Voiture extends VehiculeAMoteur {
    int nbrPortes;

    public Voiture(String marque, int nbrRoues, Moteur moteur, int nbrPortes) throws IllegalArgumentException {
        super(marque, nbrRoues, moteur);

        if(nbrRoues < 3) {
            throw new IllegalArgumentException("Ce n'est pas une voiture.");
        } else {
            this.nbrPortes = nbrPortes;
        }
    }
    public int getNbrPortes() {
        return nbrPortes;
    }

    public void setNbrPortes(int nbrPortes) {
        this.nbrPortes = nbrPortes;
    }
}
