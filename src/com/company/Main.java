package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisissez un age ");
        boolean test = scanner.hasNextInt();

        while(test == false){
            System.out.println("vous n'avez pas saisi un nombre");
            test = scanner.hasNextInt();
        }
        int valeur = scanner.nextInt();
        System.out.println(valeur);
    }
}
