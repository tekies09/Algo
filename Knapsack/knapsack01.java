import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class knapsack01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int W[] = new int [n+1];
		int V[] = new int [n+1];
		int[][] K = new int[n+1][k+1];
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			W[i+1] = Integer.parseInt(st.nextToken());
			V[i+1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<k;i++) {
			K[0][i]= 0;
		}
		for(int i=1;i<=n;i++) {
			for(int w=0;w<=k;w++) {
				if(w<W[i]) {
					K[i][w] = K[i-1][w];
				}
				else {
					K[i][w] = Math.max(K[i-1][w], K[i-1][w-W[i]]+V[i]);
				}
			}
		}
		for(int i=0;i<=n;i++) {
			for(int w=0;w<=k;w++) {
				System.out.print(K[i][w]+" ");
			}
			System.out.println();
		}
		System.out.println(K[n][k]);
		
		
		// 공간복잡도를 줄여보기 [][]K를 [n][2]로 구성해보기
		int[][] K2 = new int[2][k+1];
		for(int i=1;i<=n;i++) {  //첫번째는 1 두번째는 0 >> n이 홀수라면 2조회 짝수라면 1조회
			int row = i%2;
			for(int w=0;w<=k;w++) {
				if(w<W[i]) {
					if(row==1) {
						K2[row][w] = K2[row-1][w];
					}
					else {
						K2[row][w] = K2[row+1][w];
					}
					
				}
				else {
					if(row==1) {
							K2[row][w] = Math.max(K2[row-1][w], K2[row-1][w-W[i]]+V[i]);
					}
					else {
						K2[row][w] =  Math.max(K2[row+1][w], K2[row+1][w-W[i]]+V[i]);
					}
				}
			}
		}
		for(int i=0;i<2;i++) {
			for(int w=0;w<=k;w++) {
				System.out.print(K2[i][w]+" ");
			}
			System.out.println();
		}
		
		if(n%2==1) {
			System.out.println(K2[1][k]);
		}
		else {
			System.out.println(K2[0][k]);
		}
		
		
	}

}
