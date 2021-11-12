import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또 {

	public static int[] numbers;
	public static int[] visited;
	public static int k;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
		
		st = new StringTokenizer(br.readLine());
		
		k = Integer.parseInt(st.nextToken());
		if(k==0) {
			break;
		}
		numbers = new int[k];
		visited = new int[k];
		for(int i=0;i<k;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		printlotto(0,0);
		System.out.println();
		}
	}
	private static void printlotto(int start, int cnt) {
		// TODO Auto-generated method stub
		if(cnt==6) {
			for(int i=0;i<k;i++) {
				if(visited[i]==1) System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start;i<k;i++) {
			if(visited[i]==0) {
			visited[i]=1;
			printlotto(i+1,cnt+1);
			visited[i]=0;
			}
		}
	}
}
