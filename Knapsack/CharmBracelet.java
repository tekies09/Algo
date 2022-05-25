package knapsack;

import java.io.*;
import java.util.*;

public class CharmBracelet {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] w = new int[N];
		int[] d = new int[N];
		int[] result = new int[M+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			for(int j= M;j>=w[i];j--) {
				result[j] = Math.max(result[j], result[j-w[i]]+d[i]);
			}
		}
		
		System.out.println(result[M]);

	}

}
