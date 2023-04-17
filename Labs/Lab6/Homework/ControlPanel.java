package Lab6.Homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ControlPanel extends JPanel {
    final Board board;
    JButton loadBtn;
    JButton saveBtn;
    JButton resetBtn;
    JButton exitBtn;


    public ControlPanel(Board board) {
        super();
        this.board = board;
        init();
    }
    private void init() {
        setLayout(new GridLayout(1, 4));

        loadBtn = new JButton("Load");
        saveBtn = new JButton("Save");
        resetBtn = new JButton("Reset");
        exitBtn = new JButton("Exit");

        this.add(loadBtn);
        this.add(saveBtn);
        this.add(resetBtn);
        this.add(exitBtn);

        //configure listeners for all buttons
        resetBtn.addActionListener(this::resetGame);
        saveBtn.addActionListener(this::saveGame);
        loadBtn.addActionListener(this::loadGame);
        exitBtn.addActionListener(this::exitGame);


    }


    private void resetGame(ActionEvent actionEvent) {
        board.configPanel.reset();
        board.game.resetGame(); // first reset the current game state
        board.canvas.createBoard(); // then redraw the board and create the new game state
        System.out.println("Reset");
    }

    private void saveGame(ActionEvent actionEvent) {

        //get a random integer between 0 and 100
        int randomInt = (int) (Math.random() * 1000);
        board.canvas.createScreenShot("C:\\Users\\haske\\Desktop\\Homework6\\src\\main\\resources\\screenshot"+randomInt +".png");
        board.app.serializeGameState("C:\\Users\\haske\\Desktop\\Homework6\\src\\main\\resources\\serializedState.txt");
    }
    private void loadGame(ActionEvent actionEvent) {

        board.app.loadGameState("C:\\Users\\haske\\Desktop\\Homework6\\src\\main\\resources\\serializedState.txt");
        board.canvas.repaint();

    }
    private void exitGame(ActionEvent e) {
        board.dispose();
    }
}
