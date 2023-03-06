package Lab2.Homework;

/**
 * The type Connection.
 */
public class Connection {

    private Location node1;
    private Location node2;
    private Road edge;

    /**
     * Instantiates a new Connection.
     *
     * @param node1 the node 1
     * @param node2 the node 2
     * @param edge  the edge
     */
    public Connection(Location node1, Location node2, Road edge) {
        this.node1 = node1;
        this.node2 = node2;
        this.edge = edge;
    }

    /**
     * Gets node 1.
     *
     * @return the node 1
     */
    public Location getNode1() {
        return node1;
    }

    /**
     * Sets node 1.
     *
     * @param node1 the node 1
     */
    public void setNode1(Location node1) {
        this.node1 = node1;
    }

    /**
     * Gets node 2.
     *
     * @return the node 2
     */
    public Location getNode2() {
        return node2;
    }

    /**
     * Sets node 2.
     *
     * @param node2 the node 2
     */
    public void setNode2(Location node2) {
        this.node2 = node2;
    }

    /**
     * Gets edge.
     *
     * @return the edge
     */
    public Road getEdge() {
        return edge;
    }

    /**
     * Sets edge.
     *
     * @param edge the edge
     */
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
