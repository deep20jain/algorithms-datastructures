package contest.no96;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by deep20jain on 05-08-2018.
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int front = 0;
        int count = 0;

        for (int i = n-1; i >=0 ; i--) {
            if(i==front) {
                count++;
                break;
            }
            if(front>i) {
                break;
            }
            if(people[i]==limit || (people[i]+people[front])>limit) {
                count++;
                continue;
            }
            if((people[i] + people[front]) <=limit ) {
                front++;
                count++;
                continue;
            }
        }

        return count;
    }
}
