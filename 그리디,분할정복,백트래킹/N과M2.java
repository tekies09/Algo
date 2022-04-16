package Backtracking;
import java.util.*;
import java.io.*;

public class N과M2 {

	static int N;
	static int M;
	static int[] array;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 sb = new StringBuilder();
		 array = new int[M];
		 
		 pro(0,0);
		 System.out.println(sb);
		 
		 
		 
	}
	public static void pro(int cur,int count) {
		if(count==M) {
			for(int i=0;i<M;i++) {
				sb.append(array[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i=cur+1;i<=N;i++) {
			array[count]=i;
			pro(i,count+1);
		}
	}

}
