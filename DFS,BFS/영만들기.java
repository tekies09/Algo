package baekjoon;

import java.io.IOException;
import java.util.Scanner;


public class 영만들기 {

	static int N;
	static int[] array;
	static StringBuilder sb;



	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sb =new StringBuilder();
		
		
		for(int i=0; i<tc;i++) {
			

			N = sc.nextInt();
			array = new int[N+1]; 
			
			
			dfs(1,1,1,0,"");
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int i, int prevtype,int prevsavenum,int sum , String str)  {

		if(i==N) {
			str +=i;
			sum += prevtype*prevsavenum;
			if(sum==0) {
				sb.append(str).append("\n");
			}
			return;
		}
		
		 dfs(i+1,prevtype,(prevsavenum*10+i+1),sum, str + i+" ");  // " "
		 dfs(i+1,1,i+1 ,(prevtype*prevsavenum)+sum, str+i+"+");   // +
		 dfs(i+1,-1,i+1, (prevtype*prevsavenum)+sum, str+i+"-");   // -
			
	}

}
