package com.company;

public abstract class VehiculeAMoteur extends Vehicule {

    private Moteur moteur;


    public VehiculeAMoteur(String marque, int nbrRoues, Moteur moteur) {
        super(marque, nbrRoues);
        this.moteur = moteur;
    }

    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }
}
