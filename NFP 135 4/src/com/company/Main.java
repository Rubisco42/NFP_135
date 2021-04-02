package com.company;

public class Main {
    public static void main(String[] args){

        //ligne suivante = contructeur par défaut
        Utilisateur utilisateur1 = new Utilisateur("bob", 32);
        utilisateur1.setNom("franck");
        utilisateur1.setAge(32);

        Utilisateur utilisateur2 = new Utilisateur("kevin",45);
        utilisateur2.setNom("toto");
        utilisateur2.setAge(15);

        System.out.println(utilisateur2.getNom());



    }

}
