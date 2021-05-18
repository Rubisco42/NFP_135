package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

abstract class Sprite extends Graphics2D {
    // La classe sprite sert de base aux éléments mobiles.
    // Elle contient les methodes de bases pour la position des objets, la couleur et leur dessin dans le JPanel
    // correspondant au jeu.

    //variable de la position sur les axes X et Y du sprite
    private int positionX;
    private int positionY;


    // constructeur vide, les constructeurs des classes filles seront plus spécifiques.
    public Sprite() {
    }

    // methode pour afficher le sprite dans le Jpanel.
    public void dessiner(Graphics2D dessin){
    }

    // les accesseurs qui permettront de récupérer/modifier les positions en X et Y du sprite.
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    // on surcharge les accesseurs pour la couleur en raison de l'héritage de Graphics2D, même s'ils ne servent à rien (j'avais, à la base, créé un champ
    // couleur, retiré par la suite)
    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public void setColor(Color c) {

    }
}
