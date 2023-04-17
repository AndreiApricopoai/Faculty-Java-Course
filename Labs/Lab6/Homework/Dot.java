package Lab6.Homework;

import java.io.Serializable;

public class Dot implements Serializable {

    private int X;
    private int Y;
    private int radius;
    private boolean isChanged;

    public Dot(int X, int Y, int radius) {
        this.X = X;
        this.Y = Y;
        this.radius = radius;
    }

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getRadius() {
        return radius;
    }


    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(boolean changed) {
        isChanged = changed;
    }
}
