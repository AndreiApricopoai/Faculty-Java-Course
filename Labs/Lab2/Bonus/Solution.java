package Lab2.Bonus;

import Lab2.Homework.Connection;
import Lab2.Homework.Location;
import Lab2.Homework.Problem;

import java.util.HashMap;

/**
 * The type Solution.
 * @author Apricopoai Andrei
 * @version 1.0
 */
public class Solution {

    /**
     * The constant FASTEST_ROUTE representing an option.
     */
    public static final int FASTEST_ROUTE = 1;
    /**
     * The constant SHORTEST_ROUTE representing an option.
     */
    public static final int SHORTEST_ROUTE = 2;


    private final Problem problem;   // Contains the roads, locations, and the connections between locations.


    /**
     * Instantiates a new Solution.
     *
     * @param problem the problem
     * @throws Exception the exception
     */
    public Solution(Problem problem) throws Exception {

        if(problem.isValidInstance())
            this.problem = problem;
        else
            throw new Exception("Invalid Problem!");
    }

    /**
     * Solve.
     *
     * @param location1 the location 1 representing the starting node.
     * @param location2 the location 2 representing the destination node.
     * @param option    the option representing the option of fastest or shortest route.
     */
    public void solve(Location location1, Location location2, int option){

        if(problem.existsPathBetweenLocations(location1,location2) && (option == FASTEST_ROUTE || option == SHORTEST_ROUTE)){
            int n = problem.getLocations().size();
            int[][] optionMatrix = new int[n][n];

            // Punem 0 in toata matricea
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++)
                    optionMatrix[i][j] = 0;
            }

            HashMap<Location, Integer> map = new HashMap<>();

            int k = 0;

            // Asignam pentru fiecare locatie cate un index de la 0 la n-1
            for (Location location : problem.getLocations()) {
                map.put(location, Integer.valueOf(k));
                k++;
            }

            // Pentru fiecare conexiune punem in matrice pe pozitia (i,j) = 1 si (j,i) = 1
            for (Connection connection : problem.getConnections()) {
                int i = map.get(connection.getNode1()).intValue();
                int j = map.get(connection.getNode2()).intValue();

                if(option == SHORTEST_ROUTE){
                    optionMatrix[i][j] = connection.getEdge().getLength();
                    optionMatrix[j][i] = connection.getEdge().getLength();

                } else {
                    optionMatrix[i][j] = connection.getEdge().getLength()/connection.getEdge().getSpeedLimit();
                    optionMatrix[j][i] = connection.getEdge().getLength()/connection.getEdge().getSpeedLimit();

                }

            }

            int start = map.get(location1).intValue(); // i = starting node
            int end = map.get(location2).intValue(); // j = destination node

            // Aici afisam matricea
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++)
                {
                    System.out.print(optionMatrix[i][j] + " ");
                }
                System.out.println();
            }


            int result = Dijkstra(optionMatrix, start, end);

            if(option == FASTEST_ROUTE)
                System.out.println("The fastest route between the two locations takes " + result +" hours!");
            else
                System.out.println("The shortest route between the two locations is " + result +"km long!");

        }
        else System.out.println("There is no path between the two locations or invalid option!");
    }


    /**
     * Dijkstra int.
     *
     * @param matrix the adjacency matrix of our network of locations and roads.
     * @param source the source representing the starting node.
     * @param target the target
     * @return the int representing the shortest or fastest path as its distance.
     */
    public static int Dijkstra(int[][] matrix, int source, int target) {
        int n = matrix.length;

        int[] shortestDistances = new int[n];
        boolean[] visited = new boolean[n];

        // Initialize shortestDistances array
        for (int v = 0; v < n; v++) {
            shortestDistances[v] = Integer.MAX_VALUE;
            visited[v] = false;
        }
        shortestDistances[source] = 0;

        for (int i = 0; i < n; i++) {
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;

            // Find the unvisited vertex with the shortest distance
            for (int j = 0; j < n; j++) {
                if (!visited[j] && shortestDistances[j] < shortestDistance) {
                    nearestVertex = j;
                    shortestDistance = shortestDistances[j];
                }
            }

            // If no unvisited vertex was found, exit the loop
            if (nearestVertex == -1) {
                break;
            }

            // Mark the nearest vertex as visited
            visited[nearestVertex] = true;

            // Update the distances to the neighbors of the nearest vertex
            for (int j = 0; j < n; j++) {
                int edgeDistance = matrix[nearestVertex][j];
                if (edgeDistance > 0 && shortestDistance != Integer.MAX_VALUE) {
                    int newDistance = shortestDistance + edgeDistance;
                    if (newDistance < shortestDistances[j]) {
                        shortestDistances[j] = newDistance;
                    }
                }
            }
        }

        // Return the shortest distance to the target vertex
        return shortestDistances[target];
    }


    /**
     *
     * @return a textual representation of the Solution object.
     */

    @Override
    public String toString() {
        return "Solution{" +
                "problem=" + problem +
                '}';
    }
}
