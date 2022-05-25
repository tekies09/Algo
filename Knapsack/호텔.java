package knapsack;
import java.io.*;
import java.util.*;
public class 호텔 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] w = new int[n];
		int[] v = new int[n];
		
		int[] result = new int[c+101];
		for(int i=0;i<c+101;i++) {
			result[i] = Integer.MAX_VALUE;
		}

		
		for(int i=0;i<n;i++) {
			st= new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken()); //들인돈
			v[i] = Integer.parseInt(st.nextToken()); //사람인원수
			
			int count = (c+100)/v[i];
			for(int j=1;j<=count;j++) {
				int cur = v[i] * j; // 현재 인원수 
				if(result[cur]>w[i]*j) { 
					result[cur] = w[i]*j;
				}		}
			
		}
		//들인돈의 최소값을 구해야되고
		
		//홍보인원은 정해져있음

		
		
	
		
		//result[3명] = 최소금액 3원 이런식으로.. 
		
		for(int i=0;i<n;i++) {
			for(int j=v[i];j<c+101;j++) {
				if(result[j]>result[j-v[i]]+w[i] && result[j-v[i]] != Integer.MAX_VALUE) {
					result[j] = result[j-v[i]]+w[i];
				}
			}

		}
		
		int min = Integer.MAX_VALUE;
		for(int i=c;i<c+101;i++) {
			if(result[i]!=Integer.MAX_VALUE) {
				min = Math.min(min,result[i]);
			}
		}
		System.out.println(min);
	
	}

}
