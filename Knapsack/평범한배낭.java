import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] result = new int[K+1];
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		
		for(int i=0; i<2;i++) {
			st = new StringTokenizer(br.readLine());
			W[i+1] = Integer.parseInt(st.nextToken());
			V[i+1] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1;i<=N;i++) {
			for(int j=K;j>=W[i];j--) {
				result[j] = Math.max(result[j], V[i]+result[j-W[i]]);
			}
		}
		System.out.println(result[K]);
	}

}
