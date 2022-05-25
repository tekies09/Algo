package knapsack;

import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 안녕 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[] L = new int[t];
		int[] J = new int[t];
		int[] result = new int[101];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<t;i++) {
			
			L[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<t;i++) {
			J[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<t;i++) {
			for(int j=100;j>L[i];j--) {
				result[j] = Math.max(result[j], result[j-L[i]]+J[i]);
			}
		}
		System.out.println(result[100]);
		
	}

}
