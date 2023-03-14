public class Airport extends Location{
    private int numberOfTerminals;
    public Airport(String name, int x, int y, int numberOfTerminals) {
        super(name, x, y);
        this.numberOfTerminals = numberOfTerminals;
    }
}
