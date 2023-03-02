package Lab2.Compulsory;

public class Location {

    private String locationName;
    private int xPosition;
    private int yPosition;
    private LocationType type;


    //Constructors
    public Location(){ // default
        this.locationName = "N/A";
        this.xPosition = -1;
        this.yPosition = -1;
        this.type = LocationType.DEFAULT;
    }

    public Location(String locationName, int xPosition, int yPosition, LocationType type) {
        this.locationName = locationName;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.type = type;
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

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", xPosition=" + xPosition +
                ", yPosition=" + yPosition +
                ", type=" + type +
                '}';
    }
}
