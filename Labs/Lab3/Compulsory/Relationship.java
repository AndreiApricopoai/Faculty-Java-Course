package Lab3.Compulsory;

public class Relationship {
    private Node node;
    private String context;

    public Relationship(Node node, String context) {
        this.node = node;
        this.context = context;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Relationship{" +
                "node=" + node +
                ", context='" + context + '\'' +
                '}';
    }
}
