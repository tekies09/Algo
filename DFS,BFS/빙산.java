package DFS;

import java.util.*;
import java.io.*;


class melt{
	int x;
	int y;
	int m;
	
	public melt(int x, int y, int m) {
		this.x=x;
		this.y=y;
		this.m=m;
	}
}

public class 빙산 {

	static int lx;
	static int ly;
	static int[][] array;
	static boolean[][] visited;
	static Stack<melt> s;
	static int[] dx = new int[] {0,0,1,-1};
	static int[] dy = new int[] {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		lx = Integer.parseInt(st.nextToken());
		ly = Integer.parseInt(st.nextToken());
		
		array = new int[lx][ly];
		for(int i=0;i<lx;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<ly;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		while(true) {
			
			visited = new boolean[lx][ly];
			s= new Stack<>();
			int meltc = 0;
			
			for(int i=0;i<lx;i++) {
				for(int j=0;j<ly;j++) {
					if(array[i][j]!=0 && !visited[i][j]) {
						meltc++;
						visited[i][j] = true;
						dfs(i,j);
					}
				}
			}
			
			
			//기저조건
			if(meltc>=2) {
				break;
			}
			
			if(s.isEmpty()) {
				answer= 0;
				break;
			}
			
			
			while(!s.isEmpty()) { //녹는과정
				melt cur = s.pop();
				
				array[cur.x][cur.y] = array[cur.x][cur.y]-cur.m;
				
				if(array[cur.x][cur.y]<0) array[cur.x][cur.y]=0;
			}
			//1년지낫어욤
			answer++;
		}
		
		System.out.println(answer);
	}
	
	public static boolean endcheck() {
	
		return true;	
	}
	
	public static void dfs(int x, int y) {
		
		int zerocount = 0;
		for(int i=0;i<4;i++) {
			
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>=lx || ny<0|| ny>=ly) continue;
			
			if(array[nx][ny]==0) zerocount++;
			else {
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx,ny);
				}
			}
			
		}
		
		if(zerocount!=0) {
		s.add(new melt(x,y,zerocount));
		}
	
	
	}
	

}
