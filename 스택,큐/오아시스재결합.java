import java.io.*;
import java.util.*;

public class 오아시스재결합 {

	static class people{
		int height;
		int count;
		public people(int height, int count) {
			this.height = height;
			this.count = count;
		}
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		long answer = 0;
		Stack<people> s =new Stack<>();
		for(int i=0;i<k;i++) {
		int cur = Integer.parseInt(br.readLine());
		people cp = new people(cur,1);
		while(!s.isEmpty()) {
		people sp = s.peek();
			if(sp.height==cur) {
				answer += sp.count;
				cp.count += sp.count;
				s.pop();
				continue;
			}
			else if(sp.height>cur) {
				answer ++;
				break;
			}
			answer += sp.count;
			s.pop();
		}
		s.add(cp);
		}
		System.out.println(answer);

	}

}