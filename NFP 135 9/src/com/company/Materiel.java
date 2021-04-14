package com.company;

public class Materiel implements Payable{

    int coutEntretienMensuel=0;
    @Override
    public int coutMensuel() {
        return coutEntretienMensuel;
    }
}
