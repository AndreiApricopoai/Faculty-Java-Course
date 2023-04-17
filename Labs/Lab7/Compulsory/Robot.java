package Lab7.Compulsory;

import java.util.List;
import java.util.Random;

public class Robot implements Runnable{
    private final String name;
    private boolean running;
    private ExplorationMap map;
    private SharedMemory sharedMemory;

    public Robot(String name) {
        this.name = name;
        running = true;
    }

    public String getName() {
        return name;
    }

    public void setSharedMemory(SharedMemory sharedMemory) {
        this.sharedMemory = sharedMemory;
    }

    public void setMap(ExplorationMap map) {
        this.map = map;
    }

    public List<Token> extractTokens() {
        return sharedMemory.extractTokens(map.getN());
    }

    @Override
    public void run() {
        Random random = new Random();
        int n = map.getN();
        while (running) {
            int row = random.nextInt(n);
            int col = random.nextInt(n);
            map.visit(row, col, this);
            try {
                if(map.explorationFinished()) {
                    running = false;
                    System.out.println("Robot " + name + " finished exploration");
                }
                Thread.sleep(150);
            } catch (InterruptedException e) {
                running = false;
                System.out.println("Robot " + name + " was interrupted");
            }
        }
    }
}
