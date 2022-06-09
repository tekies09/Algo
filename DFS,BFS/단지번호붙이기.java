package DFS;
import java.io.*;
import java.util.*;
public class 단지번호붙이기 {

	static int[][] array;
	static int[][] visited;
	static int result;
	static int[] dx = new int[] {0,0,1,-1};
	static int[] dy = new int[] {1,-1,0,0};
	static int k;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> a = new ArrayList<>();
		k = Integer.parseInt(br.readLine());
		array = new int[k][k];
		visited = new int[k][k];
		for(int i=0;i<k;i++) {
			String line = br.readLine();
			for(int j=0;j<k;j++) {
				int qw = line.charAt(j)-'0';
				array[i][j] = qw;
			}
		}
		
		for(int i=0;i<k;i++) {
			for(int j=0;j<k;j++) {
				result = 0;
				if(visited[i][j]==1) continue;
				if(array[i][j]==0) continue;
				dfs(i,j);
				a.add(result);
			}
		}
		
		Collections.sort(a);
		System.out.println(a.size());
		for(int q : a) {
			System.out.println(q);
		}
	}
	
	public static void dfs(int x, int y) {
		
		visited[x][y] = 1;
		result++;
		
		for(int i=0;i<4;i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			
			if(cx<0 || cx>=k || cy<0 || cy>=k) continue;
			if(visited[cx][cy]==1) continue;
			if(array[cx][cy]==0) continue;
			dfs(cx,cy);
			
		}
		
	}

}
