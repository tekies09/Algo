package Backtracking;
import java.util.*;
import java.io.*;

public class 감시피하기 {

	static int N;
	static int[][] array; 
	static boolean[][] visited;
	static int[] sx; 
	static int[] sy;
	static boolean flag;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int sindex= 0;
		visited = new boolean[N][N];
		array = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				String cur = st.nextToken();
				int type = 3;
				if(cur.equals("X")) type =3; //방어막 가능 공간
				else if(cur.equals("S")) {
					type = 0; //학생
					sindex++;
					visited[i][j] = true;
				}
				else {
					type = 1; //선생
					visited[i][j] = true;
				}
				array[i][j] = type;
			}
		}
		sx = new int[sindex];
		sy = new int[sindex];
		sindex=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(array[i][j]==0) {
					sx[sindex] = i;
					sy[sindex] = j;
					sindex++;
				}
			}
		}
		
		
		flag =false;
		start(0);
		if(flag) System.out.println("YES");
		else System.out.println("NO");

	}
	
	public static void start(int c) {
		if(c==3) {

			
			
			
			for(int i=0;i<sx.length;i++) {
				int curx = sx[i];
				int cury = sy[i];
				
				//상 검색
				
				for(int j=curx+1;j<N;j++) {
					if(array[j][cury]==2) break;
					if(array[j][cury]==1) {
						return;
					}
				}
				
				//하 검색
				
				for(int j=curx-1;j>=0;j--) {
					if(array[j][cury]==2) break;
					if(array[j][cury]==1) {
						return;
					}
				}
				
				//우 검색
				
				for(int j=cury+1;j<N;j++) {
					if(array[curx][j]==2) break;
					if(array[curx][j]==1) {
						return;
					}
				}
				// 좌 검색
				for(int j=cury-1;j>=0;j--) {
					if(array[curx][j]==2) break;
					if(array[curx][j]==1) {
						return;
					}
				}
			}
			flag= true;
			return ;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(array[i][j]==3) {
					array[i][j]=2;
					start(c+1);
					array[i][j]=3;
				}
			}
		}


		
		
		
	}

}
