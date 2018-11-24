package easy.array;

/**
 * Created by deep20jain on 17-03-2018.
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.print(new PlusOne().plusOne(new int[]{6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3}));
    }

    public int[] plusOne(int[] digits) {
        int i = digits.length-1;

        while (i>=0 && digits[i]==9) {
            digits[i]=0;
            i--;
        }

        if(i>=0){
            digits[i] = digits[i]+1;
            return digits;
        }

        int[] result = new int[digits.length+1];
        result[0]=1;
        return result;
    }
}
