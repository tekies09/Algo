import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Vertex implements Comparable<Vertex>{
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
public class 최소스패닝트리 {

	public static void make() {
		parents = new int[V+1];
		for(int i=0;i<V;i++) parents[i] = i;
	}
	
	public static int find(int x) {
		if(parents[x]==x) return x;
		return parents[x] = find(parents[x]);
	}
	public static boolean union(int x , int y) {
		int px = find(x);
		int py = find(y);
		if(px==py) return false;
		
		parents[py] = px;
		return true;
	}
	static int V;
	static int[] parents;
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
		
		
		Arrays.sort(edgeList);
		make();
		int Vcount=0;
		int Sum=0;
		for(Vertex edge : edgeList) {
			
			boolean flag = union(edge.start,edge.end);
			if(flag) 		
			{
				System.out.println("start : " +edge.start + " end : " + edge.end + " weight : " +edge.weight);
				Sum+= edge.weight;
			if(++Vcount==V) break;
			}
		}
		System.out.println(Sum);
	}
}
