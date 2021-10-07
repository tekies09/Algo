import java.util.Arrays;

public class permutation {

	static int N=3,R=3;
	static int[] numbers;
	static boolean[] iss;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		numbers=new int[R] ;
		iss = new boolean[N+1];
		perm(0);
	}

	private static void perm(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(iss[i]) continue;
			numbers[cnt] = i;
			iss[i]=true;
			
			perm(cnt+1);
			iss[i]=false;
		}
		
	}
}
