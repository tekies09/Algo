package knapsack;

import java.io.*;
import java.util.*;

public class 양팔저울 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = 40001;
		
		boolean[] result = new boolean[max];
		boolean[][] visited = new boolean[15001][k];
		int[] v = new int[k];
		int[] w = new int[k];
		for(int i=0;i<k;i++) {
			int cv = Integer.parseInt(st.nextToken());
			v[i] = cv;
			// result[cv] = true;
		}
		
		result[0] = true;
		
		
		for(int i=0;i<k;i++) {
			for(int j=15000;j>=0;j--) {
				int cur = Math.abs(j-v[i]);
				if(result[cur] && !visited[cur][i]) {
					result[j] = true;
					visited[j][i] = true;
				}

				if(j+v[i]<=15000) {
					cur = j+v[i];
					if(result[cur] && !visited[cur][i]) {
						result[j] = true;
						visited[j][i]=true;;
					}
				}
			}
		}
		
		
		int t = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int i=0;i<t;i++) {
			int cv = Integer.parseInt(st.nextToken());
			if(result[cv]) {
				sb.append("Y ");
			}
			else {
				sb.append("N ");
			}
		}
		System.out.println(sb);
		
	}

}
