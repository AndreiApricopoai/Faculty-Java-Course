package Lab3.Compulsory;

import java.util.ArrayList;
import java.util.List;


/**
 * A class representing a Person which implements the Node interface and the Comparable interface.
 * As members, it has a name object of type String representing the name of the Person
 * and a list of Relationship objects.
 * @see Lab3.Compulsory.Relationship
 * @see Lab3.Compulsory.Node
 * @see java.lang.Comparable
 * @author Apricopoai Andrei
 * @version 1.0
 */
public class Person implements Node, Comparable<Person>{

    private String name;
    private List<Relationship> relationshipList;


    /**
     * Constructs a new Person object with the specified name.
     * Creates a new list of Relationships.
     * @param name the name node of the Person object.
     */
    public Person(String name) {
        this.name = name;
        relationshipList = new ArrayList<Relationship>();
    }

    /**
     * This method takes a Relationship object and puts it in the list.
     *
     * @param relationship the new relationship to be added to the list.
     */
    public void addRelationship(Relationship relationship){
        this.relationshipList.add(relationship);
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
                ", relationshipList=" + relationshipList +
                '}';
    }
}
