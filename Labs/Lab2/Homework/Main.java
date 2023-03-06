package Lab2.Homework;

public class Main {
    public static void main(String[] args){

        //Aici se creeaza diferite locatii
        Location location1 = new Airport("Iasi Airport",100,200,5,1000);
        Location location2 = new Restaurant("MamaMia",30, 100, 5, 20);
        Location location3 = new GasStation("OMW", 100, 100, 2,5);
        Location location4 = new Airport("Bucuresti Airport", 50, 20, 20, 5000);
        Location location5 = new Restaurant("Mesopotamia", 80, -10, 4, 10);
        Location location6 = new GasStation("Lukoil", 10, 15, 3, 7);

        //Aici se creeaza diferite drumuri
        Road road1 = new Express(100, 200, true, false);
        Road road2 = new Express(100, 300, true, true);
        Road road3 = new Highway(130, 500, 20, 50);
        Road road4 = new Highway(130, 1000, 30, 70);

        //Aici se creeaza diferite conexiuni intre locatii si drumuri
        Connection connection1 = new Connection(location1,location2,road1);
        Connection connection2 = new Connection(location1,location6,road2);
        Connection connection3 = new Connection(location2,location6,road3);
        Connection connection4 = new Connection(location5,location3,road4);

        //aici
        Problem problem = new Problem();

        //Aici se incearca adaugarea de locatii iar in caz de eroare programul se opreste
        try {
            problem.addLocation(location1)
                    .addLocation(location2)
                    .addLocation(location3)
                    .addLocation(location4)
                    .addLocation(location5)
                    .addLocation(location6);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);

        }

        //Aici se incearca adaugarea de drumuri iar in caz de eroare programul se opreste
        try {
            problem.addRoad(road1)
                    .addRoad(road2)
                    .addRoad(road3)
                    .addRoad(road4);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        //Aici se incearca adaugarea de conexiuni iar in caz de eroare programul se opreste
        try {
            problem.addConnection(connection1)
                    .addConnection(connection2)
                    .addConnection(connection3)
                    .addConnection(connection4);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);

        }
    /*  Aici se verifica daca instanta problemei este valida
        Nu avem nevoide de aceasta functie intrucat metodele de adaugare locatii, drumuri si conexiuni verifica deja aceste conditii

        if(problem.isValidInstance())
            System.out.println("Valid Instance");
        else
            System.out.println("Invalid Instance");

  */

        //Aici verificam daca se poate ajunge dintr-o locatie in alta locatie printr-o secventa de drumuri
        if(problem.existsPathBetweenLocations(location5,location4))
            System.out.println("putem ajunge");
        else
            System.out.println("nu putem ajunge");





    }
}
