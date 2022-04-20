package DivdeConquer;

import java.io.*;
import java.util.*;

public class 행렬제곱 {
	static int[][] array;
	static int N;
	static long B;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		array = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				array[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		
		int[][] answer = div(B);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(answer[i][j]%1000).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static int[][] div(long count){
		if(count==1) {
			return array;
		}
		int[][] canswer = new int[N][N];
		int[][] fanswer = div(count/2);
		if(count%2==1) {
			canswer = cal(fanswer,fanswer);
			canswer = cal(canswer,array);
		}
		else {
			canswer = cal(fanswer,fanswer);
		}
		return canswer;
		
	}

	public static int[][] cal(int[][] a,int[][]b){
		int[][] canswer = new int[N][N];
		
		/*
		1 2  1 2           (0,0)1*1(0,0) +(0,1)2*3(1,0)
		3 4  3 4 
		*/
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int sum = 0;
				
				for(int k=0;k<N;k++) {
					sum += a[i][k]*b[k][j];
				}
				canswer[i][j] = sum%1000;
			}
		}
		
		
		return canswer;
		
	}

}
