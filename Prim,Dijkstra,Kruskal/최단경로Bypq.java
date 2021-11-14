import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로Bypq {

	static class Node implements Comparable<Node>{
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		int end;
		int weight;
		@Override
		
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight) ;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub	
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());		
		int startpoint = Integer.parseInt(br.readLine())-1;
		ArrayList<Node>[] list = new ArrayList[V];
		int[] distance = new int[V];
		
		for(int i=0;i<V;i++) {
			list[i] = new ArrayList<Node>();
			distance[i] = Integer.MAX_VALUE;
		}
	
		boolean[] visited = new boolean[V];
		

		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,weight));
		}
		
		int count=0;

		distance[startpoint] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(startpoint,0));
		
		while(!pq.isEmpty()) {
			Node current = pq.poll();
			int now = current.end;
			if(visited[now]) continue;
			else {
				visited[now] = true;
				for(Node node : list[current.end]) {
					if(distance[node.end]> node.weight+distance[now] ) {
						distance[node.end] = distance[now]+node.weight;
						pq.offer(new Node(node.end,distance[node.end]));
					}
				}
			}
		}

		for(int i=0;i<V;i++) {
			if(distance[i]!=Integer.MAX_VALUE) {
				sb.append(distance[i]).append("\n");
			}
			else {
				sb.append("INF").append("\n");
			}
		}
		System.out.println(sb);
	}
}
