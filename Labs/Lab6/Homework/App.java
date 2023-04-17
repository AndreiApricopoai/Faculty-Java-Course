package Lab6.Homework;

import java.io.*;

public class App {


    Board board;
    Game game;
    String appName;

    public App(String appName) {
        System.out.println("Player Red Won");
        this.appName = appName; // set the app name
        game = new Game();  // create the game logic object for the app
        board = new Board(appName,game,this); // create a new board for the app
    }



    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
        this.board.setName(appName);
    }


    /**
     * This method is used to run the game
     */
    public void run(){
        board.setVisible(true);
    }

    public void serializeGameState(String path){

        try {
            FileOutputStream f = new FileOutputStream(new File(path));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(game);
            o.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void loadGameState(String path){
        try {
            FileInputStream f = new FileInputStream(new File(path));
            ObjectInputStream o = new ObjectInputStream(f);
            Game deserializedGame = (Game) o.readObject();
            this.game = deserializedGame;
            o.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
