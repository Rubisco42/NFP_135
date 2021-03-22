package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir le nombre d'étudiants: ");
        int nEtudiants = scanner.nextInt();

        System.out.println("Veuillez saisir le nombre de notes par étudiants: ");
        int nNotes = scanner.nextInt();

        double[][] promo = new double[nEtudiants][nNotes];

        double note = -1;

        for(int i = 0; i < nEtudiants; i++){
            System.out.println("Veillez saisir les notes de l'étudiant "+i);

            for(int j = 0; j< nNotes; j++){
                System.out.println("note "+(j+1));
                note = scanner.nextFloat();
                promo[i][j]=note;
            }

        }



    }
}
