package DivdeConquer;

import java.util.*;
import java.io.*;
public class 색종이3 {

	static int array[][];
	static int N;
	static int answer;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N= Integer.parseInt(br.readLine());
		answer =-1;
		array = new int[100][100];
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int a=x;a<x+10;a++)
				for(int b=y;b<y+10;b++) {
					array[a][b] = 1;
				}
		}
		

		acc();
		sum();
		System.out.println(answer);
		
	}
	public static void print() {
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				System.out.print(array[i][j]+ " ");
			}
			System.out.println();
		}
	}
	public static void acc() {
		for(int i=0;i<99;i++) {
			for(int j=0;j<100;j++) {
				if(array[i][j]!=0 && array[i+1][j]!=0) {
					array[i+1][j] = array[i][j] +1;
				}
			}
		}
	}
	
	public static void sum() {
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				int h = 100;
				
				for(int k=j;k<100;k++) {
					h= Math.min(array[i][k], h);
					if(h==0) break;
					answer = Math.max(answer, h*(k-j+1));
					
				}
			}
		}
	}
	
}
