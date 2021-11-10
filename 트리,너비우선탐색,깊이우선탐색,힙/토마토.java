import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato{
	int x;
	int y;
	public tomato(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class 토마토 {

	
	static int[][] day;
	static int x,y;
	static int[] dx = new int[] {-1 , 1 , 0 ,0};
	static int[] dy = new int[] { 0 , 0 ,-1 ,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		Queue<tomato> q = new LinkedList<tomato>();
		day = new int[x][y];
		for(int i=0;i<x;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<y;j++) {
				int status = Integer.parseInt(st.nextToken());
				day[i][j] = status;
				if(status==1) {
					q.offer(new tomato(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			tomato n = q.poll();
			int nx = n.x;
			int ny = n.y;
				for(int i=0;i<4;i++) { //상하좌우 영향주기
			
				int newx = nx + dx[i];
				int newy = ny + dy[i];
				if(newx>=0 && newx<x && newy>=0 && newy<y) { //범위안에서
					if(day[newx][newy]==0) // 토마토의 영향을 받을수있는것
					{
						q.offer(new tomato(newx,newy));
						//영향을 받았으면 하루가 지난거임 그래서 영향을 받기전 day 어레이에서 가져와서 하루를 추가해줌
						day[newx][newy]= day[nx][ny]+1;
					}
				}
				}
			}

		System.out.println(endcheck());
	}
	
	public static int endcheck() {
		int maxday = 0;
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(day[i][j]==0) {
					return -1;
				}
				maxday = Math.max(maxday, day[i][j]);
			}
		}
		return maxday-1;
	}
	

}
