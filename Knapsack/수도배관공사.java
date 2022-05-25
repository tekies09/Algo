package knapsack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 수도배관공사 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int[] result = new int[D+1];
		int[] L = new int[P];
		int[] C = new int[P];
		for(int i=0;i<P;i++) {
			st = new StringTokenizer(br.readLine());
			L[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			
		}
		
		//수도관의 용량은 파이프들의 용량중 최소 ()
		
		//길이는 파이프들의 총합 (D)
		result[0] = Integer.MAX_VALUE;
		for(int i=0;i<P;i++) {
			for(int j=D;j>=L[i];j--) {
				int cur = Math.min(result[j-L[i]],C[i]);
				result[j] = Math.max(result[j],cur) ;

			}

			
		}

		
		System.out.println(result[D]);
		
		
	}

}
