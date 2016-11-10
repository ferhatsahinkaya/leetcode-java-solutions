public class Solution {
    class Person {
        int height;
        int k;
        Person(int height, int k) {
            this.height = height;
            this.k = k;
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        int length = people.length;
        if(length <= 1) return people;
        
        Person[] peopleArray = new Person[length];
        for(int i=0; i<length; i++) {
            peopleArray[i] = new Person(people[i][0], people[i][1]);
        }
        
        Arrays.sort(peopleArray, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return Integer.signum(p1.k - p2.k);
            }
        });
        
        int index = 0;
        while(index < length) {
            int tallerPeopleCount = 0;
            for(int j=0; j<index; j++) {
                if(peopleArray[j].height >= peopleArray[index].height) {
                    tallerPeopleCount++;
                }
            }
            Person current = new Person(peopleArray[index].height, peopleArray[index].k);
            boolean actionTaken = false;
            int j = index-1;
            for(; (j>=0) && (tallerPeopleCount != current.k); j--) {
                if(peopleArray[j].height >= current.height) {
                    tallerPeopleCount--;
                }
                swap(peopleArray, j, j+1);
                actionTaken = true;
            }
            if(!actionTaken) index++;
        }

        int[][] result = new int[length][2];
        for(int i=0; i<length; i++) {
            result[i][0] = peopleArray[i].height;
            result[i][1] = peopleArray[i].k;
        }
        return result;
    }
    private void swap(Person[] people, int i, int j) {
        if(i != j) {
            Person tmp = people[i];
            people[i] = people[j];
            people[j] = tmp;
        }
    }
}