package Lab3.Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args){

        //Aici se creeaza lista care va retine nodurile din retea.
        List<Node> network = new ArrayList<Node>();

        //Aici se creeaza diferite persoane.
        Person person1 = new Person("Andrei");
        Person person2 = new Person("Bogdan");
        Person person3 = new Person("Cristi");

        //Aici se creeaza diferite companii.
        Company company1 = new Company("Oracle");
        Company company2 = new Company("Amazon");
        Company company3 = new Company("Bit");

        //Creare relatii dintre persoane si alte persoane sau companii.
        person1.addRelationship(new Relationship(person2,"Prieten de facultate"));
        person1.addRelationship(new Relationship(company1,"Angajat"));
        person1.addRelationship(new Relationship(person3,"Inamic de razboi (>_<)"));
        person1.addRelationship(new Relationship(company2,"Spala vase"));


        //Aici adaugam persoanele si companiile in retea.
        network.add(person1);
        network.add(person2);
        network.add(person3);
        network.add(company1);
        network.add(company2);
        network.add(company3);

        //Aici se face afisarea retelei(persoane si companii)
        System.out.println(network);

    }
}
