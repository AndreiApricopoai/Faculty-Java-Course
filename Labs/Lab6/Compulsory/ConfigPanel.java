package Lab6.Compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel dotsLabel;
    JLabel linesLabel;
    JSpinner dotsSpinner;
    JComboBox<Double> linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        super();
        this.frame = frame;
        init();
    }
    private void init() {
        //create topPanel components
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel = new JLabel("Line probability:");
        linesCombo = new JComboBox<>(new Double[]{1.0});
        createButton = new JButton("Create new game");

        //add topPanel components to the topPanel
        this.add(dotsLabel);
        this.add(dotsSpinner);
        this.add(linesLabel);
        this.add(linesCombo);


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                frame.canvas.createBoard();
            }
        });

        this.add(createButton);





    }




}

