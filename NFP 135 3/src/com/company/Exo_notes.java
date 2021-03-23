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

        float[][] pRomo = new float[nEtudiants][nNotes];
        float[] cumEtudiant = new float[nNotes];
        float[] cumPromo = new float[nEtudiants];

        float note = -1;
        float moyEtudiant=-1;

        double moyHaute = -1;
        double moyClasse = -1;
        double somme =0;
        double inter =0;

        for(int i = 0; i < nEtudiants; i++){
            System.out.println("Veillez saisir les notes de l'étudiant "+(i+1)+": ");
            float cumNotes = 0;

            for(int j = 0; j< nNotes; j++){
                System.out.println("note "+(j+1));
                note = scanner.nextFloat();
                pRomo[i][j]=note;
                cumEtudiant[j] = note;
            }
            for(double valeur : cumEtudiant){
                cumNotes +=valeur;
            }
            System.out.println();
            moyEtudiant = cumNotes/nNotes;
            System.out.println("l'étudiant "+(i+1)+" a " + moyEtudiant + " de moyenne");

            cumPromo[i]=moyEtudiant;

            if(i>0 && (cumPromo[i]>cumPromo[i-1])){
                moyHaute = cumPromo[i];
                posEtudiant = (i+1);
            }else if(i == 0){
                moyHaute = moyEtudiant;
                posEtudiant = (i+1);
            }

        }
        for (float[] pRo : pRomo){
            for(double valeur : pRo){
                somme += valeur;
            }
        }
        moyClasse = somme/(nEtudiants*nNotes);

        System.out.println("La moyenne de la promotion est de "+moyClasse+". L'étudiant "+posEtudiant+" a les meilleures notes, avec "+moyHaute+" de moyenne.");


    }

}
