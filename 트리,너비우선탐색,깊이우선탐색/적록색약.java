import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 적록색약 {
	static int[] dx = new int[] {-1 , 1 , 0 ,0};
	static int[] dy = new int[] { 0 , 0 ,-1 ,1};
	static char[][] carray1;
	static char[][] carray2;
	static int[][] visited1;
	static int[][] visited2;
	static int size;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		carray1 = new char[size][size];
		carray2 = new char[size][size];
		visited1 = new int[size][size];
		visited2 = new int[size][size];
		int firstcount=0;
		int secondcount=0;
		for(int i=0;i<size;i++) {
			String line = br.readLine();
			for(int j=0;j<size;j++) {
				carray1[i][j] = line.charAt(j);
				carray2[i][j] = line.charAt(j);
				if(carray2[i][j]=='G') {
					carray2[i][j] = 'R';
				}
			}		
		}
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(visited1[i][j]==0) {
					dfs(i,j,carray1[i][j]);
					firstcount++;
				}
				if(visited2[i][j]==0) {
					dfs2(i,j,carray2[i][j]);
					secondcount++;
				}
			}
		}
		System.out.println(firstcount + " " + secondcount);
		
	}
	private static void dfs(int x, int y, char c) {
		// TODO Auto-generated method stub
		visited1[x][y]=1;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx< size && ny>=0 && ny<size) {
				if(carray1[nx][ny]==c && visited1[nx][ny]==0) {
					dfs(nx,ny,c);
				}
			}
		}
	}
	private static void dfs2(int x, int y, char c) {
		// TODO Auto-generated method stub
		visited2[x][y]=1;
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx< size && ny>=0 && ny<size) {
				if(carray2[nx][ny]==c && visited2[nx][ny]==0) {
					dfs2(nx,ny,c);
				}
			}
		}
	}
}
