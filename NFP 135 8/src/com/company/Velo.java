package com.company;

public class Velo extends Vehicule{

    private String typeVelo;

    public Velo(String marque, int nbrRoues, String typeVelo){
        super(marque, nbrRoues);
        this.typeVelo = typeVelo;
    }

    public String getTypeVelo() {
        return typeVelo;
    }

    public void setTypeVelo(String typeVelo) {
        this.typeVelo= typeVelo;
    }
}
