package BFS;

import java.util.*;
import java.io.*;


class xyobj{
	int x;
	int y;
	int p;
	public xyobj(int x,int y,int p) {
		this.x=x;
		this.y=y;
		this.p=p;
	}
}


public class 스타트택시 {

	static int n;
	static int m;
	static int l;
	static int[][] array;
	static int[] dx = new int[] {0,0,1,-1};
	static int[] dy = new int[] {1,-1,0,0};
	static LinkedList<xyobj> sl,el;
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		
		array = new int[n][n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		int fx =  Integer.parseInt(st.nextToken())-1;
		int fy =  Integer.parseInt(st.nextToken())-1;
		
		
		sl = new LinkedList<>();
		el = new LinkedList<>();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken())-1;
			int sy = Integer.parseInt(st.nextToken())-1;
			sl.add(new xyobj(sx,sy,0));
			int ex = Integer.parseInt(st.nextToken())-1;
			int ey = Integer.parseInt(st.nextToken())-1;
			el.add(new xyobj(ex,ey,0));
		}
		
		for(int i=0;i<m;i++) {
			
			
			int delindex = -1;
			int cx= 23; int cy =23;
			int minmove= Integer.MAX_VALUE-1;
			// 출발
			for(int j=0;j<sl.size();j++) {
				xyobj cur = sl.get(j);
				int curmove = bfs(fx,fy,cur.x,cur.y);
				
				if(curmove==minmove) { // 최단 거리 중복의 경우
					if(cx==cur.x) { // 행번호 중복인경우
						if(cy>=cur.y) { //열번호가 적은걸 체크
							cx=cur.x;
							cy=cur.y;
							delindex= j;
							minmove= curmove;
						}
					}
					else if(cx>cur.x) { // 행번호가 더 작은경우
						cx=cur.x;
						cy=cur.y;
						delindex= j;
						minmove= curmove;
					}

				}
				else if(curmove<minmove) { // 최단거리 인경우 
					cx=cur.x;
					cy=cur.y;
					delindex= j;
					minmove= curmove;
				}
			}
			
			if(delindex==-1 || l-minmove<0  ) { // 가장 적은 값을 찾지 못햇거나 혹은 이동중 연료가 떨어지는경우 
				l=-1;
				break;
			}
			
			// 가장 최단경로 찾으면 연료 빼주고 지워주기 , fx, fy 옮겨주기
			fx = cx; fy = cy; l = l-minmove;
			sl.remove(delindex);
			
			
			//승객태우고 도착지로
			xyobj cur = el.get(delindex);
			int curmove = bfs(fx,fy,cur.x,cur.y);
			
			//중간에 연료 끝나는경우 
			if(curmove>l) {
				l=-1;
				break;
			}
			
			fx = cur.x; fy = cur.y; l = l+curmove;
			el.remove(delindex);
			
		}
		System.out.println(l);
		
	}
	
	static int bfs(int sx,int sy,int ex, int ey) {
		int answer = Integer.MAX_VALUE;
		int[][] visited = new int[n][n];
		visited[sx][sy] = 1;
		Queue<xyobj> q = new LinkedList<>();
		q.add(new xyobj(sx,sy,0));
		while(!q.isEmpty()) {
			xyobj cur = q.poll();
			
			if(cur.x==ex && cur.y==ey) {
				answer = cur.p;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int nx =cur.x+dx[i];
				int ny =cur.y+dy[i];
				if(nx<0 || nx >=n || ny<0 || ny>=n) continue;
				if(visited[nx][ny]==1 || array[nx][ny]==1) continue;
				visited[nx][ny]=1;
				q.add(new xyobj(nx,ny,cur.p+1));

			}

		}
		
		
		
		
		return answer;
	}
	

}
