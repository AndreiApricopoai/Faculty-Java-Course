package Lab1.Bonus.Part2;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*
        // Daca avem prea putine argumente.
        if (args.length < 2)
            throw new IllegalArgumentException("Prea PUTINE argumente!");

        // Daca avem prea multe argumente.
        if (args.length > 2)
            throw new IllegalArgumentException("Prea MULTE argumente!");

        String argument1 = args[0]; // Primul argument dat.
        String argument2 = args[1]; // Al doilea argument dat.
       */
        Scanner scanner = new Scanner(System.in);

        int numberOfVertices = scanner.nextInt(); // Numarul de noduri.
        int vertexDegree = scanner.nextInt(); // Gradul grafului regulat.

        /*
        try{ // Aici vedem daca cele doua argumente sunt de tip int sau nu.
             numberOfVertices = Integer.parseInt(argument1);
             vertexDegree = Integer.parseInt(argument2);
        }
        catch (NumberFormatException exception){
            exception.printStackTrace();
        }

         */


        // Aici verificam conditiile de graf regulat
        if((numberOfVertices >= vertexDegree+1) && (numberOfVertices * vertexDegree) % 2 == 0){

            int[][] matrix = new int[numberOfVertices][numberOfVertices];

        }
        else
            System.out.println("Conditiile necesare si suficiente de graf regulat nu sunt indeplinite!");





    }
}
