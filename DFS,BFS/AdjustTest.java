import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjustTest {

	static class Node{
		int vertex;
		Node link;
		
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}
		
	}
	
	static int nodec;
	static Node[] adjList; //인접리스트로 구현하기
	static int[][] map;
	static int[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		nodec = Integer.parseInt(br.readLine());
		int edgec = Integer.parseInt(br.readLine());
		visited = new int[nodec];
		adjList = new Node[nodec];
		map = new int[nodec][nodec];Queue<Integer> q =new LinkedList<Integer>(); 
		for(int i=0;i<edgec;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			map[s][f]=map[f][s]=1;
			adjList[f] = new Node(s,adjList[f]); // 처음 만들때 노드를 null로 연결된 노드를 집어넣고 다음에 계속 연결 할때마다 새노드를만들고 링크가 첫노드연결 // 그다음 또 연결하면 노드에 전노드 연결
			adjList[s] = new Node(s,adjList[s]);
		}
		visited[0]=1;
		dfs(0,visited);
	}

	public static void dfs(int index ,int[]visited){
		System.out.println((char)(index+65));
		for( Node temp = adjList[index];temp != null; temp = temp.link) {
			if(visited[temp.vertex]==0) {
				dfs(temp.vertex,visited);
			}
		}
	}
	public static void bfs() {
		Queue<Integer> q =new LinkedList<Integer>(); 
		q.offer(0);
		visited[0]=1;
		while(!q.isEmpty()) {
			int nodeNumber = q.poll();
			System.out.println((char)(nodeNumber+65));
			for( Node temp = adjList[nodeNumber];temp != null; temp = temp.link) {
				if(visited[temp.vertex]==0) {
					visited[temp.vertex]=1;
					q.offer(temp.vertex);
				}
			}
		}
	}
}
