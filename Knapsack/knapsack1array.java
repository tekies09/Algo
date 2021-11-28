import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class knapsack1array {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//1차원 배열로 결정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int W[] = new int [n+1];
		int V[] = new int [n+1];
		int[] K = new int[k+1];
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			W[i+1] = Integer.parseInt(st.nextToken());
			V[i+1] = Integer.parseInt(st.nextToken());
		}

		for(int i=1;i<=n;i++) {
			for(int w=k;w>=W[i];w--) {
				K[w] = Math.max(K[w], V[i]+K[w-W[i]]);
			}
		}
		
	}

}
