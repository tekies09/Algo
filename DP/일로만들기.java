package DP;

import java.util.*;
import java.io.*;

public class 일로만들기 {

	static int[] dp;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		dp = new int[k+1];
		
		
		
		find(k,0);
		
		System.out.println(dp[1]);
	}
	public static void find(int k, int cur) {
		// TODO Auto-generated method stub
		dp[k] = cur;
		

		
		if(k%3==0 && k/3!=0) {
			if(dp[k/3]>cur+1 || dp[k/3]==0) {
				find(k/3,cur+1);
			}
		}
		
		if(k%2==0 && k/2!=0) {
			if(dp[k/2]>cur+1 || dp[k/2]==0) {
				find(k/2,cur+1);
			}
		}
		
		if(k>1) {
			if(dp[k-1]>cur+1 || dp[k-1]==0) {
				find(k-1,cur+1);
			}
		}
		
	}

}
