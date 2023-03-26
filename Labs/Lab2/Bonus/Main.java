package Lab2.Bonus;

import Lab2.Homework.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static Problem generateLargeProblem(int maxLocations, int maxRoads){
        Problem problem = new Problem();

        Random random = new Random();
        int randomLocationNumber = random.nextInt(maxLocations - 10) + 10;
        int randomRoadsNumber = random.nextInt(maxRoads - 10) + 10;

        return problem;
    }

    public static void main(String[] args) {

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
        //Connection connection2 = new Connection(location1,location6,road2);
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
                    // .addConnection(connection2)
                    .addConnection(connection3)
                    .addConnection(connection4);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);

        }


        // Aici se incearca adaugarea unei probleme la un obiect care rezolva problema.
        try {
            // In cazul in care problema atasata este invalida se arunca o exceptie.
            Solution solution = new Solution(problem);
            solution.solve(location1,location6,Solution.SHORTEST_ROUTE);

        }
        catch (Exception e){
            e.printStackTrace();
        }


        //Aici generam in mod random o instanta mai mare a unei probleme.
//        Problem randomInstance = generateLargeProblem();
//        try {
//            Location start =
//            Solution solution = new Solution(randomInstance);
//            solution.solve(location1,location6,Solution.SHORTEST_ROUTE);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }




    }
}
