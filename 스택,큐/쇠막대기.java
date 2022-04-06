package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 쇠막대기 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<>();
		String line = br.readLine();
		
		boolean flag = false;
		int count=0;
		for(int i=0;i<line.length();i++) {
			char current = line.charAt(i);
			if(current=='(') {
				s.add(current);
			}
			else {
				s.pop(); //1쌍제거
				
				if(line.charAt(i-1)==current) { //끝맺음임
					count++;
				}
				else { // 한쌍셋트로 포인터슝
					count+= s.size();
				}
			}
		}
		System.out.println(count);
	}

}
