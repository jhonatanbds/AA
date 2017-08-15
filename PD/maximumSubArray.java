import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=0; i<t; i++) {
		    int n = sc.nextInt();
		    int[] a = new int[n];
		    for (int j=0; j<n; j++)
		        a[j] = sc.nextInt();
            System.out.println(solution(a, new Tup(0, 0, 0), 0));
		}
	}
	
	static String solution(int[] a, Tup actualMax, int index) {
	    if (index > a.length - 1)
	        return output(a, actualMax);
	    
	    Tup tup = nextArraySum(a, index);
	    
	    if (tup.sum == actualMax.sum) {
	        if (tup.endIndex - tup.beginIndex > actualMax.endIndex - actualMax.beginIndex)
	            return solution(a, tup, tup.endIndex + 1);
	        else
	            return solution(a, actualMax, tup.endIndex + 1);
	    } else if (tup.sum > actualMax.sum) {
	        return solution(a, tup, tup.endIndex + 1);
	    } else {
	        return solution(a, actualMax, tup.endIndex + 1);
	    }
	}
	
	static Tup nextArraySum(int[] a, int index) {
	    int begin = index;
	    int sum = 0;
	    
	    while (begin < a.length && a[begin] < 0)
	        begin++;
	   
	    int end = begin;
	    while (end < a.length && a[end] >= 0)
	        sum += a[end++];
	        
	    return new Tup(sum, begin, end);
	}
	
	static String output(int[] a, Tup tup) {
	    String output = "";
	    for (int i=tup.beginIndex; i<tup.endIndex; i++) {
	        output += a[i] + " ";
	    }
	    return output;
	}
}

class Tup {
    int sum;
    int beginIndex;
    int endIndex;
    Tup(int sum, int beginIndex, int endIndex) {
        this.sum = sum;
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
    }
}