package DivdeConquer;
import java.util.*;
import java.io.*;
public class 종이의개수 {
	static int array[][];
	static int aanswer;
	static int banswer;
	static int canswer;
	static int N;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		array = new int[N][N];
		aanswer=0;
		banswer=0;
		canswer=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		div(N,0,0);
		System.out.println(aanswer);
		System.out.println(banswer);
		System.out.println(canswer);
	}
	public static void div(int length, int i, int j) {
		if(length==1) {
			if(array[i][j]==0) banswer++;
			else if (array[i][j]==-1)  aanswer++;
			else canswer++;
			return;
		}
		
		// 현재 사각형 검사
		
		int acount=0;
		int bcount=0;
		int ccount=0;
		
		for(int a=i;a<i+length;a++) {
			for(int b=j;b<j+length;b++) {
				if(array[a][b]==-1)acount++;
				if(array[a][b]==0) bcount++;
				if(array[a][b]==1) ccount++;
			}
		}
		if(acount==length*length) {
			aanswer++;
			return;
		}
		if(bcount==length*length) {
			banswer++;
			return;
		}
		if(ccount==length*length) {
			canswer++;
			return;
		}
			
		int ql = length/3;
		for(int a=0;a<3;a++) {
			int nl = ql*a;
			div(ql,i,j+nl);
			div(ql,i+ql,j+nl);
			div(ql,i+ql+ql,j+nl);
		}

	};
}
