package chapter5.five.one;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Variant2of5dot1 {
	public static void main(String[] args) {
		Integer[] A = new Integer[] {2,1,0,0,1,2,3,0,2,3,1};
		List<Integer> B = Arrays.asList(A);
		dutchPartitionVariant(B);
	}

	public static void dutchPartitionVariant(List<Integer> A) {
		int a=-1, b=-1, c=-1;
		int x=0, y=0, z=0, w=A.size();
		
		while(z<w) {
			
			if(a == -1 || A.get(z) == a) {
				a = A.get(z);
				Collections.swap(A, y, z);
				Collections.swap(A, x, y);
				y++;x++;z++;
			} else if(b == -1 || A.get(z) == b) {
				b = A.get(z);
				Collections.swap(A, y++, z++);
			} else if(c == -1 || A.get(z) == c) {
				c = A.get(z);
				z++;
			} else {
				Collections.swap(A, --w, z);
			}
			
		}
		
		for(int i =0;i<A.size();i++) {
			System.out.println(A.get(i));
		}
	}
}
