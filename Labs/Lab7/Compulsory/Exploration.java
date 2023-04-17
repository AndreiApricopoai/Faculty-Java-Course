package Lab7.Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final SharedMemory mem;
    private final ExplorationMap map;
    private final List<Robot> robots;

    public Exploration(int n) {
        mem = new SharedMemory(n);
        map = new ExplorationMap(n);
        robots = new ArrayList<>();
    }

    public void addRobot(Robot robot) {
        robot.setSharedMemory(mem);
        robot.setMap(map);
        robots.add(robot);
    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Exploration explore = new Exploration(n);
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }
}
