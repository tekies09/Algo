import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class lab{
	int x;
	int y;
	public lab(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class 연구소 {

	static int x,y;
	static int[][] labo;
	static int[][] clabo;
	static int[] dx = new int[]{-1 , 1 , 0 , 0};
	static int[] dy = new int[]{ 0 , 0 ,-1 , 1};
	static lab[] clab = new lab[3];
	static LinkedList<lab> vlablist = new LinkedList<lab>();
	static int maxsafe = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		labo = new int[x][y];
		clabo = new int[x][y];
		for(int i=0;i<x;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<y;j++) {
				int status = Integer.parseInt(st.nextToken());
				labo[i][j] = status;
				if(status==2) {
					vlablist.add(new lab(i,j));
				}
			}
		}
		

		comb(0);
		System.out.println(maxsafe);
	}
	
	
	public static void comb(int count) {
		if(count==3) {
			for(int i=0; i<labo.length; i++){
		            System.arraycopy(labo[i], 0, clabo[i], 0, labo[0].length);
		        }
			  bfs();

			return;
		}
		
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(labo[i][j]==0) {
					labo[i][j]=1;
					comb(count+1);
					labo[i][j]=0;
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<lab> q = new LinkedList<lab>();
		for(int i=0;i<vlablist.size();i++) {
			q.offer(vlablist.get(i));
		}
		while(!q.isEmpty()) {
			lab n = q.poll();
			int nx = n.x;
			int ny = n.y;
			
			for(int i=0;i<4;i++) {
				int newx = nx+dx[i];
				int newy = ny+dy[i];
				
				if(newx>=0 && newx<x && newy>=0 && newy<y) {
					if(clabo[newx][newy]==0) {
						clabo[newx][newy]=2;
						q.offer(new lab(newx,newy));
					}
				}
			}
		}
		int scount=0;
		 for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(clabo[i][j]==0) {
					scount++;
				}
			}
		}
		maxsafe = Math.max(maxsafe, scount);
	}
}
