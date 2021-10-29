import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 뱀 {
	static class snake{
		int x;
		int y;
		public snake(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st;
		  int[] dx = { 0, 1,  0, -1 }; //우 하 좌 상   
		  int[] dy = { 1, 0, -1,  0 };
		  int size = Integer.parseInt(br.readLine());
		  int apple = Integer.parseInt(br.readLine());
		  int[][] array = new int[size][size];
		  
		  for(int i=0;i<apple;i++) {
			  st = new StringTokenizer(br.readLine());
			  int x= Integer.parseInt(st.nextToken());
			  int y= Integer.parseInt(st.nextToken());
			  array[x-1][y-1] = 1;
		  }
		  
		  int command = Integer.parseInt(br.readLine());
				  
		  Queue<snake> queue = new LinkedList<snake>();
		  queue.offer(new snake(0,0));
		  int dir = 0;
		  int nowx = 0;
		  int nowy = 0;
		  int timecount = 0;
		  boolean flag = false;
		  
		  Queue<int[]> cqueue = new LinkedList<int[]>();
		  
		  
		  for(int i=0;i<command;i++) {
			  st = new StringTokenizer(br.readLine());
			  int x= Integer.parseInt(st.nextToken());
			  String k = st.nextToken();
			  
			  if(k.equals("D")) {
				  dir++;
				  if(dir==4) dir = 0;
			  }
			  else if(k.equals("L")) {
				  dir--;
				  if(dir==-1) dir = 3;
			  }
			  int[] c = new int[] {dir,x};
			  cqueue.offer(c); 
		  }
		  dir = 0;
		  while(true) {
			  
			  timecount++;
			  nowx += dx[dir];
			  nowy += dy[dir];
			  if(nowx>=size || nowy >= size || nowx<0 || nowy<0) {
				  break;
			  }
			  Iterator iter = queue.iterator();
			  while(iter.hasNext()) {
				  snake s = (snake) iter.next();
				  if(s.x==nowx && s.y == nowy) {
					  flag= true;
				  }
			  }
			  if(flag) {
				  break;
			  }
			  if(array[nowx][nowy]!=1) {
				  queue.poll(); //사과가없다면 꼬리자르기
			  }
			  else {
				  array[nowx][nowy] = 0;
			  }
			  queue.offer(new snake(nowx,nowy)); // 한칸전진
			  
			  
			  if(!cqueue.isEmpty()) { // 무브가 끝나고 방향전환기능
				  if(cqueue.peek()[1]==timecount) {
					  dir = cqueue.poll()[0];
				  }
			  }
		  }

		  System.out.println(timecount);
	}

}
