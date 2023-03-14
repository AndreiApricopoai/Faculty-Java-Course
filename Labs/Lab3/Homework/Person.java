package Lab3.Homework;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * The abstract type Person that implements Comparable and Node interfaces.
 * @author Apricopoai Andrei
 * @version 1.0.
 */
public abstract class Person implements Node, Comparable<Person>{

    private String name;
    private String birthDate;
    private Map<Node,String> relationships;


    /**
     * Instantiates a new Person.
     *
     * @param name      the name
     * @param birthDate the birthdate
     */
    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.relationships = new HashMap<>();
    }

    /**
     * Instantiates a new Person.
     *
     * @param name          the name
     * @param birthDate     the birthdate
     * @param relationships the relationships
     */
    public Person(String name, String birthDate, HashMap<Node, String> relationships) {
        this.name = name;
        this.birthDate = birthDate;
        this.relationships = relationships;
    }


    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets birth date.
     *
     * @return the birthdate
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets birthdate.
     *
     * @param birthDate the birthdate
     */
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Gets relationships.
     *
     * @return the relationships
     */
    public Map<Node, String> getRelationships() {
        return relationships;
    }

    /**
     * Sets relationships.
     *
     * @param relationships the relationships
     */
    public void setRelationships(HashMap<Node, String> relationships) {
        this.relationships = relationships;
    }

    /**
     * Add a new relationship to a new node(Person or Company).
     *
     * @param node    the node
     * @param context the context
     * @return the person
     */
    public Person addRelationship(Node node, String context){

        // Daca se incearca adaugarea unui nod cu acelasi nume cu nodul curent se refuza adaugarea si se returneaza curentul.
        if(node.getNodeName().equals(this.getNodeName()))
            return this;
        // Aici adaugam relatia de la nodCurent -> node.
        this.relationships.put(node,context);

        // Verificam daca node e Company si adaugam reliatia node->nodCurent.
        if(node instanceof Company)
            ((Company) node).addEmployee(this,context);

        // Verificam daca node e Person si adaugam reliatia node->nodCurent.
        if(node instanceof Person)
            ((Person) node).getRelationships().put(this,context);
        // Returnam nodul curent.
        return this;
    }


    /**
     * This method is the implementation of the Node interface.
     * @return the name of the current Person object.
     */
    @Override
    public String getNodeName() {
        return this.name;
    }


    /**
     * This method is the implementation of the Comparable interface.
     * @param o the Person object that the current object compares itself to.
     * @return an int (-1,0,1) representing whether the first object has lower priority, equal or higher than the second object.
     */
    @Override
    public int compareTo(Person o) {
        return (this.getNodeName().compareTo(o.getNodeName()));
    }



    /**
     * This function generates a nice textual representation of the Person object created.
     *
     * @return a nice textual representation of the Person object created as a String object.
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", relationships=" + relationships +
                '}';
    }
}
