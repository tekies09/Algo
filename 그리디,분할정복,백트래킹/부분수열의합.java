package Backtracking;
import java.util.*;
import java.io.*;



public class 부분수열의합 {

	static int N;
	static int S;
	static int[] array;
	static boolean[] use;
	static int answer;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		array = new int[N];
		use = new boolean[N];
		for(int i=0;i<N;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		answer=0;
		bt(0);
		System.out.println(answer);
	}
	public static void bt(int index) {
		if(index==N) {
			//체킹된 합 더해주기 확인하기
			int sum= 0;
			int usecheck=0;
			for(int i=0;i<N;i++) {
				
				if(use[i]) {
					usecheck++;
					sum+= array[i];
				}
			}
			if(sum==S && usecheck>0) answer++;
			return;
		}
		use[index]=true;
		bt(index+1);
		use[index]=false;
		bt(index+1);
	}

}
