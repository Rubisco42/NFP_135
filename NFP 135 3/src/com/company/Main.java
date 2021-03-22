package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Veuillez saisir le nombre d'étudiants: ");
        int nEtudiants = scanner.nextInt();

        System.out.println("Veuillez saisir le nombre de notes par étudiants: ");
        int nNotes = scanner.nextInt();

        int[][] notes = new int[nEtudiants][nNotes];
        
    }
}
