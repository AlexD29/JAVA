public class Main {
    public static void main(String[] args) {
        BestRoute bestRoute1 = new BestRoute();
        bestRoute1.addLocation(new City("Galati",10,20,300_000));
        bestRoute1.addLocation(new City("Iasi",50,60,350_000));
        bestRoute1.addLocation(new City("Bucuresti",64,32,2_000_000));
        bestRoute1.addLocation(new City("Timisoara",170,190,330_000));
        bestRoute1.addLocation(new Airport("Henri Coanda",75,85,10));
        bestRoute1.addLocation(new GasStation("Rompetrom Bucuresti",60,25,10));
        bestRoute1.addLocation(new City("Brasov",80,90,300_000));
        bestRoute1.addLocation(new City("Cluj",120,130,350_000));
        bestRoute1.addLocation(new City("Craiova",34,78,320_000));
        bestRoute1.addLocation(new City("Constanta",25,34,310_000));
        bestRoute1.addLocation(new City("Braila",15,25,200_000));
        bestRoute1.addLocation(new City("Budapesta",300,250,3_000_000));

        bestRoute1.addRoad(new Highway(bestRoute1.addValidRoadLength("Galati","Iasi"),100));
        bestRoute1.addRoad(new Highway(bestRoute1.addValidRoadLength("Galati","Bucuresti"),100));
        bestRoute1.addRoad(new Express(bestRoute1.addValidRoadLength("Galati","Braila"),80));
        bestRoute1.addRoad(new Highway(bestRoute1.addValidRoadLength("Iasi","Cluj"),100));
        bestRoute1.addRoad(new Highway(bestRoute1.addValidRoadLength("Iasi","Constanta"),100));
        bestRoute1.addRoad(new Express(bestRoute1.addValidRoadLength("Bucuresti","Henri Coanda"),70));
        bestRoute1.addRoad(new Express(bestRoute1.addValidRoadLength("Bucuresti","Rompetrom Bucuresti"),70));
        bestRoute1.addRoad(new Country(bestRoute1.addValidRoadLength("Bucuresti","Brasov"),60));
        bestRoute1.addRoad(new Highway(bestRoute1.addValidRoadLength("Bucuresti","Craiova"),100));
        bestRoute1.addRoad(new Highway(bestRoute1.addValidRoadLength("Bucuresti","Constanta"),100));
        bestRoute1.addRoad(new Highway(bestRoute1.addValidRoadLength("Bucuresti","Braila"),100));
        bestRoute1.addRoad(new Highway(bestRoute1.addValidRoadLength("Timisoara","Craiova"),100));
        bestRoute1.addRoad(new Express(bestRoute1.addValidRoadLength("Brasov","Craiova"),70));
        bestRoute1.addRoad(new Express(bestRoute1.addValidRoadLength("Brasov","Constanta"),70));

        bestRoute1.checkInstance();
        bestRoute1.possibleRoad("Cluj","Budapesta");
        bestRoute1.possibleRoad("Mioveni","Cluj");
        bestRoute1.possibleRoad("Galati","Timisoara");

        SolutionBestRoute solutionBestRoute = new SolutionBestRoute(bestRoute1);
        solutionBestRoute.generateBestRoute("Cluj","Craiova");
        solutionBestRoute.generateBestRoute("Braila","Timisoara");
        solutionBestRoute.generateBestRoute("Galati","Bucuresti");
        solutionBestRoute.generateBestRoute("Galati","Budapesta");
        solutionBestRoute.generateBestRoute("Brasov","Timisoara");
        solutionBestRoute.generateBestRoute("Henri Coanda","Timisoara");
        solutionBestRoute.generateBestRoute("Brasov","Craiova");
    }
}
