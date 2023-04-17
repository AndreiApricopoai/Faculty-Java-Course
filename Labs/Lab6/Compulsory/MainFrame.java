package Lab6.Compulsory;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    public MainFrame(String title) {
        super(title);
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
