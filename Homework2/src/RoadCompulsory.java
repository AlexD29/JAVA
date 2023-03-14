public class RoadCompulsory {
    enum Type{
        Highway, Express, Country
    }
    private int length,speedLimit;
    private Type type;

    public RoadCompulsory(int length, int speedLimit, Type type) {
        this.length = length;
        this.speedLimit = speedLimit;
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Road{" +
                "length=" + length +
                ", speedLimit=" + speedLimit +
                ", type=" + type +
                '}';
    }
}
