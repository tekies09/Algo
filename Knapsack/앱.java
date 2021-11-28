import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 앱 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// cost total =100 *100 
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] result = new int[10001];
		int[] W = new int[N+1];
		int[] V = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			W[i+1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N;i++) {
			V[i+1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			for(int c=10000;c>0;c--) {
				if(c<V[i]) {
				}
				else {
					result[c] = Math.max(result[c], result[c-V[i]]+W[i]); 
				}
			}
		}
		
		for(int i=0;i<=10000;i++) {
			if(result[i]>=K) {
				System.out.println(i);
				break;
			}
		}
		
	}

}
