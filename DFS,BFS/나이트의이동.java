package BFS;
import java.util.*;
import java.io.*;

class chess{
	int x;
	int y;
	int c;
	
	public chess(int x, int y, int c) {
		this.x=x;
		this.y=y;
		this.c=c;
	}
}

public class 나이트의이동 {

	static int l;
	static int sx,sy;
	static int ex,ey;
	static int[] dx = new int[] {1 ,1,2,2,-1,-1,-2,-2};
	static int[] dy = new int[] {-2,2,-1,1,-2,2,-1,1};
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<tc;i++) {
			l = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());
			
			sb.append(bfs()).append("\n");
			
			
		}
		System.out.println(sb);
		
	}
	public static int bfs() {
		int answer = 0;
		int[][] visited = new int[l][l];
		Queue<chess> q = new LinkedList<>();
		
		q.add(new chess(sx,sy,0));
		visited[sx][sy] = 1;
		while(!q.isEmpty()) {
			
			chess cur = q.poll();
			if(cur.x==ex && cur.y==ey) { // 기저조건
				answer = cur.c;
				break;
			}
			
			for(int i=0;i<8;i++) {
				int cx = cur.x+dx[i];
				int cy = cur.y+dy[i];
				
				if(cx<0 || cx>=l || cy<0 || cy>=l) continue;
				if(visited[cx][cy]==1) continue;
				visited[cx][cy] = 1;
				q.add(new chess(cx,cy,cur.c+1));
			}
			
		}
		
		return answer;
	}

}
