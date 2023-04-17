package Lab6.Compulsory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton loadBtn;
    JButton saveBtn;
    JButton resetBtn;
    JButton exitBtn;


    public ControlPanel(MainFrame frame) {
        super();
        this.frame = frame;
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
    }
    private void saveGame(ActionEvent actionEvent) {
    }
    private void loadGame(ActionEvent actionEvent) {
    }
    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

}
