package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class CasseBriques extends JFrame implements KeyListener{
    // on initialise les booléens qui seront utilisés pour le déplacement de la barre
    boolean flecheGauche=false;
    boolean flecheDroite=false;

    // on initialise l'arraylist qui accueuillera les briques à détruire
    ArrayList<Briques>listeBriques=new ArrayList<>();
    // on passe la variable brique en variable générale


    public CasseBriques(){
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
        Briques brique = null;
        // on cré d'abord la barre pour générer la balle sur le centre du coté supérieur
        Barre barre= new Barre();
        barre.remplirCoteHaut();
        barre.remplirCoteDroit();
        barre.remplirCoteGauche();

        // on génère la barre
        Balle balle= new Balle(barre);
        balle.remplirlistePointSphere(balle);

        //on cré un ArrayList qui permettra de gérer un affichage multiballe.
        ArrayList<Balle> listeBalle = new ArrayList<>();
        listeBalle.add(balle);

        // on génère l'arrayList de briques à détruire (5 lignes et 10 colones de briques):
        for(int i=0; i<5;i++){
            for(int j=0;j<10;j++){
                brique=new Briques();
                brique.setPositionX(10+(j*brique.getLargeur()));
                brique.setPositionY(60+(i*brique.getHauteur()));
                brique.remplirCoteHaut();
                brique.remplirCoteBas();
                brique.remplirCoteGauche();
                brique.remplirCoteDroit();
                listeBriques.add(brique);
            }

        }
        // on prepare le remplissage de rectangle avec un gradient de couleur, il est necessaire d'avoir toutes les
        // coordonnées de gradient possibles. Sympa mais ralenti le jeu une fois dans la boucle infinie sous ma distro
        // de Gnu/linux.
        GradientPaint lave;
        ArrayList<GradientPaint>bordureBas=new ArrayList<>();
        for(int i=0;i<501;i++){
            lave=new GradientPaint(i,500,Color.YELLOW,i,490,Color.RED,false);
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
            dessin.fillRect(0,0,500,60);
            // bordure gauche:
            dessin.setColor(Color.DARK_GRAY);
            dessin.fillRect(0,0,10,500);
            // bordure droite
            dessin.setColor(Color.DARK_GRAY);
            dessin.fillRect(490,0,10,500);
            // bordure bas
            //on utilise une boucle pour afficher tous les rectangles avec les bonnes cordonnées de gradient
            // (ralenti le jeu sous ma distro GNU/Linux, aucun pb sous window)
            for(int i=10;i<490;i++) {
                dessin.setPaint(bordureBas.get(i));
                dessin.fillRect(i, 490, 1, 10);
            }

            // tout le contenu à rafraichir:

            // On implémente les méthodes qui permettront le déplacement fluide de la barre:
            if(flecheGauche==true){
                barre.deplacementGauche();
            }else if (flecheDroite==true){
                barre.deplacementDroite();
            }

            // maj des arraylistes de points et des centre de chaque coté de la barre potentiellement en contact avec la balle
            barre.modifMilieuHaut(barre);
            barre.modifMilieuGauche(barre);
            barre.modifMilieuDroit(barre);
            barre.majCoteHaut(barre);
            barre.majCoteGauche(barre);
            barre.majCoteDroit(barre);



            // on modifie les positions X et Y de la (les) balle(s) pour qu'elle(s) se déplace(nt) sur l'écran:
            balle.setPositionY(balle.getPositionY()+balle.getVitesseVerticale());
            balle.setPositionX(balle.getPositionX()+balle.getVitesseHorizontale());

            // on met à jour les psoition du centre de la (les) balle(s) pour pouvoir mettre à jour les points du périmetre
            listeBalle.forEach((Balle)-> balle.majCoordoCentre(balle));
            listeBalle.forEach((Balle)->balle.majListePointSphere(balle));

            // on affiche les briques qui n'ont pas été détruites
            for(int i=0; i<listeBriques.size();i++){
                listeBriques.get(i).dessiner(dessin);
            }
            // on affiche un cadrillage pour délimiter chaque brique
            dessin.setColor(Color.BLACK);
            dessin.setStroke(new BasicStroke(1.0f));
            dessin.drawLine(10,60,490,60);
            dessin.drawLine(10,90,490,90);
            dessin.drawLine(10,120,490,120);
            dessin.drawLine(10,120,490,120);
            dessin.drawLine(10,150,490,150);
            dessin.drawLine(10,180,490,180);
            dessin.drawLine(10,210,490,210);

            dessin.drawLine(10,60,10,210);
            dessin.drawLine(58,60,58,210);
            dessin.drawLine(106,60,106,210);
            dessin.drawLine(154,60,154,210);
            dessin.drawLine(202,60,202,210);
            dessin.drawLine(250,60,250,210);
            dessin.drawLine(298,60,298,210);
            dessin.drawLine(346,60,346,210);
            dessin.drawLine(394,60,394,210);
            dessin.drawLine(442,60,442,210);
            dessin.drawLine(490,60,490,210);

            //on affiche la barre
            barre.dessiner(dessin);

            // on affiche la(les) balle(s)
            listeBalle.forEach((Balle)->balle.dessiner(dessin));
            //listeBalle.forEach((Balle)->balle.afficherPointPerimetre(dessin, balle));

            //gestion de la collision avec les briques:
            // avec le côté supérieur:
            for(int i =0; i<balle.getListePointSphere().size();i++){
                for(int j=0;j<listeBriques.size();j++){
                    for(int k=0;k<listeBriques.get(j).getCoteHaut().size();k++){
                        if(listeBriques.get(j).isEstdetruite()==false){
                            int balleX=balle.getListePointSphere().get(i).getPointX();
                            int balleY=balle.getListePointSphere().get(i).getPointY();
                            int briqueX=listeBriques.get(j).getCoteHaut().get(k).getPointX();
                            int briqueY=listeBriques.get(j).getCoteHaut().get(k).getPointY();
                            int resistanceBrique=listeBriques.get(j).getResistance();

                            if((balleX==briqueX)&&(balleY==briqueY)){
                                if(resistanceBrique<1){
                                    listeBriques.get(j).setEstdetruite(true);

                                }else{
                                    listeBriques.get(j).setResistance(resistanceBrique-1);
                                }
                            }
                        }
                    }
                }
            }
            // gestion des collision de la balle avec les paroies de l'environnement.
            listeBalle.forEach((Balle)->balle.collisionDroite());
            listeBalle.forEach((Balle)->balle.collisionGauche());
            listeBalle.forEach((Balle)->balle.collisionHaut());
            listeBalle.forEach((Balle)->balle.collisionBas());

            // gestion de la collision de la balle avec la barre
            listeBalle.forEach((Balle)->balle.collisionBarreHaut(barre,balle));
            listeBalle.forEach((Balle)->balle.collisionBarreGauche(barre,balle));
            listeBalle.forEach((Balle)->balle.collisionBarreDroit(barre,balle));

            //System.out.println(balle.getPositionCentreX());
            //System.out.println(balle.getPositionCentreY());
            //System.out.println(balle.getListePointSphere().get(6).getPointX());

            //on demande le rafraichissement de la fentre
            dessin.dispose();
            getBufferStrategy().show();

            try{
                // thread=processus actuel
                // on defini la fréquence de rafraichissement en incluant une pause dans l'execution de la boucle
                Thread.sleep(1000/165);// j'ai joué sur ce paramètre pour que le jeu soit plus dynamique à cause
                //de la méthode de gestion des collisions (barre/briques) implémentée.
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
        new CasseBriques();

    }
}