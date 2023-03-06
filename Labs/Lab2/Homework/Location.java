package Lab2.Homework;


import java.util.Objects;

/** An abstract class representing a Location
 *  As members it has a location name, and the coordinates representing its position.
 *  @author Apricopoai Andrei
 *  @version 1.0
 */
public abstract class Location {


    protected String locationName;
    protected int xPosition;
    protected int yPosition;


    /**
     * It constructs a default Location object having the name : "N/A" and the coordinates (-1,-1).
     */
    //Constructors
    public Location(){ // default
        this.locationName = "N/A";
        this.xPosition = -1;
        this.yPosition = -1;
    }

    public Location(String locationName, int xPosition, int yPosition) {
        this.locationName = locationName;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }



    //Getters and Setters
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getxPosition() {
        return xPosition;
    }

    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return xPosition == location.xPosition && yPosition == location.yPosition && Objects.equals(locationName, location.locationName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationName, xPosition, yPosition);
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                '}';
    }
}
