package com.company;

public class  Moteur {

    private String motorisation;
    private int puissance;

    public Moteur(String motorisation, int puissance) {
        this.motorisation=motorisation;
        this.puissance=puissance;
    }

    public void setMotorisation(String motorisation) {
        this.motorisation = motorisation;
    }

    public String getMotorisation() {
        return motorisation;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public static Moteur electrique = new Moteur("Electrique", 150);
    public static Moteur explosion = new Moteur("Explosion",150);
}
