package Queue;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class people implements Comparable<people>{
	int p;
	int t;
	int c;
	
	@Override
	public int compareTo(people o) {
		// TODO Auto-generated method stub
		return this.c-o.c;
	}
	public people(int p, int t, int c) {
		this.p = p;
		this.t = t;
		this.c = c;
	}
	
}


public class 가희와은행 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		Queue<people> q = new LinkedList<>();
		PriorityQueue<people> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			q.add(new people(p,t,0));
		}
		int pc = Integer.parseInt(br.readLine());
		for(int i=0;i<pc;i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new people(p,t,c));
		}
		StringBuilder sb = new StringBuilder();
		int curtime = 0;
		
		int jobcount=0;
		while(curtime<W) {
			
			int t = q.peek().t;
			int p = q.peek().p;
			
			// 은행에 도착햇는지 검사
			if(!pq.isEmpty()&&pq.peek().c==curtime) {
				q.add(pq.poll());
			}
			
			if(t-jobcount==0) { //작업이다끝나숴!!
				q.poll();
				jobcount=0;
			}
			else if(jobcount==T) { // 작업이 다안끝냇는데 할당시간이 끝난경우
				q.add(new people(p,(t-jobcount),0));
				q.poll();
				jobcount=0;
			}
			sb.append(q.peek().p).append("\n");
			curtime++;
			jobcount++;
		}
		System.out.println(sb);
		
	}

}
