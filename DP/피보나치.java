package DP;


import java.util.*;
import java.io.*;
public class 피보나치 {

	static class  fibo {
		int zeroc;
		int onec;
		public fibo(int zeroc, int onec) {
			this.zeroc = zeroc;
			this.onec = onec;
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int tc = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		fibo[] array = new fibo[41];
		array[0] = new fibo(1,0);
		array[1] = new fibo(0,1);
		for(int i=2;i<=40;i++) {
			int prevonec = array[i-2].onec + array[i-1].onec;
			int prevzeroc = array[i-2].zeroc + array[i-1].zeroc;
			array[i] = new fibo(prevzeroc,prevonec);
		}
		
		
		
		for(int i=0;i<tc;i++) {
			int cur = Integer.parseInt(br.readLine());
			fibo curfibo = array[cur];
			sb.append(curfibo.zeroc).append(" ").append(curfibo.onec).append("\n");
		}
			
		System.out.println(sb);
		
	}

}
