package chapter5.five.one;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Variant1of5dot1 {

	public static void main(String[] args) {
		Integer[] A = new Integer[] {2,1,0,0,1,2};
		List<Integer> B = Arrays.asList(A);
		dutchPartitionVariant(B);
	}

	public static void dutchPartitionVariant(List<Integer> A) {
		int a=-1, b=-1;
		int x=0, y=0, z=A.size();
		
		while(y<z) {
			
			if(a == -1 || A.get(y) == a) {
				a = A.get(y);
				Collections.swap(A, x++, y++);
			} else if(b == -1 || A.get(y) == b) {
				b = A.get(y);
				y++;
			} else {
				Collections.swap(A, --z, y);
			}
			
		}
		
		for(int i =0;i<A.size();i++) {
			System.out.println(A.get(i));
		}
	}
}
