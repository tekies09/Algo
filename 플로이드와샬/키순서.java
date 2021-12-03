import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키순서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int[][] array = new int[size+1][size+1];
		
		for(int i=0;i<=size;i++) {
			for(int j=0;j<=size;j++) {
				array[i][j] = 1000;
			}
		}
		
		for(int i=0;i<length;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
				array[start][end] = 1;
		}
		
		
		for(int k=1;k<=size;k++) {
			for(int i=1;i<=size;i++) {
				if(i!=k) {
				for(int j=1;j<=size;j++) {
				if(j!=i && j!=k) {
					array[i][j] = Math.min(array[i][k]+array[k][j], array[i][j]);
				}
				}
				}
			}
		}
		
		int totalcount=0;
		for(int i=1;i<=size;i++) {
			int count = 0;
			for(int j=1;j<=size;j++) {
				if(array[i][j]!=1000){
					count++;
				}
				if(array[j][i]!=1000) {
					count++;
				}
			}
			if(count==size-1) {
				totalcount++;
			}
		}
		System.out.println(totalcount);
		
		
	}

}
