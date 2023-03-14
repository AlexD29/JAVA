import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionBestRoute {
    private BestRoute bestRoute1;
    public static ArrayList<Location> locations;
    public static ArrayList<Road> roads;
    public static int[][] roadsMatrix;
    public SolutionBestRoute(BestRoute bestRoute1) {
        this.bestRoute1 = bestRoute1;
        locations=bestRoute1.getLocations();
        roads=bestRoute1.getRoads();
        roadsMatrix = bestRoute1.getRoadsMatrix();
        System.out.println();
    }

    /**
     * It takes all the paths between the two locations and then chooses the shortest one and displays it on the screen.
     * @param source is the name of the source location.
     * @param destination is the name of the destination location.
     */
    public void generateBestRoute(String source, String destination){
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

        double minDistance = 100_000_000; int k=0,j=0;
        ArrayList<ArrayList<Integer>> allPaths = findAllPaths(roadsMatrix,s,d);
        for (ArrayList<Integer> path : allPaths) {
            double distance = 0; j++;
            for (int i = 0; i < path.size(); i++) {
                if(i+1 != path.size()){
                    double distanceAux = Math.pow(locations.get(path.get(i+1)).getX() - locations.get(path.get(i)).getX(), 2) + Math.pow(locations.get(path.get(i+1)).getY() - locations.get(path.get(i)).getY(), 2);
                    distanceAux = Math.sqrt(distanceAux);
                    distanceAux = Math.round(distanceAux);
                    distance += distanceAux;
                }
            }
            if(distance < minDistance){
                minDistance = distance;
                k = j;
            }
        }

        if(k==0){
            System.out.println("There is no path from " + source + " to " + destination + ".");
        }
        else if(allPaths.get(k-1).size() == 2){
            System.out.println("The shortest path from " + source + " to " + destination + " is a direct path and is " + (int)minDistance + " kilometers long.");
        }
        else{
            System.out.print("The shortest path from " + source + " to " + destination + " passes through ");
            for (int i = 1; i < allPaths.get(k-1).size()-1; i++){
                System.out.print(locations.get(allPaths.get(k-1).get(i)).getName() + " and ");
            }
            System.out.println("is " + (int)minDistance + " kilometers long.");
        }
    }

    /**
     * Finds all paths in the graph using DFS algorithm.
     * @param roadsMatrix is the adjacency matrix of the locations.
     * @param source is the index of the source location.
     * @param destination is the index of the destination location.
     * @return an array of an array representing all the paths between the two locations.
     */
    public static ArrayList<ArrayList<Integer>> findAllPaths(int[][] roadsMatrix, int source, int destination) {
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        boolean[] visited = new boolean[roadsMatrix.length];
        ArrayList<Integer> currentPath = new ArrayList<>();
        currentPath.add(source);
        dfs(roadsMatrix, source, destination, visited, currentPath, allPaths);
        return allPaths;
    }

    /**
     * Function to perform DFS algorithm to find all paths.
     * @param roadsMatrix is the adjacency matrix of the locations.
     * @param currentNode is the current node that I'm verifying.
     * @param destination is the index of the destination location.
     * @param visited is an array that remembers all the nodes I have already visited.
     * @param currentPath is the path which I'm currently analyzing.
     * @param allPaths is the array of paths in which I'll add the new found paths.
     */
    private static void dfs(int[][] roadsMatrix, int currentNode, int destination, boolean[] visited, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> allPaths) {
        visited[currentNode] = true;
        if (currentNode == destination) {
            allPaths.add(new ArrayList<>(currentPath));
        } else {
            for (int i = 0; i < roadsMatrix.length; i++) {
                if (roadsMatrix[currentNode][i] == 1 && !visited[i]) {
                    currentPath.add(i);
                    dfs(roadsMatrix, i, destination, visited, currentPath, allPaths);
                    currentPath.remove(currentPath.size() - 1);
                }
            }
        }
        visited[currentNode] = false;
    }
}


