
// Java Program to illustrate reading from FileReader
// using BufferedReader
import java.io.*;
/**
 * DupLines
 */

 // hashMap O(n) and O(n)
 //Devide line into chunks and hashmap it
public class DupLines {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/khanhnguyen/Documents/workspace/kqn/main/src/providers/file.text");
 
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        String st;
        while ((st = br.readLine()) != null)
            System.out.println(st);

    } 
    
}