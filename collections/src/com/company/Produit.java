package com.company;

public class Produit {
    private String nom;
    private float prixHT;
    private float tVA;

    public Produit(String nom,float prixHT, float tVA) {
        this.nom=nom;
        this.prixHT=prixHT;
        this.tVA=tVA;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(float prixHT) {
        this.prixHT = prixHT;
    }

    public float gettVA() {
        return tVA;
    }

    public void settVA(float tVA) {
        this.tVA = tVA;
    }
}
