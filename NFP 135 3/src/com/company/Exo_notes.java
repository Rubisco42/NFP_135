package com.company;

import java.util.Scanner;

public class Exo_notes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir le nombre d'étudiants: ");
        int nEtudiants = scanner.nextInt();

        System.out.println("Veuillez saisir le nombre de notes par étudiants: ");
        int nNotes = scanner.nextInt();

        float[][] pRomo = new float[nEtudiants][nNotes];
        float[] cumEtudiant = new float[nNotes];
        float[] cumPromo = new float [nEtudiants];

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
            for(float valeur : cumEtudiant){
                cumNotes +=valeur;
            }
            float moyEtudiant = cumNotes/nNotes;
            System.out.println("l'étudiant "+(i+1)+" a " + moyEtudiant + " de moyenne");

        }



    }

}
