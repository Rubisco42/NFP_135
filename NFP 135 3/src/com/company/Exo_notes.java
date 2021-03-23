package com.company;

import java.util.Scanner;

public class Exo_notes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir le nombre d'étudiants: ");
        int nEtudiants = scanner.nextInt();

        System.out.println("Veuillez saisir le nombre de notes par étudiants: ");
        int nNotes = scanner.nextInt();
        int posEtudiant =0;
              

        double[][] pRomo = new double[nEtudiants][nNotes];
        double[] cumEtudiant = new double[nNotes];
        double[] cumPromo = new double[nEtudiants];

        float cumNotes = 0;
        float note = -1;

        for(int i = 0; i < nEtudiants; i++){
            System.out.println("Veillez saisir les notes de l'étudiant "+(i+1)+": ");

            for(int j = 0; j< nNotes; j++){
                System.out.println("note "+(j+1));
                note = scanner.nextFloat();
                pRomo[i][j]=note;
                cumEtudiant[j] = note;
            }
            for(double valeur : cumEtudiant){
                cumNotes +=valeur;
            }
            double moyEtudiant = cumNotes/nNotes;
            System.out.println("l'étudiant "+(i+1)+" a " + moyEtudiant + " de moyenne");

            cumPromo[i]=moyEtudiant;



            if(cumPromo[i]>cumPromo[i-1]){

            }



        }



    }

}
