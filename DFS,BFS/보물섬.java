package BFS;
import java.util.*;
import java.io.*;

class area{
	int x;
	int y;
	int p;
	
	public area(int x, int y, int p) {
		this.x=x;
		this.y=y;
		this.p=p;
	}
}


public class 보물섬  {

	static int[] dx = new int[] {1,-1,0,0};  
	static int[] dy = new int[] {0,0,1,-1};
	
	static int x;
	static int y;
	
	static char[][] array;
	static int[][] visit;
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		array = new char[x][y];
		
		for(int i=0;i<x;i++) {
			String line = br.readLine();
			for(int j=0;j<y;j++) {
				array[i][j] = line.charAt(j);
			}
		}
		
		int answer = 0;
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(array[i][j]=='L') {
					visit = new int[x][y];
					answer = Math.max(answer,bfs(i,j));
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static int bfs(int i,int j) {
		int qqqq=-1;
		Queue<area> q = new LinkedList<>();
		q.add(new area(i,j,0));
		visit[i][j] = 1;
		while(!q.isEmpty()) {
			area cur = q.poll();
			for(int a=0;a<4;a++) {
				int cx = cur.x+dx[a];
				int cy = cur.y+dy[a];
				
				if(cx<0 || cx>=x || cy<0 || cy>=y) continue;
				if(visit[cx][cy]==1 || array[cx][cy]=='W') continue;
				q.add(new area(cx,cy,cur.p+1));
				visit[cx][cy] = 1;
				qqqq=Math.max(qqqq, cur.p+1);
			}
		}
		
		return qqqq;
	}
	
	

}
