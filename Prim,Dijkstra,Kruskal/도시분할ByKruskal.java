import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class 도시분할ByKruskal {
static class Vertex implements Comparable<Vertex>{
		int start,end;
		long weight;

		public Vertex(int start, int end, long weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Long.compare(this.weight,o.weight);
		}
	}
	public static void make() {
		Parents = new int[V];
		for(int i=0;i<V;i++) Parents[i] = i;
	}
	public static int find(int x) {
		if(Parents[x] ==x) return x;
		return Parents[x] = find(Parents[x]);
	}
	
	public static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px==py) return false;
		Parents[py] = px;
		return true;
	}
	
	static int V;
	static int[] Parents;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Vertex[] edgeList = new Vertex[E];
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Vertex(start,end,weight);
		}
		
		make();
		Arrays.sort(edgeList);
		int sum=0;
		int cnt=0;
		long maxl = 0;
		for(Vertex edge : edgeList) {
			int ps = find(edge.start);
			int pe = find(edge.end);
			if(union(ps,pe)) {
			//기저조건
				if(maxl<=edge.weight) maxl= edge.weight;
				sum+= edge.weight;
			if(++cnt==V) {
				break;
			}
			
			}
		}
		System.out.println(sum-maxl);
	}
}
