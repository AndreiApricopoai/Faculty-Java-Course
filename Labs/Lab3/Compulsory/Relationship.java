package Lab3.Compulsory;

/**
 * A class representing a Relationship between two Nodes in a network.
 * This class contains a node and a context that describe the relationship.
 *
 * The node represents the second node from the relationship.
 * The context represents the reason that bounds the two nodes together.
 *
 * @author Apricopoai Andrei
 * @version 1.0
 */
public class Relationship {
    private Node node;
    private String context;


    /**
     * Constructs a new Relationship object with the specified node and context.
     *
     * @param node the second node involved in the relationship.
     * @param context the context that describes the relationship.
     */
    public Relationship(Node node, String context) {
        this.node = node;
        this.context = context;
    }



    /**
     * Getter for the node member.
     *
     * @return the node of the current relationship.
     */
    public Node getNode() {
        return node;
    }


    /**
     * Setter for the current node of the relationship.
     *
     * @param node a node that will be set as the current node of the relationship.
     */
    public void setNode(Node node) {
        this.node = node;
    }


    /**
     * Getter for the context member.
     *
     * @return the context of the current relationship.
     */
    public String getContext() {
        return context;
    }


    /**
     * Setter for the current context of the relationship.
     *
     * @param context a context that will be set as the current context of the relationship.
     */
    public void setContext(String context) {
        this.context = context;
    }


    /**
     * This function generates a nice textual representation of the Relationship object created.
     *
     * @return a nice textual representation of the Relationship object created as a String object.
     */
    @Override
    public String toString() {
        return "Relationship{" +
                "node=" + node +
                ", context='" + context + '\'' +
                '}';
    }
}
