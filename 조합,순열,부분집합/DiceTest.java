import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {
	static int N,totalCnt;
	static int[] numbers;
	static boolean[] isSelected;
	static int[] input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		numbers = new int[N];
		
		int M= sc.nextInt();
		totalCnt = 0;
		switch (M) { 
		case 1: //중복순열
			dice1(0);
			break;
		case 2:  // 순열
			isSelected = new boolean[7];
			dice2(0);
			break;
		case 3: //중복조합
			dice3(0,1);
			break;
		case 4: //조합
			dice4(0,1);
			break;
		
		}
		System.out.println("경우의수 "+ totalCnt);
	}

	
	private static void dice1(int cnt) {
		
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		for(int i=1;i<=6;i++) {
			numbers[cnt] = i;
			dice1(cnt+1);
		}
	}
	
	private static void dice2(int cnt) {
		
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		for(int i=1;i<=6;i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			dice2(cnt+1);
			isSelected[i] = false;
		}
	}
	
	private static void dice3(int cnt,int start) {
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		
		for(int i=start;i<=6;i++) {
			numbers[cnt] = i;
			dice4(cnt+1,i);
		}
	}
	private static void dice4(int cnt,int start) {
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		
		for(int i=start;i<=6;i++) {
			numbers[cnt] = i;
			dice4(cnt+1,i+1);
		}
	}
	
}
