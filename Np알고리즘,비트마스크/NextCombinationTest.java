import java.util.Arrays;

public class NextCombinationTest {

	static int N=3,R=2;
	static int[] input;
	static int[] numbers;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		input = new int[] {7,1,4,2,3};
		int N = input.length;
		int R = 3 ;
		
		int[] p = new int[] {0,0,1,1,1};
		
		//뒤쪽부터 R개만큼 1채우기 
		
		int cnt=0;
		while(++cnt<=R) {
			p[N-cnt] = 1;
		}
		
		
		//1. 가장 작은 순열 만들기
		
		do {
			for(int i=0;i<N;i++) {
				if(p[i]==1)System.out.print(input[i]+" ");
			}
			System.out.println();
		}while(np(p));
		
		
	}

	//다음 큰 순열이 있으면 true 없으면 false;
	private static boolean np(int[] numbers) {
		
		int N= numbers.length;
		
		// step1. 꼭대기 i 찾기. 가장큰값찾기 큰값을 통해 교환위치 찾기 (i-1)
		int i= N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		if(i==0) { //더이상 다음순열이 존재하지 않음을 알림
			return false;
		}
		// step2. i-1위치값과  교환할 큰값 j를 찾기
		int j= N-1;
		while(numbers[i-1]>=numbers[j]) --j;
		
		// step3. i-1의 우ㅢ치값과 j위치값 교환
		swap(numbers,i-1,j);
		
		// step4. i부터 끝까지 다시 오름차순으로 바꿔야함
		int k = N-1;
		while(i<k) {
			swap(numbers,i,k);
			i++;k--;
		}
		return true;
	}
	
	private static void swap(int[] numbers,int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
