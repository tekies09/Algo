package Greedy;

import java.io.*;
import java.util.*;

class room implements Comparable<room>{
	long s;
	long e;
	
	public room(long s, long e) {
		this.s= s;
		this.e=e;
	}
	
	public int compareTo(room o) {
		
		if(this.e>o.e) {
			return 1;
		}
		else if(this.e==o.e) {
			if(this.s<o.s) {
				return 1;
			}
		}
		return -1;
	}
	
	
}

public class 회의실배정 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		PriorityQueue<room> pq = new PriorityQueue<>();
		for(int i=0;i<tc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long s = Long.parseLong(st.nextToken());
			long e = Long.parseLong(st.nextToken());
			
			pq.add(new room(s,e));
		}
		int count = 0 ;
		
		long end = 0;
	
		
		while(!pq.isEmpty()) {
			room cur = pq.poll();
			System.out.println(end + " : " + cur.s + " " + cur.e );
			
			if(end <=cur.s) {
				count++;
				end = cur.e;
			}
		}
		System.out.println(count);
		
	}

}
