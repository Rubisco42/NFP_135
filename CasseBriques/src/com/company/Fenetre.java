package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Fenetre extends JFrame implements KeyListener{


    public Fenetre(){
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        //change la strategie de rafraichissemnt
        createBufferStrategy(2);

        setIgnoreRepaint(true);

        addKeyListener(this);
        requestFocus();
        setFocusable(true);


        initialisationJeu();
    }

    private Void initialisationJeu(){
        int positionHoriRectangle=0;
        Balle balle= new Balle();

        //on cré un ArrayList qui permettra de gérer un affichage multiballe.
        ArrayList<Balle> listeBalle = new ArrayList<>();
        listeBalle.add(balle);



        //on commence une boucle infinie
        while(true){
            Graphics2D dessin = (Graphics2D)getBufferStrategy().getDrawGraphics();


            //effacer le dessin pour donner le mouvement
            dessin.setColor(Color.BLACK);
            dessin.fillRect(0,0,500,500);

            //tout le contenu(à rafraichir)
            balle.setPositionY(balle.getPositionY()+balle.getVitesseVerticale());
            balle.setPositionX(balle.getPositionX()+balle.getVitesseHorizontale());

            listeBalle.forEach((Balle)->balle.dessiner(dessin));
            listeBalle.forEach((Balle)->balle.collisionDroite());
            listeBalle.forEach((Balle)->balle.collisionGauche());
            listeBalle.forEach((Balle)->balle.collisionHaut());
            listeBalle.forEach((Balle)->balle.collisionBas());
            System.out.println(balle.getRayon());










            //on demande le rafraichissement de la fentre
            dessin.dispose();
            getBufferStrategy().show();

            try{
                //thread=processus actuel
                Thread.sleep(1000/90);
            }catch(Exception e){

            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public static void main(String[] args) {
        new Fenetre();

    }
}