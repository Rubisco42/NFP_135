package com.company;

public class PointRectangle extends RectangleCB {
//  champs correspondant aux coordonnées X et Y de chaque point du périmètre du rectangle:
    int pointX;
    int pointY;

    public PointRectangle() {
    }

    public int getPointX() {
        return pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    public void setPointY(int pointY) {
        this.pointY = pointY;
    }
}

