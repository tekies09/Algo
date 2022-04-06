package Stack;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 에디터 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<>();
		Stack<Character> q = new Stack<>();
		String line = br.readLine();
		for(int i=0;i<line.length();i++) {
			s.add(line.charAt(i));
		}
		int count = Integer.parseInt(br.readLine());
		
		for(int i=0;i<count;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char type = st.nextToken().charAt(0);
			if(type=='P') {
			s.add(st.nextToken().charAt(0));	
			}
			else if(type=='B') {
				if(!s.isEmpty()) s.pop();
			}
			else if(type=='L') {
				if(!s.isEmpty()) q.add(s.pop());
			}
			else {
				if(!q.isEmpty()) s.add(q.pop());
			}
		}
		while(!s.isEmpty()) {
			q.add(s.pop());
		}

		while(!q.isEmpty()) {
			sb.append(q.pop());
		}
		System.out.println(sb);
		
	}

}
