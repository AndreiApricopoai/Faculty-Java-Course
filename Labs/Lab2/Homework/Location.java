package Lab2.Homework;


import java.util.Objects;

/**
 * An abstract class representing a Location
 * As members it has a location name, and the coordinates representing its position.
 *
 * @author Apricopoai Andrei
 * @version 1.0
 */
public abstract class Location {


    /**
     * The Location name.
     */
    protected String locationName;
    /**
     * The X position.
     */
    protected int xPosition;
    /**
     * The Y position.
     */
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

    /**
     * Instantiates a new Location object.
     *
     * @param locationName the location name
     * @param xPosition    the x position
     * @param yPosition    the y position
     */
    public Location(String locationName, int xPosition, int yPosition) {
        this.locationName = locationName;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }


    /**
     * Gets location name.
     *
     * @return the location name
     */
//Getters and Setters
    public String getLocationName() {
        return locationName;
    }

    /**
     * Sets location name.
     *
     * @param locationName the location name
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public int getxPosition() {
        return xPosition;
    }

    /**
     * Sets position.
     *
     * @param xPosition the x position
     */
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    /**
     * Gets position.
     *
     * @return the position
     */
    public int getyPosition() {
        return yPosition;
    }

    /**
     * Sets position.
     *
     * @param yPosition the y position
     */
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }



    /**
     * This is the implementation of the method equals() from the Object class.
     * @param o the second object that we compare the current one to.
     * @return a boolean value representing whether the two objects are equal or not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return xPosition == location.xPosition && yPosition == location.yPosition && Objects.equals(locationName, location.locationName);
    }


    /**
     * This is a hashing function.
     * @return an int representing the hash-ed value of the members.
     */
    @Override
    public int hashCode() {
        return Objects.hash(locationName, xPosition, yPosition);
    }



    /**
     * This constructs a String object representing the object info.
     * @return a String object representing the object info.
     */
    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                '}';
    }
}
