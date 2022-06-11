package DFS;

import java.util.*;
import java.io.*;

public class 미친로봇 {
	// 동 서 남 북  -> 우 , 좌 , 하 , 상
	static int[] dx = new int[] {1,-1,0,0};  
	static int[] dy = new int[] {0,0,1,-1};
	
	static double answer;
	static int[][] visited;
	static int k;
	static double[] per;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		answer = 0;
		per = new double[4];
		visited = new int[31][31];
		for(int i=0;i<4;i++) {
			per[i] = (double) (Integer.parseInt(st.nextToken()) * 0.01);
		}
		dfs(15,15,1,0);
		
		System.out.println(answer);
	}
	public static void dfs(int x, int y, double percent, int depth) {
		if(depth==k) {
			answer += percent;
			return;
		}
		visited[x][y] = 1;
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(visited[nx][ny]==1) continue;
			double asd = percent* per[i];
			visited[nx][ny] = 1;
			dfs(nx,ny,asd,(depth+1));
			visited[nx][ny] = 0;
		}
		
	}

}
