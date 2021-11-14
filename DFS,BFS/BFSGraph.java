import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFSGraph {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int nodec = Integer.parseInt(br.readLine());
		int edgec = Integer.parseInt(br.readLine());
		int[] visited = new int[nodec];
		int[][] map = new int[nodec][nodec];Queue<Integer> q =new LinkedList<Integer>(); 
		for(int i=0;i<edgec;i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
		}
		
		q.offer(0);
		visited[0]=1;
		while(!q.isEmpty()) {
			int nodeNumber = q.poll();
			System.out.println((char)(nodeNumber+65));
			for(int i=0;i<nodec;i++) {
				if(map[nodeNumber][i]==1&&visited[i]==0) {
					visited[i]=1;
					q.offer(i);
				}
			}
		}
	}

}
