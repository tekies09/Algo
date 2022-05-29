package Greedy;

import java.io.*;
import java.util.*;

public class 카드정렬하기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int tc = Integer.parseInt(br.readLine());
		int k[] = new int[tc];
		for(int i=0;i<tc;i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		

	
		
		int firstnum = pq.poll();
		if(pq.isEmpty()) {
			System.out.println(firstnum);
		}
		else {
			int sum = firstnum;
		while(!pq.isEmpty()) {

			int cur = pq.poll(); // 현재카드값
			sum += cur;
			if(firstnum==0) {
				firstnum = cur;
				continue;
			}
			
			if(pq.isEmpty()) {
				break;
			}
			pq.add(cur+firstnum);
			firstnum=0;
		}

		System.out.println(sum);
		}
		
	}

}
