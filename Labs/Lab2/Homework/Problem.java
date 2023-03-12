package Lab2.Homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


/**
 * The type Problem.
 */
public class Problem {

    private ArrayList<Location> locations;
    private ArrayList<Road> roads;
    private ArrayList<Connection> connections;

    /**
     * Instantiates a new Problem.
     * Here we create 3 new List objects representing the location list, the road list, and the connections List.
     */
    public Problem(){
        this.locations = new ArrayList<Location>();
        this.roads = new ArrayList<Road>();
        this.connections = new ArrayList<Connection>();
    }

    /**
     * Add location problem.
     *
     * @param addedLocation the added location
     * @return the problem
     * @throws Exception the exception
     */
    public Problem addLocation(Location addedLocation) throws Exception {

        // Ne asiguram sa nu existe alta locatie egala cu cea pe care dorim sa o adaugam.
        for (Location location : locations) {
            if(location.equals(addedLocation))
                throw new Exception("Eroare add location");
        }
        // La final daca totul e ok, se adauga locatia.
        locations.add(addedLocation);

        return this; // Dam return la obiectul current pentru a avea un chain de metode.
    }

    /**
     * Add road problem.
     *
     * @param addedRoad the added road
     * @return the problem
     * @throws Exception the exception
     */
    public Problem addRoad(Road addedRoad) throws Exception {

        // Ne asiguram sa nu existe alt drum egal cu cel pe care dorim sa il adaugam.
        for (Road road : roads) {
            if(road.equals(addedRoad))
                throw new Exception("Eroare add road"); // thow error
        }
        // La final daca totul e ok, se adauga drumul.
        roads.add(addedRoad);

        return this; // Dam return la obiectul current pentru a avea un chain de metode.
    }




    /**
     * Add connection problem.
     *
     * @param addedConnection the added connection
     * @return the problem
     * @throws Exception the exception
     */
    public Problem addConnection(Connection addedConnection) throws Exception {

        // Aici verificam:
        // 1. Sa nu avem conexiune de la un nod la el insusi
        // 2. Sa nu avem 2 conexiuni legate prin aceelasi drum
        // 3. Sa nu avem 2 conexiuni cu aceleasi noduri
        for (Connection connection : connections) {
            if(addedConnection.getNode1().equals(addedConnection.getNode2()))
                throw new Exception("Eroare add connection");
            if(connection.getEdge().equals(addedConnection.getEdge()))
                throw new Exception("Eroare add connection");
            if(connection.getNode1().equals(addedConnection.getNode1()) && connection.getNode2().equals(addedConnection.getNode2()))
                throw new Exception("Eroare add connection");
            if(connection.getNode1().equals(addedConnection.getNode2()) && connection.getNode2().equals(addedConnection.getNode1()))
                throw new Exception("Eroare add connection");
        }

        // Aici verificam conditita ca lungimea drumului sa nu fie mai mica decat
        // distanta euclidiana dintre cele 2 locatii
        double x1 = (double) addedConnection.getNode1().getxPosition();
        double x2 = (double) addedConnection.getNode2().getxPosition();
        double y1 = (double) addedConnection.getNode1().getyPosition();
        double y2 = (double) addedConnection.getNode2().getyPosition();

        double distance =  Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));


        if(addedConnection.getEdge().getLength() < (int)distance)
            throw new Exception("Eroare add connection");

        // In caz ca totul merge bine, adaugam conexiunea.
        connections.add(addedConnection);


        return this; // Dam return la obiectul current pentru a avea un chain de metode.
    }


    /**
     *
     * @param graph the actual graph matrix to be parsed.
     * @param start the starting node.
     * @param destination the destination node.
     * @param n number of nodes in the graph.
     * @return a boolean value representing whether we can get to node end from node start or not.
     */
    private static boolean BFS(int[][] graph, int start, int destination, int n) {
        boolean[] visited = new boolean[n]; // to keep track of visited nodes
        Queue<Integer> queue = new LinkedList<>(); // to keep track of nodes to be visited
        visited[start] = true; // mark the starting node as visited
        queue.add(start); // add the starting node to the queue

        while (!queue.isEmpty()) {
            int current = queue.poll(); // remove the first node from the queue and process it
            if (current == destination) { // if we have reached the target node, return true
                return true;
            }
            for (int i = 0; i < n; i++) {
                if (graph[current][i] == 1 && !visited[i]) { // if there is an edge from the current node to the next node, and it hasn't been visited yet
                    visited[i] = true; // mark the next node as visited
                    queue.add(i); // add the next node to the queue
                }
            }
        }
        return false; // if we have exhausted all possible paths and still haven't reached the target node, return false
    }




    /**
     * Exists path between locations boolean.
     *
     * @param location1 the location 1 which is the starting node.
     * @param location2 the location 2 which is the destination node.
     * @return a boolean value representing whether we can get to node end from node start or not.
     */
    public boolean existsPathBetweenLocations(Location location1, Location location2){

        int n = locations.size(); // Aici punem in n numarul de noduri
        int[][] graph = new int[n][n]; // Cream o matrice de n x n

        // Punem 0 in toata matricea
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++)
                graph[i][j] = 0;
        }

        HashMap<Location, Integer> map = new HashMap<>();

        int k = 0;

        // Asignam pentru fiecare locatie cate un index de la 0 la n-1
        for (Location location : locations) {
            map.put(location,new Integer(k));
            k++;
        }

        // Pentru fiecare conexiune punem in matrice pe pozitia (i,j) = 1 si (j,i) = 1
        for (Connection connection : connections) {
            int i = map.get(connection.getNode1()).intValue();
            int j = map.get(connection.getNode2()).intValue();
            graph[i][j] = 1;
            graph[j][i] = 1;
        }

        int start = map.get(location1).intValue(); // i = starting node
        int end = map.get(location2).intValue(); // j = destination node

        // Aici afisam matricea
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++)
            {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();

        }
        // verificam daca se poate ajunge de la nodul(locatia) start la nodul(locatia) end.
        return Problem.BFS(graph, start, end, n);
    }



    /**
     *  A method that checking if the current Problem instance is valid or not.
     *
     * @return a boolean value checking if the current Problem instance is valid or not.
     */
    public boolean isValidInstance(){

        //check if the locations list contains unique elements
        for (int i = 0; i < locations.size() - 1; i++) {
            for (int j = i + 1; j < locations.size(); j++) {
                if (locations.get(i).equals(locations.get(j)))
                    return false;
            }
        }

        //check if the roads list contains unique elements
        for (int i = 0; i < roads.size() - 1; i++) {
            for (int j = i + 1; j < roads.size(); j++) {
                if (roads.get(i).equals(roads.get(j)))
                    return false;
            }
        }

        //check that two connections don't share the same road and that we don't have duplicated connections

        for (int i = 0; i < connections.size() - 1; i++) {
            for (int j = i + 1; j < connections.size(); j++) {
                if((connections.get(i).getEdge().equals(connections.get(j).getEdge()))
                        || (connections.get(i).getNode1().equals(connections.get(j).getNode1()) && connections.get(i).getNode2().equals(connections.get(j).getNode2()))
                        || (connections.get(i).getNode1().equals(connections.get(j).getNode2()) && connections.get(i).getNode2().equals(connections.get(j).getNode1())))
                    return false;

            }
        }

        //check that for every connection the road lenght is not smaller than the euclidian distance beetwen locations
        //and that we don't have a connection from a location to the same location

        for (Connection connection : connections) {
            if(connection.getNode1().equals(connection.getNode2()))
                return false;

            double x1 = (double) connection.getNode1().getxPosition();
            double x2 = (double) connection.getNode2().getxPosition();
            double y1 = (double) connection.getNode1().getyPosition();
            double y2 = (double) connection.getNode2().getyPosition();

            double distance =  Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            if(connection.getEdge().getLength() < (int)distance)
                return false;

        }

        return  true;
    }

}
