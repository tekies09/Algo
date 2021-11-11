import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 도영이가만든음식 {

	static int[] sin,ssn;
	static int[] visited;
	static int k;
	static int diff=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		sin = new int[k];
		ssn = new int[k];
		visited = new int[k];
		StringTokenizer st;
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			sin[i] = Integer.parseInt(st.nextToken());
			ssn[i] = Integer.parseInt(st.nextToken());
		}
		//cal(0,0);
		cal1(0,0,0);
		System.out.println(diff);
	}
	
	private static void cal1(int count,int start,int flag) {
		// TODO Auto-generated method stub
		if(count==k) {
			int sinmul=1;
			int ssnsum=0;
			for(int i=0;i<k;i++) {
				if((flag&1<<i)!=0){
					sinmul *= sin[i];
					ssnsum += ssn[i];
				}
			}
			if(ssnsum==0)
				return;
			diff = Math.min(diff, Math.abs((sinmul-ssnsum)));

			return;
		}
		
		for(int i=start;i<k;i++) {
			cal1(count+1,i+1,(flag|1<<i));
			cal1(count+1,i+1,flag);
		}
		
	}
	
	private static void cal(int count,int start) {
		// TODO Auto-generated method stub
		if(count==k) {

			int sinmul=1;
			int ssnsum=0;
			for(int i=0;i<k;i++) {
				if(visited[i]==1) {
					sinmul *= sin[i];
					ssnsum += ssn[i];
				}
			}
			if(ssnsum==0)
				return;
			diff = Math.min(diff, Math.abs((sinmul-ssnsum)));

			return;
		}
		
		for(int i=start;i<k;i++) {
			
			visited[i]=1;
			cal(count+1,i+1);
			visited[i]=0;
			cal(count+1,i+1);
		}
		
	}
}
