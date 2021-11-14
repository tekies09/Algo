import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N= Integer.parseInt(br.readLine());
		
		int start = 0;
		
		int end = N-1; // 도착점 인덱스 
		
		int[][] matrix = new int[N][N];
		int[] distance = new int[N];
		
		boolean[] visited= new boolean[N];
		
		for(int i=0;i<N;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[0]= 0;
		
		for(int i=0;i<N;i++) {
			//A단계
			
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			//visited 에서 F이면서 distance중 최소값을찾기
			for(int j=0;j<N;j++) {
				if(!visited[j] && min>distance[j]) {
					minVertex = j;
					min = distance[j];
				}
			}
			visited[minVertex] = true;
			if(minVertex==end) {
				System.out.println(distance[minVertex]);
				break;
			}
			//고른 Vertex부터 도착 Vertex까지의 distance update해주기 
			for(int j=0;j<N;j++) {
				//minVertex에서 도착점 j까지의 직접거리
				if(matrix[minVertex][j]!=0) {
				int mind = min+matrix[minVertex][j];
				if(!visited[j] && mind < distance[j]) {
					distance[j] = mind;
					}
				}
			}
		}
	}

}
