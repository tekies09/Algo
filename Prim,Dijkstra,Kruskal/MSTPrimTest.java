import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MSTPrimTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N];
		int[] minEdge = new int[N];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		int result = 0;
		minEdge[0] = 0;
		visited[0] = true;
	
		for(int i=0;i<N;i++) {
			// 1. 신장트리의 포함되지않은 정점중 최소비용의 정점찾기
			int min = Integer.MAX_VALUE;
			int minVertex = -1; // 최소간선 정점번호
			for(int j=0;j<N;j++) {
				if(!visited[j]) {
					if(min>minEdge[j]) {
						minVertex= j;
						min = minEdge[j];
					}
				}
			}
			visited[minVertex] = true;
			result += min;
			// 2. 선택된 정점  기준으로 연 결되지않은 타 정점 과 간선비용 업데이트
			
			for(int j=0;j<N;j++) {
				if(!visited[j] && adjMatrix[minVertex][j]!=0 && minEdge[j]>adjMatrix[minVertex][j] ) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}			
		}
		
		System.out.println(result);
		
		
	}

}
