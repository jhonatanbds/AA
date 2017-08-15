import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++){
		    int m = sc.nextInt();
		    int n = sc.nextInt();
		    int[][] a = new int[m][n];
		    
		    for(int j=0; j<n; j++)
		        a[0][j] = 1;
		    
		     for(int j=0; j<m; j++)
		        a[j][0] = 1;
		    
		    for(int j=1; j<m; j++){
		        for(int k=1; k<n; k++)
		            a[j][k] = (a[j][k-1]+a[j-1][k]) % ((int)Math.pow(10,9)+7);
		    }
		    System.out.println(a[m-1][n-1]);
		}
	}
}