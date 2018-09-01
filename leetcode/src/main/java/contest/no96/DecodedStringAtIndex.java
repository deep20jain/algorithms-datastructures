package contest.no96;

/**
 * Created by deep20jain on 05-08-2018.
 */
public class DecodedStringAtIndex {
    public String decodeAtIndex(String s, int k) {
        int n = s.length();
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(Character.isAlphabetic(c)) {
                if(i==0) {
                    count[0] = 1;
                    continue;
                }

                count[i] = count[i-1]+1;
                continue;
            }

            int digit = Character.getNumericValue(c);
            count[i] = count[i-1] * digit;
        }

        return find(s, k, count);
    }

    private String find(String substring, int k, int[] count) {
        int nearestChar = findNearestChar(substring);
        int countNearest = count[nearestChar];
        int mod = k<=countNearest ? k : (k % countNearest)==0?countNearest:(k%countNearest);

        for (int i = 0; i < substring.length(); i++) {
            if(count[i]==mod && Character.isAlphabetic(substring.charAt(i))) {
                return substring.charAt(i)+"";
            }
        }

        int nearest = 0;
        for (int i = 0; i < substring.length(); i++) {
            if(mod <= count[i]){
                nearest=i;
                break;
            }
        }

        return find(substring.substring(0, nearest+1), mod, count);
    }

    private int findNearestChar(String substring) {
        for (int i = substring.length()-1; i >=0 ; i--) {
            if(Character.isAlphabetic(substring.charAt(i)))
                return i;
        }

        return 0;
    }
}
