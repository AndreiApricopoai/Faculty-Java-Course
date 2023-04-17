package Lab6.Homework;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {

    public static int PLAYER_1 = 1;
    public static int PLAYER_2 = 2;
    public static Color RED_COLOR = Color.RED;
    public static Color BLUE_COLOR = Color.BLUE;
    public static Color EMPTY_COLOR = Color.GRAY;


    private Player playerRed;
    private Player playerBlue;
    private List<Line> gameLines;
    private List<Dot> gameDots;

    public  int currentPlayer;
    public  int counter; // daca trece de 2 atunci urmatorul player selecteaza puncte pentru a crea o linie
    public  boolean is_Game_Over;

    public Dot fistDot;
    public Dot secondDot;

    public Game() {
        this.playerRed = new Player(PLAYER_1, RED_COLOR);
        this.playerBlue = new Player(PLAYER_2, BLUE_COLOR);
        this.gameLines = new ArrayList<>();
        this.gameDots = new ArrayList<>();
        this.currentPlayer = PLAYER_1;
        this.counter = -1;
        this.is_Game_Over = false;
        this.fistDot = null;
        this.secondDot = null;
    }

    public void resetGame(){
        this.playerRed = new Player(PLAYER_1, RED_COLOR);
        this.playerBlue = new Player(PLAYER_2, BLUE_COLOR);
        this.gameLines = new ArrayList<>();
        this.gameDots = new ArrayList<>();
        this.currentPlayer = PLAYER_1;
        this.counter = -1;
        this.is_Game_Over = false;
        this.fistDot = null;
        this.secondDot = null;
    }
    public boolean is_Winner(Player player){
        int size = player.getLines().size();
        for(int i = 0 ; i < size; i++){
            for(int j = i + 1 ; j < size; j++){
                for(int k = j + 1 ; k < size; k++){
                    //check if the three line form a triangle

                    if(is_Triangle(player.getLines().get(i), player.getLines().get(j), player.getLines().get(k))){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public boolean is_Triangle(Line line1, Line line2, Line line3){
        if(line1.getStartDot().equals(line2.getStartDot()) && line1.getEndDot().equals(line3.getStartDot()) && line2.getEndDot().equals(line3.getEndDot())){
            return true;
        }
        if(line1.getStartDot().equals(line2.getEndDot()) && line1.getEndDot().equals(line3.getStartDot()) && line2.getStartDot().equals(line3.getEndDot())){
            return true;
        }
        if(line1.getStartDot().equals(line2.getStartDot()) && line1.getEndDot().equals(line3.getEndDot()) && line2.getEndDot().equals(line3.getStartDot())){
            return true;
        }
        return line1.getStartDot().equals(line2.getEndDot()) && line1.getEndDot().equals(line3.getEndDot()) && line2.getStartDot().equals(line3.getStartDot());
    }

    public boolean isDotPressed(int x, int y){

        for (Dot dot : gameDots) {
            if(x >= dot.getX() - 5 && x <= dot.getX() + 5 && y >= dot.getY() - 5 && y <= dot.getY() + 5){
                return true;
            }
        }

        return false;
    }

    public Dot getPressedDot(int x, int y){

        for (Dot dot : gameDots) {
            if(x >= dot.getX() - 5 && x <= dot.getX() + 5 && y >= dot.getY() - 5 && y <= dot.getY() + 5){
                return dot;
            }
        }

        return null;
    }

    public boolean isLineValid(Dot firstDot, Dot secondDot){

        for (Line line : playerBlue.getLines()){
            if(line.getStartDot().equals(firstDot) && line.getEndDot().equals(secondDot) ||
                    line.getStartDot().equals(secondDot) && line.getEndDot().equals(firstDot)){
                return false;
            }
        }

        for (Line line : playerRed.getLines()){
            if(line.getStartDot().equals(firstDot) && line.getEndDot().equals(secondDot) ||
                    line.getStartDot().equals(secondDot) && line.getEndDot().equals(firstDot)){
                return false;
            }
        }

        return true;

    }


    public int dotConnections(Dot dot){
        int coutner = 0;
        for(Line line : playerBlue.getLines()){
            if (line.getStartDot().equals(dot) || line.getEndDot().equals(dot)){
                coutner++;
            }
        }

        for(Line line : playerRed.getLines()){
            if (line.getStartDot().equals(dot) || line.getEndDot().equals(dot)){
                coutner++;
            }
        }


        return coutner;
    }


    public Player getPlayerRed() {
        return playerRed;
    }

    public void setPlayerRed(Player playerRed) {
        this.playerRed = playerRed;
    }

    public Player getPlayerBlue() {
        return playerBlue;
    }

    public void setPlayerBlue(Player playerBlue) {
        this.playerBlue = playerBlue;
    }

    public List<Line> getGameLines() {
        return gameLines;
    }

    public void setGameLines(List<Line> gameLines) {
        this.gameLines = gameLines;
    }

    public List<Dot> getGameDots() {
        return gameDots;
    }

    public void setGameDots(List<Dot> gameDots) {
        this.gameDots = gameDots;
    }
}
