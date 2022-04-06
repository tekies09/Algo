package Stack;
import java.util.*;
import java.io.*;
public class 스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<>();
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0;i<count;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String type= st.nextToken();
			if(type.equals("push")) {
				s.push(Integer.parseInt(st.nextToken()));
				continue;
			}
			else if(type.equals("top")) {
				if(s.isEmpty()) {
					sb.append(-1);
				}
				else {
					sb.append(s.peek());
				}
			}
			else if(type.equals("empty")) {
				if(s.isEmpty()) {
					sb.append(1);
				}
				else {
					sb.append(0);
				}
			}
			else if(type.equals("pop")) {
				if(s.isEmpty()) {
					sb.append(-1);
				}
				else {
					sb.append(s.pop());
				}
			}
			else {
				sb.append(s.size());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
