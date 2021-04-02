package com.company;

public class seance_5 {
    public static void prout(String[] args){

        //ce sont des methodes de la classe MAin
        //public static void main(String[] args) {
            //ne pas écrire le nom des variables nombre, java aajoute seul. juste le nombre
            addition(40,2);
            addition(400, 4);

        }
        public static void addition(int nombreA, int nombreB){
            System.out.println(nombreA+nombreB);
        }
        public static int puissance(int nombreA, int nombreB){
            int resultat = -1;
            for(int i=0; i<nombreB;i++){
                resultat= resultat*nombreA;
            }
            System.out.println();
            return resultat;

        }
}
