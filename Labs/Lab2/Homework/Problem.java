package Lab2.Homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Problem {

    private ArrayList<Location> locations;
    private ArrayList<Road> roads;
    private ArrayList<Connection> connections;

    public Problem(){
        this.locations = new ArrayList<Location>();
        this.roads = new ArrayList<Road>();
        this.connections = new ArrayList<Connection>();
    }

    public Problem addLocation(Location addedLocation) throws Exception {

        for (Location location : locations) {
            if(location.equals(addedLocation))
                throw new Exception("Eroare add location"); // thow error
        }
        //add location
        locations.add(addedLocation);

        return this;
    }

    public Problem addRoad(Road addedRoad) throws Exception {

        for (Road road : roads) {
            if(road.equals(addedRoad))
                throw new Exception("Eroare add road"); // thow error
        }
        //add location
        roads.add(addedRoad);

        return this;
    }

    public Problem addConnection(Connection addedConnection) throws Exception {

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

        double x1 = (double) addedConnection.getNode1().getxPosition();
        double x2 = (double) addedConnection.getNode2().getxPosition();
        double y1 = (double) addedConnection.getNode1().getyPosition();
        double y2 = (double) addedConnection.getNode2().getyPosition();

        double distance =  Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if(addedConnection.getEdge().getLength() < (int)distance)
            throw new Exception("Eroare add connection");

        connections.add(addedConnection);


        return this;
    }

    private static boolean BFS(int[][] graph, int start, int target, int n) {
        boolean[] visited = new boolean[graph.length]; // to keep track of visited nodes
        Queue<Integer> queue = new LinkedList<>(); // to keep track of nodes to be visited
        visited[start] = true; // mark the starting node as visited
        queue.add(start); // add the starting node to the queue

        while (!queue.isEmpty()) {
            int current = queue.poll(); // remove the first node from the queue and process it
            if (current == target) { // if we have reached the target node, return true
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


    public boolean existsPathBetweenLocations(Location location1, Location location2){

        int n = locations.size();
        int[][] graph = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++)
                graph[i][j] = 0;
        }
        HashMap<Location, Integer> map = new HashMap<>();

        int k = 0;

        for (Location location : locations) {
            map.put(location,new Integer(k));
            k++;
        }

        for (Connection connection : connections) {
            int i = map.get(connection.getNode1()).intValue();
            int j = map.get(connection.getNode2()).intValue();
            graph[i][j] = 1;
            graph[j][i] = 1;
        }


        int start = map.get(location1).intValue();
        int end = map.get(location2).intValue();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++)
            {
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();

        }

        return BFS(graph, start, end, n);
    }

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
