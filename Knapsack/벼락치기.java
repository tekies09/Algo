import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 벼락치기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// total time =10000
		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken());
		int[] result = new int[K+1];
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			W[i+1] = Integer.parseInt(st.nextToken());
			V[i+1] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1;i<=N;i++) {
			for(int w=K;w>=0;w--) {
				if(w>=W[i]) {
					result[w] = Math.max(result[w], result[w-W[i]]+V[i]);
				}
			}
		}
		
		for(int i=0;i<=K;i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println(result[K]);
	}
}
