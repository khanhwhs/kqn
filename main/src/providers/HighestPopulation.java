import java.util.*;

/**
 * HighestPopulation
 */
public class HighestPopulation {

    private static class Person{
        int birth;
        int death;
        public Person(int birth, int death){
            this.birth = birth;
            this.death = death;
        }
    }

    private static int minBirth = Integer.MAX_VALUE;
    private static int maxDeath = Integer.MIN_VALUE;

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(2000,2010));
        people.add(new Person(1975,2005));
        people.add(new Person(1975,2003));
        people.add(new Person(1803,1809));
        people.add(new Person(1750,1869));
        people.add(new Person(1840,1935));
        people.add(new Person(1803,1921));
        people.add(new Person(1894,1921));
        getMinMaxYear(people);

        System.out.println("minBirth : "+ minBirth + " maxDeath: " + maxDeath);

        int [] deltas = new int[maxDeath - minBirth + 1];

        for(Person person : people){
            deltas[person.birth - minBirth]++;
            deltas[person.death - minBirth]--;
        }

        int maxPeopleLive = Integer.MIN_VALUE;
        int highestPopulationYear = Integer.MIN_VALUE;
        int runningSum = 0;
        int peopleAlive = 0;

        for ( int i = 0; i< deltas.length; i++){
            runningSum += deltas[i];
            System.out.println("runningSum : " + runningSum+ " at this year: " + (minBirth + i));
            if(runningSum > maxPeopleLive){
                maxPeopleLive = runningSum;
                peopleAlive = runningSum;
                highestPopulationYear = minBirth + i;
            }
        }

        System.out.println(highestPopulationYear + " --------- this many people alive: " + peopleAlive);

        //min = 1750
        //max = 2000

    }

    private static void getMinMaxYear(List<Person> people){

        for(Person p: people){
            if(p.birth < minBirth) minBirth = p.birth;
            if(p.death > maxDeath) maxDeath = p.death;
        }
        
    }
    
}

