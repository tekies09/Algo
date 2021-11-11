import java.util.Arrays;

public class PermutationBybit {

	static int N=3,R=2;
	static int[] input;
	static int[] numbers;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		input = new int[] {1,4,7};
		numbers= new int[R];
		perm(0,0);
	}
	
	private static void perm(int cnt,int flag) {
		// TODO Auto-generated method stub
		if(cnt==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=0;i<N;i++) {
			if((flag&1<<i)!=0) continue;
			numbers[cnt] = input[i];
			perm(cnt+1,(flag|1<<i));
		}
	}

}
