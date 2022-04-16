package DivdeConquer;

import java.util.*;
import java.io.*;
public class 색종이 {

	static int N;
	static int array[][];
	static int banswer;
	static int wanswer;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		banswer=0;
		wanswer=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		div(N,0,0);
		System.out.println(wanswer);
		System.out.println(banswer);
	}
	
	
	public static void div(int length, int i, int j) {
		if(length==1) {
			if(array[i][j]==0) wanswer++;
			else banswer++;
			return;
		}
		
		// 현재 사각형 검사
		int sum = 0;
		for(int a=i;a<i+length;a++) {
			for(int b=j;b<j+length;b++) {
				sum += array[a][b];
			}
		}
		if(sum==0) {
			wanswer++;
			return;
		}
		if(sum==length*length) {
			banswer++;
			return;
		}
			
		int ql = length/2;
		div(ql,i,j);	
		div(ql,i+ql,j);
		div(ql,i,j+ql);
		div(ql,i+ql,j+ql);
	};

}
