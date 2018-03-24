package Code_Questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MToLast {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File(args[0]));

        while (input.hasNextLine()) {
            retrieveAndPrintMToLast(input.nextLine());
        }
    }

    private static void retrieveAndPrintMToLast(String line) {
        int targetIndex = Integer.parseInt(line.replaceAll("\\D", ""));
        String sanitized = line.replaceAll("[^a-zA-Z]", "");
        int limit = sanitized.length();

        if (targetIndex <= limit) { 
            System.out.println(sanitized.charAt(limit - targetIndex));
        }
    }
}
