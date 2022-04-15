package Backtracking;

import java.io.*;
import java.util.*;

public class 스도쿠 {

	static int N;
	static int array[][];
	static int answer[][];
	static boolean visited[][];
	static int bcount;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 9;
		array= new int[9][9];
		answer = new int[9][9];
		StringTokenizer st;
		bcount = 0;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				int cur = Integer.parseInt(st.nextToken());
				array[i][j] = cur;
				if(cur==0) {
					bcount++;
				}
			}
		}
		System.out.println("bcount "+ bcount);
		start(0);
		
		for(int a=0;a<9;a++) {
			for(int b=0;b<9;b++) {
				System.out.print(answer[a][b]+" ");
			}
			System.out.println();
		}
	}
	
	public static void start(int count) {
		if(count==bcount) {
			//검증해보기
			for(int a=0;a<9;a++) {
				for(int b=0;b<9;b++) {
					answer[a][b] = array[a][b];
				}
			}
			return;
		}

		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(array[i][j]==0) {
					for(int n=1;n<10;n++) 
					{
						if(check(i,j,n)) {
						array[i][j]=n;
						start(count+1);
						}
					}
					
					array[i][j]=0;
					return;
					
				}
			}
		}
	}
	public static boolean check(int x, int y,int number) {
		
		//step vertical & horizontal check
		
		for(int i=0;i<9;i++) {
			if(array[i][y]==number || array[x][i]==number) return false;
		}
		
		int fx = (x/3)*3;
		int fy = (y/3)*3;
		
		for(int i=fx;i<fx+3;i++) {
			for(int j=fy;j<fy+3;j++) {
				if(array[i][j]==number) return false;
			}
		}
		
		return true;
	}
	

}
