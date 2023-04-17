package Lab6.Homework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawingPanel extends JPanel {

    final Board board;

    final static int W = 800, H = 600;

    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    public DrawingPanel(Board board) {
        super();
        this.board = board;
        this.createOffscreenImage();
        this.initPanel();
        this.createBoard();
    }
    private void initPanel() {

        this.setPreferredSize(new Dimension(W, H));
        this.setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                if(!board.game.is_Game_Over){
                    int x = e.getX();
                    int y = e.getY();

                    if(board.game.isDotPressed(x, y) && board.game.dotConnections(board.game.getPressedDot(x,y)) < numVertices - 1){

                        if(board.game.fistDot == null)
                            board.game.fistDot = board.game.getPressedDot(x,y);
                        else{
                            board.game.secondDot = board.game.getPressedDot(x,y);
                            if(board.game.isLineValid(board.game.fistDot, board.game.secondDot)) {


                                if (board.game.currentPlayer == Game.PLAYER_1) {
                                    graphics.setColor(board.game.getPlayerRed().getPlayerColor());

                                    graphics.drawLine(board.game.fistDot.getX(),
                                            board.game.fistDot.getY(),
                                            board.game.secondDot.getX(),
                                            board.game.secondDot.getY());
                                    board.game.getPlayerRed().getLines().add(new Line(board.game.fistDot, board.game.secondDot, board.game.getPlayerRed().getPlayerColor()));
                                    board.game.fistDot = null;
                                    board.game.secondDot = null;
                                    board.game.currentPlayer = Game.PLAYER_2;
                                    if (board.game.is_Winner(board.game.getPlayerRed())) {
                                        board.game.is_Game_Over = true;
                                        System.out.println("Player RED won");
                                    }
                                } else {

                                    graphics.setColor(board.game.getPlayerBlue().getPlayerColor());

                                    graphics.drawLine(board.game.fistDot.getX(),
                                            board.game.fistDot.getY(),
                                            board.game.secondDot.getX(),
                                            board.game.secondDot.getY());
                                    board.game.getPlayerBlue().getLines().add(new Line(board.game.fistDot, board.game.secondDot, board.game.getPlayerBlue().getPlayerColor()));
                                    board.game.fistDot = null;
                                    board.game.secondDot = null;
                                    board.game.currentPlayer = Game.PLAYER_1;
                                    if (board.game.is_Winner(board.game.getPlayerBlue())) {
                                        board.game.is_Game_Over = true;
                                        System.out.println("Player BLUE won");
                                    }

                                }
                            }
                        }

                    }

                }

                repaint();
            }
        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }
    final void createBoard() {
        numVertices = (Integer) board.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) board.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }
    private void createVertices() {
        int x0 = W / 2; int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
            board.game.getGameDots().add(new Dot(x[i], y[i],10));
        }
    }


    private void drawLines() {
        for(int i = 0 ; i < numVertices ; i++)
            for(int j = i + 1 ; j < numVertices ; j++)
                if(Math.random() < edgeProbability){  //modifiable
                    graphics.setColor(Color.LIGHT_GRAY);
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                    board.game.getGameLines().add(new Line(new Dot(x[i],y[i],10),new Dot(x[j],y[j],10), Game.EMPTY_COLOR));
                    if(board.game.getPlayerRed().getLines().size() != 0){
                        for(Line line : board.game.getPlayerRed().getLines()){
                            graphics.setColor(Game.RED_COLOR);
                            graphics.drawLine(line.getStartDot().getX(), line.getStartDot().getY(), line.getEndDot().getX(), line.getEndDot().getY());
                        }
                    }

                    if(board.game.getPlayerBlue().getLines().size() != 0){
                        for(Line line : board.game.getPlayerBlue().getLines()){
                            graphics.setColor(Game.BLUE_COLOR);
                            graphics.drawLine(line.getStartDot().getX(), line.getStartDot().getY(), line.getEndDot().getX(), line.getEndDot().getY());
                        }
                    }

                    graphics.setColor(Color.LIGHT_GRAY);
                }
    }

    private void drawVertices() {
        for(int i = 0 ; i < numVertices ; i++) {
            graphics.setColor(Color.BLACK);
            graphics.fillOval(x[i] - 5 , y[i] - 5 , 10, 10);
        }
    }

    public void createScreenShot(String fileName){

        try {
            ImageIO.write(image, "png", new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}
