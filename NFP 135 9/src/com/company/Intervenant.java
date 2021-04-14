package com.company;

public class Intervenant extends Utilisateur implements Payable {
    public static int salaireAnnuel;
    int salaireAnnuel;
    @Override
    public int coutMensuel() {
        return salaireAnnuel/12;
    }
}
