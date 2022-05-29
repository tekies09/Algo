package Greedy;

import java.io.*;
import java.util.*;
public class 크게만들기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String cur = br.readLine();
		
		
		int startindex = 0;
		int curnum = -1;
		int endindex = K+1; // 2번 
		int saveindex = -1;
		StringBuilder sb = new StringBuilder();
		loop:
		for(int i=0;i<N-K;i++) { // 개수고르기 N-K개까지
			
			for(int j=startindex;j<endindex;j++) {
				int cnum = cur.charAt(j)-'0';
				if(cnum==9) {
					curnum = cnum;
					saveindex=j;
					break;
				}
				if(cnum>curnum) {
					curnum = cnum;
					saveindex=j;
				}
			}
			sb.append(curnum);
			curnum =-1;
			startindex=saveindex+1;
			endindex++;
			
			int fullcount =  N-startindex; // 고를수있는풀
			int take = N-K - (i+1); // 총갯수중에 i개 골랏을때 그러면 남은 골를수는 TAKE
			
			if(take==fullcount) {
				for(int j=startindex;j<N;j++) {
					int cnum = cur.charAt(j)-'0';
					sb.append(cnum);
				}
				break loop;
			}
			
			
		}
		
		
		System.out.println(sb);
	}

}
