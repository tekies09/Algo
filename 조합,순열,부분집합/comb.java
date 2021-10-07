import java.util.Arrays;

public class comb {
	static int N=3,R=2;
	static int[] numbers;
	static int[] input;
	static boolean[] iss;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new int[] {1,4,7};
		numbers=new int[R] ;
		iss = new boolean[N+1];
		comb(0,0);
	}

	private static void comb(int count,int start) {
		if(count==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		
		for(int i=start;i<N;i++) {
			numbers[count] = input[i];

			comb(count+1,i+1);
		}
		
	}
}
