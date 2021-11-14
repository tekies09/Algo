import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFSGraph {

	static int nodec;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		nodec = Integer.parseInt(br.readLine());
		int edgec = Integer.parseInt(br.readLine());
		int[] visited = new int[nodec];
		map = new int[nodec][nodec];Queue<Integer> q =new LinkedList<Integer>(); 
		for(int i=0;i<edgec;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			map[s][f]=map[f][s]=1;
		}
		visited[0]=1;
		dfs(0,visited);
	}

	public static void dfs(int index ,int[]visited){
		System.out.println((char)(index+65));
		for(int i=0;i<nodec;i++) {
			if(visited[i]==0 && map[index][i]==1) {
				visited[i]=1;
				dfs(i,visited);
			}
		}
	}
}
