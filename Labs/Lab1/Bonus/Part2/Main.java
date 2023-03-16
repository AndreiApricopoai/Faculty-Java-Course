package Lab1.Bonus.Part2;

import java.util.*;

public class Main {

    public static int numberOfVertices; // Numarul de noduri din graf.
    public static int vertexDegree; // Gradul grafului regulat.

    // Aceasta functie afiseaza pe ecran matricea.
    public static void printMatrix(int[][] matrix, int dimension){
        for(int i = 0 ; i < dimension ; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {


        // Daca avem prea putine argumente.
        if (args.length < 2)
            throw new IllegalArgumentException("Prea PUTINE argumente!");

        // Daca avem prea multe argumente.
        if (args.length > 2)
            throw new IllegalArgumentException("Prea MULTE argumente!");

        String argument1 = args[0]; // Primul argument dat.
        String argument2 = args[1]; // Al doilea argument dat.



        try{ // Aici vedem daca cele doua argumente sunt de tip int sau nu.
             numberOfVertices = Integer.parseInt(argument1);
             vertexDegree = Integer.parseInt(argument2);
        }
        catch (NumberFormatException exception){
            exception.printStackTrace();
        }


        // Aici verificam conditiile de graf regulat
        if((numberOfVertices >= vertexDegree+1) && ((vertexDegree%2 == 1 && numberOfVertices%2 == 0) || (vertexDegree%2 == 0))){

            int[][] matrix = new int[numberOfVertices][numberOfVertices];

            // Setam matricea cu elemente de 0 peste tot.
            for(int i = 0 ; i < numberOfVertices ; i++)
                for(int j = 0 ; j < numberOfVertices ; j++)
                    matrix[i][j] = 0;


            for(int i = 0 ; i < numberOfVertices ; i++){

                    for(int j = i-(vertexDegree/2) ; j <= (i+(vertexDegree/2)) && j!=i ; j++) {
                        // Cream conexiuni cu cei mai apropiati 'vertexDegree' vecini.
                        int aux = 0;

                        if (j < 0)
                            aux = numberOfVertices + j;

                        else if (j >= numberOfVertices)
                            aux = j % numberOfVertices;

                        else aux = j;

                        matrix[i][aux] = 1;
                        matrix[aux][i] = 1;

                    }
                        // In cazul in care gradul este impar, facem la final o conexiune intre nodul curent si cel opus lui in graf.
                        if (vertexDegree % 2 == 1) {
                            int oppositeVertex = (i + (numberOfVertices / 2)) % numberOfVertices;
                            matrix[i][oppositeVertex] = 1;
                            matrix[oppositeVertex][i] = 1;

                        }
                }

            // Afisam matricea creata.
            printMatrix(matrix,numberOfVertices);

        }
        else // Nu sunt indeplinite conditiile.
            System.out.println("Conditiile necesare si suficiente de graf regulat nu sunt indeplinite!");

    }
}
