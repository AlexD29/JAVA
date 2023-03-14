public class GasStation extends Location{
    private int gasPrice;

    public GasStation(String name, int x, int y, int gasPrice) {
        super(name, x, y);
        this.gasPrice = gasPrice;
    }
}
