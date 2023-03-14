public class Compulsory {
    public static void main(String args[]){
        LocationCompulsory City1 = new LocationCompulsory("Galati", LocationCompulsory.Type.City,20,30);
        LocationCompulsory City2 = new LocationCompulsory("Bucuresti", LocationCompulsory.Type.City,50,60);
        LocationCompulsory Village1 = new LocationCompulsory("Mircesti", LocationCompulsory.Type.Village,55,65);
        LocationCompulsory Airport1 = new LocationCompulsory("AirportIasi", LocationCompulsory.Type.Airport,51,61);
        RoadCompulsory Road1 = new RoadCompulsory(200,80, RoadCompulsory.Type.Country);
        RoadCompulsory Road2 = new RoadCompulsory(100,100, RoadCompulsory.Type.Highway);
        System.out.println(City1.toString());
        System.out.println(City2.toString());
        System.out.println(Village1.toString());
        System.out.println(Airport1.toString());
        System.out.println(Road1.toString());
        System.out.println(Road2.toString());
    }
}
