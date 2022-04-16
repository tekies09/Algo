package DivdeConquer;

import java.io.*;
import java.util.*;
public class 쿼드트리 {

	static int[][] array;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<N;j++) {
				array[i][j] = line.charAt(j)-'0';
			}
		}
		sb= new StringBuilder();
		
		cd(0,0,N);
		
		System.out.println(sb);
	}

	public static void cd(int x,int y, int length) {
		if(length==1) {
			sb.append(array[x][y]);
			return ;
		}
		
		int sum = 0;
		for(int i=x;i<x+length;i++) {
			for(int j=y;j<y+length;j++) {
				sum += array[i][j];
			}
		}
		if(sum==0) {
			sb.append("0");
			return;
		}
		if(sum==length*length) {
			sb.append("1");
			return;
		}
		
		int ql = length/2;
		sb.append("(");
		for(int i=0;i<2;i++) {
			cd(x+(i*ql),y,ql);
			cd(x+(i*ql),y+ql,ql);
		}
		sb.append(")");
	}
}
