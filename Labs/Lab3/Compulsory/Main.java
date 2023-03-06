package Lab3.Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args){

        List<Node> network = new ArrayList<Node>();

        Person person1 = new Person("Andrei");
        Person person2 = new Person("Bogdan");
        Person person3 = new Person("Cristi");

        Company company1 = new Company("Oracle");
        Company company2 = new Company("Amazon");
        Company company3 = new Company("Bit");

        //Creare relatii
        person1.addRelationship(new Relationship(person2,"Prieten de facultate"));
        person1.addRelationship(new Relationship(company1,"Angajat"));
        person1.addRelationship(new Relationship(person3,"Inamic de razboi (>_<)"));
        person1.addRelationship(new Relationship(company2,"Spala vase"));


        network.add(person1);
        network.add(person2);
        network.add(person3);
        network.add(company1);
        network.add(company2);
        network.add(company3);

        System.out.println(network);






    }
}
