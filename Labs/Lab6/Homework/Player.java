package Lab6.Homework;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {



    private int playerID;
    private Color playerColor;
    private List<Line> lines;

    public Player(int playerID, Color playerColor) {
        this.playerID = playerID;
        this.playerColor = playerColor;
        this.lines = new ArrayList<>();
    }

    public int getPlayerID() {
        return playerID;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }
}
