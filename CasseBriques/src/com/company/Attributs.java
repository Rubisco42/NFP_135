package com.company;

import javax.sound.sampled.*;
import java.io.*;

public class Attributs {
    // cette classe permettra de gérer divers éléments comme le nombre de vies, le nombres de briques détruites
    //le game over, try again et les sons.
    private int nbrVies;
    private int briquesDétruites;
    private int score;
    private boolean gameOver;
    private boolean lancement;
    private boolean start;
    private boolean tryAgain;
    private boolean victoire;

    //on initialise les différentes variables d'interface Clip
    Clip musiqueJeu;
    Clip lancementBalle;
    Clip collisionParoie;
    Clip collisionBarre;
    Clip collisionBrique;
    Clip destructionBrique;
    Clip lave;
    Clip perdu;

    //on stock tout les chemin pour les fichiers audio sources
    String cheminmusique="src/com/company/sons/Brick Morty.wav";
    String cheminParoie="src/com/company/sons/MUSCInst_Mbira note 1 (ID 2285)_LS.aiff";
    String cheminLave="src/com/company/sons/VOXScrm_Cri wilhelm (ID 0477)_LS.aiff";
    String cheminBarre="src/com/company/sons/MUSCInst_Mbira note 4 (ID 2288)_LS.aiff";
    String cheminBrique="src/com/company/sons/MUSCInst_Mbira note 3 (ID 2287)_LS.aiff";

    public Attributs() {
        setNbrVies(3);
        setBriquesDétruites(0);
        setScore(0);
        setGameOver(false);
        setStart(false);
        setTryAgain(false);
        setVictoire(false);
        chargementMusique();
        chargementSonParoie();
        chargementSonLave();
        chargementSonBarre();
    }

    //gestion de l'audio:
    //methodes pour préparer la lecture du  fichier audio

    //preparation de la musique
    public void chargementMusique(){
        //try catch obligatoire,imposé par la classe AudioInputStream. Permet de savoir si le fichier à bien été trouvé

        try{
            File musique=new File(cheminmusique);//on indique le fichier source
            AudioInputStream brickMorty= AudioSystem.getAudioInputStream(musique);//on cré une piste découpé en "frame"
            // (au lieu des secondes pour une écoute traditionnelle. On pourra accéder à n'importe quel frame du morceau
            //Le dernier frame lu est gardé en mémoire.La classe audiosystem permet d'accéder au système son de l'ordianteur
            musiqueJeu =AudioSystem.getClip();// Clip est une interface qui permet de charger et de diffuser le morceau
            //via le système son de l'ordinateur, en definissant sa durée. Ce qui permettra de naviguer dans le morceau,
            // de l'arrêter...
            musiqueJeu.open(brickMorty);//


        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    //preparation du choc avec les paroies
    public void chargementSonParoie(){
        try{
            File paroie=new File(cheminParoie);
            AudioInputStream chocParoie= AudioSystem.getAudioInputStream(paroie);
            collisionParoie =AudioSystem.getClip();
            collisionParoie.open(chocParoie);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //preparation en cas de passage de la balle dans la bordure inférieure
    public void chargementSonLave(){
        try{
            File perdVie=new File(cheminLave);
            AudioInputStream chocLave= AudioSystem.getAudioInputStream(perdVie);
            lave =AudioSystem.getClip();
            lave.open(chocLave);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //preparation du choc avec la barre
    public void chargementSonBarre(){
        try{
            File barre=new File(cheminBarre);
            AudioInputStream chocBarre= AudioSystem.getAudioInputStream(barre);
            collisionBarre =AudioSystem.getClip();
            collisionBarre.open(chocBarre);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //preparation du choc avec les briques
    public void chargementSonBrique(){
        try{
            File brique=new File(cheminBrique);
            AudioInputStream chocBrique= AudioSystem.getAudioInputStream(brique);
            collisionBrique =AudioSystem.getClip();
            collisionBrique.open(chocBrique);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //methode pour lire la musique en boucle
    public void boucleMusicale(){
        musiqueJeu.setFramePosition(0);//on part du début du morceau
        musiqueJeu.loop(10000000);// repetition infinie
    }

    //on arrête la musique
    public void stopMusique(){
        musiqueJeu.stop();
    }

    //lire les différents sons
    public void chocParoie(){
        collisionParoie.start();
    }

    public void bainLave(){
        lave.start();
    }

    public void chocBarre(){
        collisionBarre.start();
    }



    public int getNbrVies() {
        return nbrVies;
    }

    public int getBriquesDétruites() {
        return briquesDétruites;
    }

    public int getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isStart() {
        return start;
    }

    public boolean isLancement() {
        return lancement;
    }

    public boolean isTryAgain() {
        return tryAgain;
    }

    public boolean isVictoire() {
        return victoire;
    }

    public void setNbrVies(int nbrVies) {
        this.nbrVies = nbrVies;
    }

    public void setBriquesDétruites(int briquesDétruites) {
        this.briquesDétruites = briquesDétruites;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setLancement(boolean lancement) {
        this.lancement = lancement;
    }

    public void setTryAgain(boolean tryAgain) {
        this.tryAgain = tryAgain;
    }

    public void setVictoire(boolean victoire) {
        this.victoire = victoire;
    }
}
