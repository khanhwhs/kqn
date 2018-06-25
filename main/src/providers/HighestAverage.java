import java.util.*;

/**
 * HighestAverage
 */
public class HighestAverage {

    private static class PqNode implements Comparable<PqNode>{
        String name;
        double avg;

        public PqNode( String name, double avg){
            this.name = name;
            this.avg = avg;
        }
        
        public int compareTo(PqNode n){
            return ((int)Math.round(n.avg)) - ((int)Math.round(this.avg));
        }
    } 
    public static void main(String[] args) {
        String [][] arr = {{"Bob", "70.2"},
                           {"Khanh", "80.2"}, 
                           {"Bob", "20.2"}, 
                           {"Tim", "30.2"}, 
                           {"Ken", "72.2"}};

        int i = 2;

        Double n = Double.parseDouble("70.2");

        HashMap<String,Double> hm = new HashMap<String,Double>();
        hm.put("name", 70.2);
        hm = arrToHashMap(arr);

        PriorityQueue<PqNode> pq = new PriorityQueue<>();
        for(Map.Entry<String, Double> entry: hm.entrySet()){
            pq.add(new PqNode(entry.getKey(), entry.getValue()));
        }

        PqNode res = pq.poll();
        System.out.println((int) res.avg);

        
    }  
    
    private static HashMap<String,Double> arrToHashMap(String [][] arr){
        HashMap<String,Double> hm = new HashMap<String,Double>();
        for ( String [] entry : arr){
            if(hm.containsKey(entry[0])){
                hm.put(entry[0],  avgCalc(hm.get(entry[0]), Double.parseDouble(entry[1]) )  );
            }else{
                hm.put(entry[0], Double.parseDouble(entry[1]));
            }
        }

        return hm;

    }

    private static double avgCalc(double avg, double num ){
        return (avg + num)/2;
    }
    
}