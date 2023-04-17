package Lab6.Homework;

import java.awt.*;
import java.io.Serializable;

public class Line implements Serializable {

    private Dot startDot;
    private Dot endDot;
    private Color color;
    private boolean isChanged;

    public Line(Dot startDot, Dot endDot, Color color) {
        this.startDot = startDot;
        this.endDot = endDot;
        this.color = color;
        this.isChanged = false;
    }


    public Dot getStartDot() {
        return startDot;
    }

    public void setStartDot(Dot startDot) {
        this.startDot = startDot;
    }

    public Dot getEndDot() {
        return endDot;
    }

    public void setEndDot(Dot endDot) {
        this.endDot = endDot;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(boolean changed) {
        isChanged = changed;
    }
}
