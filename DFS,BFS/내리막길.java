package DFS;

import java.util.*;
import java.io.*;
public class 내리막길 {

	public static int[] dx = new int[] {1,0,0,-1};
	public static int[] dy = new int[] {0,1,-1,0};
	public static int[][] array;
	public static int[][] dp;
	public static int answer;
	public static int ex;
	public static int ey;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		array = new int[n][m];
		dp = new int[n][m];
		answer =0;
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		ex = n-1;
		ey = m-1;
		answer = dfs(0,0);
		System.out.println(answer);
	}
	
	public static int dfs(int x , int y) {
		if(x==ex && y==ey) {
			
			return 1 ;
		}
		int curd = array[x][y];
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		dp[x][y] = 0;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx >ex || ny<0 || ny>ey) continue;
			int nexd = array[nx][ny];
			if(curd >nexd) {
				dp[x][y] += dfs(nx,ny);
			}
		}
		return dp[x][y];
	}
}
