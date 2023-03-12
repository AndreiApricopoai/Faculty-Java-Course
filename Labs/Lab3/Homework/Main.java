package Lab3.Homework;

public class Main {
    public static void main(String[] args){

        // Aici se creeaza Persoanele (Programatorii si Designerii).
        Person p1 = new Designer("Andrei","15/10/2002","DaVinci",false);
        Person p2 = new Designer("Bogdan","15/10/2002","DaVinci",true);
        Person p3 = new Designer("Marius","15/10/2002","DaVinci",false);
        Person p4 = new Programmer("Claudiu","15/10/2002","Java",true);
        Person p5 = new Programmer("Simi","15/10/2002","C++",false);
        Person p6 = new Programmer("Rares","15/10/2002","C#",true);

        // Aici se creeaza Companiile.
        Company c1 = new Company("Amazon",10);
        Company c2 = new Company("Microsoft",15);
        Company c3 = new Company("Continental",8);

        // Aici se creeaza relatiile dintre Persoane si Companii.
        p1.addRelationship(p2,"Prieten");
        p1.addRelationship(p3,"Coleg de munca");
        p1.addRelationship(c1,"Angajat");
        p2.addRelationship(c2,"Intern");
        p2.addRelationship(c3,"Ingrijtor");
        p3.addRelationship(c1,"Programator");
        p5.addRelationship(p6,"Veri");
        p6.addRelationship(p1,"Gym Bros");
        p6.addRelationship(p2,"Gym Bros");


        c3.addEmployee(p4,"Manager");
        c1.addEmployee(p5,"Sclav");
        c2.addEmployee(p4,"Programator");
        c2.addEmployee(p5,"Senior");
        c3.addEmployee(p5,"Asociat");


        // Aici se creeaza reteaua si se adauga nodurile.
        Network network = new Network();
        network.addNode(p1).addNode(p2).addNode(p3)
                .addNode(p4).addNode(p5).addNode(p6)
                .addNode(c1).addNode(c2).addNode(c3);

        // Afisam reteaua.
        network.printNetwork();




    }
}
