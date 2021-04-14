package com.company;

import java.lang.invoke.Invokers$Holder;

public class Main {

    public static void main(String[] args) {
	Intervenant intervenant=new Intervenant();
	Intervenant.salaireAnnuel=3000;

	Intervenant intervenant2= new Intervenant();
	Intervenant.salaireAnnuel=2000;

	Materiel imprimante=new Materiel();
	imprimante.coutEntretienMensuel=500;

	Payable[] listePayable={intervenant,intervenant2,imprimante};

	int cumul=0;
	for(Payable payable:listePayable){
	    cumul+=payable.coutMensuel();
    }




    }
}
