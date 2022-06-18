package DFS;

import java.util.*;
import java.io.*;
public class 욕심쟁이판다 {

	static int[] dx = new int[] {0,0,1,-1};
	static int[] dy = new int[] {1,-1,0,0};
	static int[][] array;
	static int[][] visited;
	static int[][] away;
	static int answer;
	static int tc;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		tc = Integer.parseInt(br.readLine());
		array = new int[tc][tc];
		visited = new int[tc][tc];
		away = new int[tc][tc];
		answer = 0;
		for(int i=0;i<tc;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<tc;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0;i<tc;i++) {
			for(int j=0;j<tc;j++) {
				if(away[i][j]==0) {
					find(i,j);
				}

			}
		}
		for(int i=0;i<tc;i++) {
			for(int j=0;j<tc;j++) {
				answer = Math.max(answer, away[i][j]);
			}
		}
		
		System.out.println(answer);
		
	}
	
	static void print() {
		for(int i=0;i<tc;i++) {
			for(int j=0;j<tc;j++) {
				System.out.print(away[i][j]+ " ");
				answer = Math.max(answer, away[i][j]);
			}
			System.out.println();
		}
		
	}
	
	
	static int find(int x,int y) {

		away[x][y] = 1; //현재 냠냠
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx >=tc || ny <0 || ny>=tc) continue;
			
			if(array[nx][ny]>array[x][y]) { // 가야될곳을 이동할수있따면
			
				if(away[nx][ny]>0) { //값이 있으면
					away[x][y] = Math.max(away[x][y],away[nx][ny]+1);
					continue;
				}
				away[x][y] = Math.max(away[x][y],find(nx,ny)+1);
			}
			
		}
		return away[x][y];
	}

}
