import java.util.Arrays;
import java.io.*; 
import java.util.*;

public class solution942 {
	
	public static void main(String[] args) {
		
		String s = "DIID"; 
		String result = Arrays.toString(diStringMatch(s)); 
		System.out.println(result);
		
	}
	public static int[] diStringMatch(String S) {
		
		int N = S.length(); 
		int[] arr = new int[N+1]; 
		int start = 0, end = N ; 
		for(int i = 0; i < N; i++) {
			
			if(S.charAt(i)=='I')
				arr[i] = start++; 
			else 
				arr[i] = end--; 
			
		}
		arr[N] = start; 
		
		return arr; 
		
		
        
    }

}
