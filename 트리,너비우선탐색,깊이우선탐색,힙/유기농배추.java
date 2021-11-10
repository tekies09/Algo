import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {
	
	static int x,y,cabc;
	static int[] dx = new int[] {-1 , 1 , 0 ,0};
	static int[] dy = new int[] { 0 , 0 ,-1 ,1};
	static int[][] carray;
	static int[][] visited;
	static int ewcount;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0;i<tc;i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		cabc =  Integer.parseInt(st.nextToken());
		ewcount=0;
		carray = new int[x][y];
		visited = new int[x][y];
		for(int c=0;c<cabc;c++) {
			st = new StringTokenizer(br.readLine());
			carray[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		for(int a=0;a<x;a++) {
			for(int b=0;b<y;b++) {
				if(carray[a][b]==1 && visited[a][b]==0) {
					dfs(a,b);
					ewcount++;
				}
			}
		}
		System.out.println(ewcount);
		}
	}
	private static void dfs(int ax,int ay) {
			visited[ax][ay]=1;
			for(int i=0;i<4;i++) {
				int nx = ax+dx[i];
				int ny = ay+dy[i];
				if(nx>=0 && nx <x && ny >=0 && ny<y) {
					if(visited[nx][ny]==0 && carray[nx][ny]==1) {
					
					dfs(nx,ny);
					}
				}
			}
	}
}
