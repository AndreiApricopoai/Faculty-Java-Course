package Lab3.Homework;

import java.util.*;

/**
 * The type Network which holds a list of nodes in the network(Person and Company types).
 * @author Apricopoai Andrei
 * @version 1.0.
 */
public class Network {

    private List<Node> nodes;

    /**
     * Instantiates a new Network object.
     */
    public Network() {
        this.nodes = new ArrayList<>();
    }

    /**
     * Instantiates a new Network object.
     *
     * @param nodes the nodes of the network.
     */
    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * Gets nodes.
     *
     * @return the nodes
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Sets nodes.
     *
     * @param nodes the nodes
     */
    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    /**
     * Adds a new node to the network.
     *
     * @param node the node
     * @return the current network updated.
     */
    public Network addNode(Node node){
        for(Node it : nodes){
            if(it.getNodeName().equals(node.getNodeName()))
                return this;
        }
        nodes.add(node);
        return this;
    }

    /**
     * Compute importance of int.
     *
     * @param node the node
     * @return the int
     */
    public int computeImportanceOfNode(Node node){

        // Daca nodul e o persoana atunci returnam numarul de conexiuni catre alte perosane si companii.
        if(node instanceof Person)
            return ((Person) node).getRelationships().size();

        // Daca nodul e o companie returnam numarul de angajati ai companiei.
        if(node instanceof Company)
            return ((Company) node).getEmployees().size();

        // Altfel returnam 0.
        else return 0;
    }

    /**
     * A method that sorts the network.
     */
    public void sortNetwork(){
        // Aici sortam reteaua dupa un Comparator implementat folosind o expresie lambda
        // in care dam ca parametrii doua noduri si returnam nodul cu cele mai multe(putine) legaturi.
        Collections.sort(nodes, (node1, node2) -> computeImportanceOfNode(node1) - computeImportanceOfNode(node2));
    }

    /**
     * Print the network on the screen.
     * The nodes are sorted before printing.
     * It prints the nodes in the sorted order and for each of them we print the connected nodes.
     */
    public void printNetwork(){

        this.sortNetwork(); // Aici sortam reteaua.

        int index = 0;
        for(Node node : nodes)
        {
            // Verificam mai intai tipul nodului (Company sau Person).
            if(node instanceof Company auxCompany){

                System.out.println("Node" + index + ": "+ node.getNodeName() + " - Type: Company");
                System.out.print("connections : ");
                // Aici iteram prin HashMap-ul din Company care contine angajatii si afisam doar numele acelor angajati.
                for(Person person  : auxCompany.getEmployees().keySet())
                {
                    System.out.print(person.getNodeName() + ", ");
                }
                System.out.println("\n");

            }
            if(node instanceof Person auxPerson){

                System.out.println("Node" + index + ": "+ node.getNodeName()+ " - Type: Person");
                System.out.print("connections : ");

                // Aici iteram prin HashMap-ul din Person care contine noduri(persoane sau companii)
                // si afisam numele tuturor nodurilor/
                for(Node iteratorNode  : auxPerson.getRelationships().keySet())
                {
                    System.out.print(iteratorNode.getNodeName() + ", ");
                }
                System.out.println("\n");
            }

            index++;
        }
    }


    /**
     * This function generates a nice textual representation of the Network object created.
     *
     * @return a nice textual representation of the Network object created as a String object.
     */
    @Override
    public String toString() {
        return "Network{" +
                "nodes=" + nodes +
                '}';
    }
}
