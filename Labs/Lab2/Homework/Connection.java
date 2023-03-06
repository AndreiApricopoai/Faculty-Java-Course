package Lab2.Homework;

public class Connection {

    private Location node1;
    private Location node2;
    private Road edge;

    public Connection(Location node1, Location node2, Road edge) {
        this.node1 = node1;
        this.node2 = node2;
        this.edge = edge;
    }

    public Location getNode1() {
        return node1;
    }

    public void setNode1(Location node1) {
        this.node1 = node1;
    }

    public Location getNode2() {
        return node2;
    }

    public void setNode2(Location node2) {
        this.node2 = node2;
    }

    public Road getEdge() {
        return edge;
    }

    public void setEdge(Road edge) {
        this.edge = edge;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "node1=" + node1 +
                ", node2=" + node2 +
                ", edge=" + edge +
                '}';
    }
}
