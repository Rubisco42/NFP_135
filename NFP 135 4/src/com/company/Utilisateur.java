package com.company;

public class Utilisateur {

    private String nom;
    private int age;

    //le constructeur ne prend aucun type (ni void, ni int...)
    public Utilisateur(String nom, int age) {
        this.nom=nom;
        this.age=age;
            }
    public Utilisateur(int age){
        setNom("inconnu");
        setAge(age);

    }

        //methode setter (car set...)
        //change la valeur du aprametre, utilisation de this
        //set/get suivant = convention,
        //entre
        public void setNom (String nouveauNom){
            nom = nouveauNom.toUpperCase();
        }
        public String getNom () {
            return nom;
        }

        public void setAge ( int age){
            this.age = age;
        }
        // get set peuvent être générés (click droit generate), pour les variable qui n'en ont pas
        public int getAge () {
            return age;
        }
        //et = "java bean"
    }

