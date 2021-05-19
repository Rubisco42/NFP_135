package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Fenetre extends JFrame implements KeyListener{
    boolean flecheGauche=false;
    boolean flecheDroite=false;

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
        // on initialise les booléens qui seront utilisés pour le déplacement



        // on cré d'abord la barre pour générer la balle sur le centre du coté supérieur
        Barre barre= new Barre();
        barre.remplirCoteHaut();
        barre.remplirCoteDroit();
        barre.remplirCoteGauche();


        Balle balle= new Balle(barre);
        balle.remplirlistePointSphere(balle);

        //on cré un ArrayList qui permettra de gérer un affichage multiballe.
        ArrayList<Balle> listeBalle = new ArrayList<>();
        listeBalle.add(balle);

        // on prepare le remplissage de rectangle avec un gradient de couleur, il est necessaire d'avoir toutes les
        // coordonnées de gradient possibles. Sympa mais ralenti le jeu une fois dans la boucle infinie.
        GradientPaint lave;
        ArrayList<GradientPaint>bordureBas=new ArrayList<>();
        for(int i=0;i<501;i++){
            lave=new GradientPaint(i,500,Color.YELLOW,i,490,Color.RED,true);
            bordureBas.add(lave);
        }




        // on commence une boucle infinie
        while(true){
            Graphics2D dessin = (Graphics2D)getBufferStrategy().getDrawGraphics();

            // effacer le dessin pour donner le mouvement et affichage des bordures de la zone de jeu:
            dessin.setColor(Color.BLACK);
            dessin.fillRect(0,0,500,500);
            // bordure haute (chez moi la balle rentre dans l'entête de la fenêtre)
            dessin.setColor(Color.DARK_GRAY);
            dessin.fillRect(0,0,500,40);
            // bordure gauche:
            dessin.setColor(Color.DARK_GRAY);
            dessin.fillRect(0,0,5,490);
            // bordure droite
            dessin.setColor(Color.DARK_GRAY);
            dessin.fillRect(497,0,5,490);
            // bordure bas
            //on utilise une boucle pour afficher tous les rectangles avec les bonnes cordonnées de gradient(ralenti le jeu)
            for(int i=0;i<501;i++) {
                dessin.setPaint(bordureBas.get(i));
                dessin.fillRect(i, 490, 1, 10);
            }


            // tout le contenu à rafraichir:

            // On implémente les méthodes qui permettront le déplacement fluide de la barre:
            if(flecheGauche==true){
                barre.deplacementGauche();
                barre.modifMilieu();
                barre.majCoteHaut();
                barre.majCoteGauche();
                barre.majCoteDroit();
            }else if (flecheDroite==true){
                barre.deplacementDroite();
                barre.modifMilieu();
                barre.majCoteHaut();
                barre.majCoteGauche();
                barre.majCoteDroit();
            }

            // on modifie les positions X et Y de la (les) balle(s) pour qu'elle(s) se déplace(nt) sur l'écran:
            balle.setPositionY(balle.getPositionY()+balle.getVitesseVerticale());
            balle.setPositionX(balle.getPositionX()+balle.getVitesseHorizontale());

            // on met à jour les psoition du centre de la (les) balle(s) pour pouvoir mettre à jour les points du périmetre
            listeBalle.forEach((Balle)-> balle.majCoordoCentre(balle));
            listeBalle.forEach((Balle)->balle.majListePointSphere(balle));

            //on affiche la barre
            barre.dessiner(dessin);
            // on affiche la(les) balle(s)
            listeBalle.forEach((Balle)->balle.dessiner(dessin));
            //listeBalle.forEach((Balle)->balle.afficherPointPerimetre(dessin, balle));

            // gestion des collision de la balle avec les paroies de l'environnement.
            listeBalle.forEach((Balle)->balle.collisionDroite());
            listeBalle.forEach((Balle)->balle.collisionGauche());
            listeBalle.forEach((Balle)->balle.collisionHaut());
            listeBalle.forEach((Balle)->balle.collisionBas());
            //System.out.println(balle.getPositionCentreX());
            //System.out.println(balle.getPositionCentreY());
            //System.out.println(balle.getListePointSphere().get(6).getPointX());

            //on demande le rafraichissement de la fentre
            dessin.dispose();
            getBufferStrategy().show();

            try{
                // thread=processus actuel
                // on defini la fréquence de rafraichissement en incluant une pause dans l'execution de la boucle
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
        // selon la fleche directionnelle enfoncée, on initialise le booléen correspondant à true
        //en utilisant le booléen pour controler le déplacement de la barre, on suprime l'impact de la répétition des touches
        // enfoncées sur la fluidité du déplacement de la barre.
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            flecheGauche=true;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            flecheDroite=true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // une fois la touche relachée, le booléen repasse à false et la barre ne se déplace plus
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            flecheGauche=false;
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            flecheDroite=false;
        }

    }


    public static void main(String[] args) {
        new Fenetre();

    }
}