public class City extends Location{
    private int population;
    public City(String name, int x, int y, int population) {
        super(name, x, y);
        this.population = population;
    }
}
