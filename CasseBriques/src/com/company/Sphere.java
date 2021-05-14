package com.company;

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
import java.util.ArrayList;
import java.util.Map;

public class Sphere extends Sprite {

    /*On utilise la méthode Graphics2D.fill/drawOval pour obtenir une sphère. Elle sera dessinée dans un rectangle,
    (ou plutôt un carré dans ce cas) invisible. Les coordonnées X et Y correspondront au coin supérieur gauche de ce
    dernier.
    le rayon sera égal à 1/2*la hauteur= 1/2* la largeur.*/

    private int largeur;
    private int hauteur=getLargeur();
    private int rayon=1/2*getLargeur();

    //les variables suivantes serviront pour la gestion des collisions:

    //on stock la position du centre de la sphere.
    private int[] positionCentre=new int[2];

    //on utilisera une valeur d'angle, de 0 à 359, pour calculer la position des points sur le perimetre de la sphère:
    //on laisse le champ angle accessible aux classes filles pour incrémenter sa valeur sans utiliser d'accesseur.
    protected double angle;

    //on stock toutes les instances de Point dans un ArrayList, pour y accéder via leur index:
    ArrayList<Point>listePoint=new ArrayList<>();

    //on determine la position du centre de la sphere.
    public void setPositionCentreX(){
        positionCentre[0]= getPositionX()+getRayon();
    }
    public void setPositionCentreY(){
        positionCentre[1]= getPositionY()+getRayon();
    }
    public int getPositionCentreX(){
        return positionCentre[0];
    }
    public int getPositionCentreY(){
        return positionCentre[1];
    }

    //on va creer une classe dont chaque instance sera un point du perimètre de la sphère:
    public class Point extends Sphere{
        //les champs suivants correspondent aux coordonnées X et Y de chaque point du périmètre:
        private double pointX;
        private double pointY;

        public Point() {
            this.setPointX();
            this.setPointY();
        }

        //on calcule la position du Point sur le périmètre:

        public void setPointX() {
            this.pointX = getPositionCentreX()+(getRayon()*Math.cos(angle));
        }

        public void setPointY() {
            this.pointY = getPositionCentreY()+(getRayon()*Math.sin(angle));
        }

        //on récupère la position du Point sur le périmètre:

        public double getPointX() {
            return pointX;
        }

        public double getPointY() {
            return pointY;
        }
    }
    // méthode pour remplir l'arraylist avec chaque point sur le périmètre de la sphère:
    public void remplirAl() {
        for(angle=0;angle<360;angle++){
            Point point=new Point();
            listePoint.add(point);
        }
    }

    //méthode pour modifier les coordonnées de chaque instance de Point dans l'arraylist:
    public void majCoordoPoint(){
        setPositionCentreX();
        setPositionCentreY();
        listePoint.forEach((point) -> point.setPointX());
        listePoint.forEach((point) -> point.setPointY());
    }



    // On précise la méthode dessiner pour une sphère:

    @Override
    public void dessiner(Graphics2D dessin) {
        super.dessiner(dessin);
        dessin.fillOval(getPositionX(),getPositionY(),largeur,hauteur);
    }

    //On prévoit les accesseurs pour toutes les variables.
    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getRayon() {
        return rayon;
    }





    //Sphere hérite de Sprite,on surcharge les methodes de la classe Graphics2D.
    @Override
    public void draw(Shape s) {

    }

    @Override
    public boolean drawImage(Image img, AffineTransform xform, ImageObserver obs) {
        return false;
    }

    @Override
    public void drawImage(BufferedImage img, BufferedImageOp op, int x, int y) {

    }

    @Override
    public void drawRenderedImage(RenderedImage img, AffineTransform xform) {

    }

    @Override
    public void drawRenderableImage(RenderableImage img, AffineTransform xform) {

    }

    @Override
    public void drawString(String str, int x, int y) {

    }

    @Override
    public void drawString(String str, float x, float y) {

    }

    @Override
    public void drawString(AttributedCharacterIterator iterator, int x, int y) {

    }

    @Override
    public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
        return false;
    }

    @Override
    public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
        return false;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void drawString(AttributedCharacterIterator iterator, float x, float y) {

    }

    @Override
    public void drawGlyphVector(GlyphVector g, float x, float y) {

    }

    @Override
    public void fill(Shape s) {

    }

    @Override
    public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
        return false;
    }

    @Override
    public GraphicsConfiguration getDeviceConfiguration() {
        return null;
    }

    @Override
    public void setComposite(Composite comp) {

    }

    @Override
    public void setPaint(Paint paint) {

    }

    @Override
    public void setStroke(Stroke s) {

    }

    @Override
    public void setRenderingHint(RenderingHints.Key hintKey, Object hintValue) {

    }

    @Override
    public Object getRenderingHint(RenderingHints.Key hintKey) {
        return null;
    }

    @Override
    public void setRenderingHints(Map<?, ?> hints) {

    }

    @Override
    public void addRenderingHints(Map<?, ?> hints) {

    }

    @Override
    public RenderingHints getRenderingHints() {
        return null;
    }

    @Override
    public Graphics create() {
        return null;
    }

    @Override
    public void translate(int x, int y) {

    }

    @Override
    public void setPaintMode() {

    }

    @Override
    public void setXORMode(Color c1) {

    }

    @Override
    public Font getFont() {
        return null;
    }

    @Override
    public void setFont(Font font) {

    }

    @Override
    public FontMetrics getFontMetrics(Font f) {
        return null;
    }

    @Override
    public Rectangle getClipBounds() {
        return null;
    }

    @Override
    public void clipRect(int x, int y, int width, int height) {

    }

    @Override
    public void setClip(int x, int y, int width, int height) {

    }

    @Override
    public Shape getClip() {
        return null;
    }

    @Override
    public void setClip(Shape clip) {

    }

    @Override
    public void copyArea(int x, int y, int width, int height, int dx, int dy) {

    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {

    }

    @Override
    public void fillRect(int x, int y, int width, int height) {

    }

    @Override
    public void clearRect(int x, int y, int width, int height) {

    }

    @Override
    public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

    }

    @Override
    public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

    }

    @Override
    public void drawOval(int x, int y, int width, int height) {

    }

    @Override
    public void fillOval(int x, int y, int width, int height) {

    }

    @Override
    public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

    }

    @Override
    public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

    }

    @Override
    public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

    }

    @Override
    public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

    }

    @Override
    public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

    }

    @Override
    public void translate(double tx, double ty) {

    }

    @Override
    public void rotate(double theta) {

    }

    @Override
    public void rotate(double theta, double x, double y) {

    }

    @Override
    public void scale(double sx, double sy) {

    }

    @Override
    public void shear(double shx, double shy) {

    }

    @Override
    public void transform(AffineTransform Tx) {

    }

    @Override
    public void setTransform(AffineTransform Tx) {

    }

    @Override
    public AffineTransform getTransform() {
        return null;
    }

    @Override
    public Paint getPaint() {
        return null;
    }

    @Override
    public Composite getComposite() {
        return null;
    }

    @Override
    public void setBackground(Color color) {

    }

    @Override
    public Color getBackground() {
        return null;
    }

    @Override
    public Stroke getStroke() {
        return null;
    }

    @Override
    public void clip(Shape s) {

    }

    @Override
    public FontRenderContext getFontRenderContext() {
        return null;
    }
}