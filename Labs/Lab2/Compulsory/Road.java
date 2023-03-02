package Lab2.Compulsory;

public class Road {

    private RoadType type;
    private int speedLimit; // (km/h)
    private int length; // (km)

    //Constructors
    public Road() { // default
        this.type = RoadType.DEFAULT;
        this.speedLimit = -1;
        this.length = -1;
    }

    public Road(RoadType type, int speedLimit, int length) {
        this.type = type;
        this.speedLimit = speedLimit;
        this.length = length;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", speedLimit=" + speedLimit +
                ", length=" + length +
                '}';
    }
}
