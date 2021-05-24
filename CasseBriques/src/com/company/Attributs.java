package com.company;

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

    public Attributs() {
        setNbrVies(3);
        setBriquesDétruites(0);
        setScore(0);
        setGameOver(false);
        setStart(false);
        setTryAgain(false);
        setVictoire(false);
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
