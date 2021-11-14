import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {

	static class Edge implements Comparable<Edge>{
		int start,end,weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}
	}
	static int[] parents; // 부모 원소들 관리
	private static void make() {
		parents = new int[V];
		for(int i=0;i<V;i++) {
			parents[i] = i;
		}
	}
	
	
	private static int find(int x) {
		if(parents[x]==x) {
			return x;
		}
		return parents[x]=find(parents[x]);
	}
	
	private static boolean union(int x,int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return false; //이미 대표하는 부모가같아서 유니온할필요 x
		parents[yRoot] = xRoot; // y의 부모는 자기자신을 연결했으나 x부모를 링크함으로써 x와  y의 유니온역할을함
		return true;
	}
	
	
	static int V,E;
	static Edge[] edgeList;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V= Integer.parseInt(st.nextToken());
		E= Integer.parseInt(st.nextToken());
		
		edgeList = new Edge[E]; //간선리스트를 이용한다.
		
		//간선  입력받은 순서대로 엣지 클래스를 만들어서 넣고 정렬하는 작업 //인덱스는 따로 의미한바는없지만 오름차순으로 정렬함
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			edgeList[i]= new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(edgeList);
		
		//모든 정점 에 대해 unionFind 선작업
		make();
		int cnt=0,result=0;
		//간선 하나씩 꺼내서 이제 트리를 구성해주기
		for(Edge edge: edgeList) {
			//유니온이된다면 => 연결되있지않았던 선임
			if(union(edge.start,edge.end)) {
				//간선사용하고 가중치를더해주고
				result+= edge.weight;
				//사용된 간선의 갯수를 새주어 N-1(V-1) 이 되었다면 사이클이 완성되기 직전이여서 종료를하고 최소신장트리 구성을 종료 
				if(++cnt==V-1)break;
			}
		}
		System.out.println("weight : " + result);
	}

}
