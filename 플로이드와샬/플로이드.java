import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		int length = Integer.parseInt(br.readLine());
		int[][] array = new int[size+1][size+1];
		
		for(int i=0;i<=size;i++) {
			for(int j=0;j<=size;j++) {
				array[i][j] = 10000001;
			}
		}
		for(int i=0;i<length;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			if(array[start][end]>value) {
				array[start][end] = value;
			}
		}
		
		for(int k=1;k<=size;k++) {
			for(int i=1;i<=size;i++) {
				if(k!=i) {
				for(int j=1;j<=size;j++) {
					if(j!=k && j!=i) {
					array[i][j] = Math.min(array[i][k]+array[k][j], array[i][j]);
					}
				}
				}
			}
		}
		
		for(int i=1;i<=size;i++) {
			for(int j=1;j<=size;j++) {
				if(array[i][j]==10000001)
					sb.append("0 ");
				else {
				sb.append(array[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
