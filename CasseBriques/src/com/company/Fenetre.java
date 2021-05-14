package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        //setFocusable(false);
        initialisationJeu();
    }

    private Void initialisationJeu(){
        int positionHoriRectangle=0;


        //on commence une boucle infinie
        while(true){
            Graphics2D dessin = (Graphics2D)getBufferStrategy().getDrawGraphics();



            //effacer le dessin pour donner le mouvement
            dessin.setColor(Color.BLACK);
            dessin.fillRect(0,0,500,500);

            //tout le contenu(à rafraichir)
            dessin.setColor(Color.RED);
            dessin.fillOval(positionHoriRectangle,100,40,40);

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