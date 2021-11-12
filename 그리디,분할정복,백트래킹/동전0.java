package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전0 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 배수라는 조건이 있어서 큰수 기준으로 짤라서 푸는 풀이가가능
		
		int k = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int[] moneys = new int[k];
		int end=k;
		for(int i=0;i<k;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a>money) {
				end=i;
				break;
			}
			moneys[i] = a;
		}
		int[] realmoneys = new int[end];
		for(int i=0;i<end;i++) {
			realmoneys[i] = moneys[i];
		}
		

		int coinsum=0;
		for(int i=end-1;i>=0;i--) {
			int coin=0;
			coin = money / realmoneys[i];
			money = money - coin * realmoneys[i];
			coinsum+= coin;
			if(money==0) {
				break;
			}
		}
		System.out.println(coinsum);
	}

}
