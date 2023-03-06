package Lab3.Compulsory;

import java.util.ArrayList;
import java.util.List;



public class Person implements Node, Comparable<Person>{

    private String name;
    private List<Relationship> relationshipList;

    public Person(String name) {
        this.name = name;
        relationshipList = new ArrayList<Relationship>();
    }

    public void addRelationship(Relationship relationship){
        this.relationshipList.add(relationship);
    }

    @Override
    public String getNodeName() {
        return this.name;
    }

    @Override
    public int compareTo(Person o) {
        return (this.getNodeName().compareTo(o.getNodeName()));
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", relationshipList=" + relationshipList +
                '}';
    }
}
