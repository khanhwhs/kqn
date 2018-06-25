import java.util.*;

/**
 * Boomerangs
 */
//Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) 
//such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
public class Boomerangs {
    public static void main(String[] args) {
        int [][] points = {{1,0},{2,0},{0,0},{0,1}};
        Map<Double, Integer> map = new HashMap<>();
        int count = 0;
        // System.out.println(distance(points[0], points[1]));
        for (int[] p1 : points) {
            for (int[] p2 : points) {
                if (p1 == p2) {
                    continue;
                }
                double dis =distance(p1,p2);
                int n= map.getOrDefault(dis, 0);
                // System.out.println(n);
                map.put(dis, n + 1);
                count += n;
            }
            map.clear(); // new search
        }
        System.out.println(count);
    }
    
    private static double distance(int [] p1, int [] p2){
        double powRes= (double) Math.pow((p1[0] - p2[0]),2) + (double)Math.pow((p1[1] - p2[1]),2);
        return Math.sqrt(powRes);
    }
}