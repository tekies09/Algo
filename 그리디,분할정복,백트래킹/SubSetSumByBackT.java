import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSetSumByBackT {

	static int N,totalCnt,S;
	static int[] input;
	static boolean[] isSelected;
	static int callCnt=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = Integer.parseInt(br.readLine());
		input = new int[N];
		isSelected = new boolean[N];
		totalCnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
	
		generateSubset(0,0);
		System.out.println("경우의수" + totalCnt);
		System.out.println("호출회수" + callCnt);
	}
	private static void generateSubset(int cnt, int sum) {
		// TODO Auto-generated method stub
		callCnt++;
		if(cnt==N) {
			if(sum==S) {
				totalCnt++;
				for(int i=0;i<N;i++) {
					if(isSelected[i]) System.out.print(input[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		if(sum+input[cnt]<=S) {
		isSelected[cnt] = true;
		generateSubset(cnt+1,sum+input[cnt]);
		}
		isSelected[cnt] = false;
		generateSubset(cnt+1,sum);
	}

}
