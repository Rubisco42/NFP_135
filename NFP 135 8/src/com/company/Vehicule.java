package com.company;

public abstract class Vehicule {

    private String marque;
    private int nbrRoues;

    public Vehicule(String marque, int nbrRoues) {
        this.marque = marque;
        this.nbrRoues=nbrRoues;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getNbrRoues() {
        return nbrRoues;
    }

    public void setNbrRoues(int nbrRoues) {
        this.nbrRoues = nbrRoues;
    }
}
