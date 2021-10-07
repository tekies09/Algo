import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
public static void main(String[] args) throws NumberFormatException, IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	
	int k = Integer.parseInt(br.readLine());
	
	int[][] top = new int[k+1][2];
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	String line = br.readLine();
	for(int i=1;i<=k;i++) {
		top[i][0] = i;
		top[i][1] = Integer.parseInt(st.nextToken());
	}
	
	Stack<int[]> s = new Stack<int[]>();
	
	for(int i=1;i<=k;i++) {
		while(!s.isEmpty()) {
		int num = s.peek()[1];
		if(num>top[i][1]) { //수신가능
			sb.append(s.peek()[0]).append(" ");
			s.push(top[i]);
			break;
		}
		else {
			s.pop();
		}
		}
		if(s.isEmpty()) {
			s.push(top[i]);
			sb.append("0 ");
		}
	}
	System.out.println(sb);
}
}
