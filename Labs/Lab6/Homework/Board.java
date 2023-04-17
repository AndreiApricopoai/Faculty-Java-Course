package Lab6.Homework;

import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;
    Game game;
    App app;

    public Board(Game game, App app) {
        super("My Drawing Application");
        this.game = game;
        this.app = app;
        init();
    }

    public Board(String title, Game game, App app) {
        super(title);
        this.game = game;
        this.app = app;
        init();
    }

    private void init() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        this.add(configPanel, BorderLayout.NORTH);
        this.add(controlPanel, BorderLayout.SOUTH);
        this.add(canvas, BorderLayout.CENTER);


        this.pack();
    }




}
