import java.util.ArrayList;

public class BestRoute {
    public static ArrayList<Location> locations = new ArrayList<Location>();
    public static ArrayList<Road> roads = new ArrayList<Road>();
    public static int[][] roadsMatrix = new int[100][100];

    public ArrayList<Location> getLocations(){
        return locations;
    }
    public ArrayList<Road> getRoads(){
        return roads;
    }
    public int[][] getRoadsMatrix(){
        return roadsMatrix;
    }

    /**
     * Adds a new location in the array of locations.
     * @param location is the object added in the array.
     */
    public void addLocation(Location location) {
        locations.add(location);
    }

    /**
     * Adds a new road in the array of roads.
     * @param road is the object added in the array.
     */
    public void addRoad(Road road) {
        roadsMatrix[roads.size()][roads.size()]=1;
        roads.add(road);
    }

    /**
     * The function assures that the distance is equal with the euclidian distance between the coordinates of the locations.
     * @param source is the name of the source location.
     * @param dest is the name of the destination location.
     * @return the euclidian distance between the coordinates of the locations.
     */
    public int addValidRoadLength(String source, String dest) {
        int i=0,j=0;
        for (Location location : locations) {
            if(location.getName() == source){
                break;
            }
            i++;
        }
        for (Location location : locations) {
            if(location.getName() == dest){
                break;
            }
            j++;
        }
        if(i==locations.size()) {
            System.out.println("Nu exista locatia " + source + ".");
        }
        if(j==locations.size()) {
            System.out.println("Nu exista locatia " + dest + ".");
        }
        double distance = Math.pow(locations.get(j).getX() - locations.get(i).getX(), 2) + Math.pow(locations.get(j).getY() - locations.get(i).getY(), 2);
        distance = Math.sqrt(distance);
        distance = Math.round(distance);
        roadsMatrix[i][j]++;
        roadsMatrix[j][i]++;
        return (int) distance;
    }

    /**
     * It prints the adjacency matrix of the locations.
     */
    public void printRoadsMatrix() {
        for (int k = 0; k < locations.size(); k++) {
            for (int p = 0; p < locations.size(); p++) {
                System.out.print(roadsMatrix[k][p] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * It checks if the instance has the same location or road twice.
     */
    public void checkInstance() {
        int i = 0;
        while (i < locations.size()) {
            for (int j = i + 1; j < locations.size(); j++) {
                if (locations.get(i).equals(locations.get(j))) {
                    System.out.println("Invalid instance. The problem doesn't allow adding the same location twice.");
                    return;
                }
            }
            i++;
        }
        for (int k = 0; k < locations.size(); k++) {
            for (int p = 0; p < locations.size(); p++) {
                if (roadsMatrix[k][p] > 1) {
                    System.out.println("Invalid instance. The problem doesn't allow adding the same road twice.");
                }
            }
        }
        System.out.println("Valid instance.");
    }

    /**
     * Makes a copy of a matrix.
     * @param roadsMatrix is the matrix I want to copy.
     * @return the copy of the matrix.
     */
    public int[][] copyMatrix(int[][] roadsMatrix){
        int [][] copy = new int[roadsMatrix.length][];
        for(int i = 0; i < roadsMatrix.length; i++)
            copy[i] = roadsMatrix[i].clone();
        return copy;
    }

    /**
     * It updates my adjacency matrix using Floyd-Warshall algorithm and then decides whether or not there is a road between the two locations.
     * @param source is the name of the source location.
     * @param destination is the name of the destination location.
     */
    public void possibleRoad(String source, String destination){
        int[][] copy = copyMatrix(roadsMatrix);
        int s=0,d=0;
        for (Location location : locations) {
            if(location.getName() == source){
                break;
            }
            s++;
        }
        for (Location location : locations) {
            if(location.getName() == destination){
                break;
            }
            d++;
        }
        if(s==locations.size()) {
            System.out.println("The location " + source + " doesn't exist.");
            return;
        }
        if(d==locations.size()) {
            System.out.println("The location " + destination + " doesn't exist.");
            return;
        }
        for(int k = 0; k < locations.size(); k++)
        {
            for(int i = 0; i < locations.size(); i++)
            {
                for(int j = 0; j < locations.size(); j++) {
                    roadsMatrix[i][j] = roadsMatrix[i][j] | ((roadsMatrix[i][k] != 0 && roadsMatrix[k][j] != 0) ? 1 : 0);
                }
            }
        }
        if (roadsMatrix[s][d] == 1)
            System.out.println("There exists a path from " + source + " and " + destination + ".");
        else
            System.out.println("There is no path from " + source + " and " + destination + ".");
        roadsMatrix = copyMatrix(copy);
    }

    public int addValidRoadLength(int i, int j) {
        double distance = Math.pow(locations.get(j - 1).getX() - locations.get(i - 1).getX(), 2) + Math.pow(locations.get(j - 1).getY() - locations.get(i - 1).getY(), 2);
        distance = Math.sqrt(distance);
        distance = Math.round(distance);
        roadsMatrix[i - 1][j - 1]++;
        roadsMatrix[j - 1][i - 1]++;
        return (int) distance;
    }
    public void possibleRoad(int s, int d) {
        for(int k = 0; k < locations.size(); k++)
        {
            for(int i = 0; i < locations.size(); i++)
            {
                for(int j = 0; j < locations.size(); j++) {
                    roadsMatrix[i][j] = roadsMatrix[i][j] | ((roadsMatrix[i][k] != 0 && roadsMatrix[k][j] != 0) ? 1 : 0);
                }
            }
        }
        if (roadsMatrix[s-1][d-1] == 1)
            System.out.println("Exista drum intre " + locations.get(s-1).getName() + " si " + locations.get(d-1).getName() + ".");
        else
            System.out.println("Nu exista drum intre " + locations.get(s-1).getName() + " si " + locations.get(d-1).getName() + ".");
    }
    public void allPossibleRoads(){
        //Actualizam matricea de adiacenta
        for(int k = 0; k < locations.size(); k++)
        {
            for(int i = 0; i < locations.size(); i++)
            {
                for(int j = 0; j < locations.size(); j++) {
                    roadsMatrix[i][j] = roadsMatrix[i][j] | ((roadsMatrix[i][k] != 0 && roadsMatrix[k][j] != 0) ? 1 : 0);
                }
            }
        }
        for(int i = 0; i < locations.size(); i++)
            for (int j = 0; j < locations.size(); j++)
                if (j >= i)
                    if(roadsMatrix[i][j] == 1)
                        System.out.println("Exista drum intre " + locations.get(i).getName() + " si " + locations.get(j).getName() + ".");
                    else
                        System.out.println("Nu exista drum intre " + locations.get(i).getName() + " si " + locations.get(j).getName() + ".");

    }
}
