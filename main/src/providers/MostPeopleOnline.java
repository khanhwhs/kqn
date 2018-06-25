import java.util.*;

/**
 * MostPeopleOnline
 */
public class MostPeopleOnline {
    private static class Person{
        int startHour;
        int endHour;
        private Person(int s, int e){
            this.startHour = s;
            this.endHour = e;
        }

    }
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(2,6));
        people.add(new Person(1,7));
        people.add(new Person(10,23));
        people.add(new Person(5,22));
        people.add(new Person(4,6));
        people.add(new Person(7,11));
        people.add(new Person(14,24));
        people.add(new Person(13,17));
        people.add(new Person(10,16));
        people.add(new Person(8,13));
        people.add(new Person(17,18));
        people.add(new Person(15,22));
        people.add(new Person(3,6));

        int minHour = Integer.MAX_VALUE;
        int maxHour = Integer.MIN_VALUE;

        for(Person p: people){
            if(p.startHour < minHour) minHour = p.startHour;
            if(p.endHour > maxHour) maxHour = p.endHour;
        }

        int[] hoursCount = new int[25];
        int peopleCount =0;
        int maxPeople= Integer.MIN_VALUE;
        int mostPeopleHour = 0;

        for(Person p: people){
            hoursCount[p.startHour]++;
            hoursCount[p.endHour]--;
        }


        for(int i = 0; i< 24; i++){
            peopleCount += hoursCount[i];
            if(peopleCount > maxPeople ){
                maxPeople = peopleCount;
                mostPeopleHour = i;

            }

        }

        System.out.println( " At " + mostPeopleHour + " is when there's the most people online -- people online: " + maxPeople);
    
    }
}