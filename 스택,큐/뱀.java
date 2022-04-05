package Queue;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class 뱀 {

	static class snake{
		int x;
		int y;
		public snake(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static class command {
		int x;
		int type;
		public command(int x, int type) {
			this.x = x;
			this.type = type;
		}

	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		boolean[][] apple = new boolean[N+1][N+1];
		boolean[][] snake = new boolean[N+1][N+1];
		
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			apple[X][Y] =true;
		}
		int L = Integer.parseInt(br.readLine());
		
		Queue<snake> sq = new LinkedList<>();
		
		Queue<command> cq= new LinkedList<>(); 
		
		for(int i=0;i<L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			String k = st.nextToken();
			int T=-1;
			if(k.equals("D")) T=1;
			cq.add(new command(X,T));
		}
		
		sq.add(new snake(1,1));
		snake[1][1] = true;
		int nowd = 1;
		int nowx=1;
		int nowy=1;
		int time = 0;
		int dx[] = new int[] {-1,0,1,0 };
		int dy[] = new int[] {0,1,0,-1};
		while(true) {
			time++; //

			int newx = nowx + dx[nowd];
			int newy = nowy + dy[nowd];
			
			//벽에 부딪힘체크
			if(newx==0 || newy ==0 || newx == N+1 || newy ==N+1) break;
			//자기 몸에 부딪혔을까요 ?
			if(snake[newx][newy]) break;
			//사과 못먹기
			if(!apple[newx][newy]) {
				snake tail = sq.poll();
				snake[tail.x][tail.y] =false;
			}
			else {
				apple[newx][newy] = false;
			}
			snake[newx][newy] = true;
			sq.add(new snake(newx,newy));
			if(!cq.isEmpty()&&cq.peek().x==time) nowd += cq.poll().type;
			if(nowd<0) nowd+=4;
			if(nowd>3) nowd%=4;
			nowx = newx;
			nowy = newy;
		}
		
		System.out.println(time);
	}

}
