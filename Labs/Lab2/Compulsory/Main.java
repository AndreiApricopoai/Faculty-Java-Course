package Lab2.Compulsory;


public class Main {
    public static void main(String[] args) {

        //creare de locatii
        Location location0 = new Location(); // default
        Location location1 = new Location("Mama Mia", 20 , 50, LocationType.RESTAURANT);
        Location location2 = new Location("Plaza", 100, 200, LocationType.HOTEL);

        //creare de drumuri
        Road road0 = new Road(); // default
        Road road1 = new Road(RoadType.LOCAL, 50, 100);
        Road road2 = new Road(RoadType.HIGHWAY, 130, 500);

        System.out.println(location0.toString());
        System.out.println(location1.toString());
        System.out.println(location2.toString() + "\n");

        System.out.println(road0.toString());
        System.out.println(road1.toString());
        System.out.println(road2.toString());

    }
}