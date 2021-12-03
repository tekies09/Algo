import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int size = Integer.parseInt(br.readLine());
		int[][] array = new int[size][size];
		
	
		for(int i=0;i<size;i++) {
			st= new StringTokenizer(br.readLine());
			for(int j=0;j<size;j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(array[i][j]==0)
				array[i][j] = 10001;
			}
		}
		
		for(int k=0;k<size;k++) {
			for(int i=0;i<size;i++) {
				 {
					for(int j=0;j<size;j++) {
							array[i][j] = Math.min(array[i][k]+array[k][j],array[i][j]);
					}
				}
			}
		}
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(array[i][j]!=10001)
				sb.append("1 ");
				else {
					sb.append("0 ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
}
