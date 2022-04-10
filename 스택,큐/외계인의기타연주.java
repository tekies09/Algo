package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 외계인의기타연주 {

	static Stack<Integer> s1,s2,s3,s4,s5,s6;
	static int answer;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		s1 = new Stack<>();
		s2 = new Stack<>();
		s3 = new Stack<>();
		s4 = new Stack<>();
		s5 = new Stack<>();
		s6 = new Stack<>();
		
		
		int count = Integer.parseInt(st.nextToken());
		answer = 0;
		for(int i=0;i<count;i++) {
			st = new StringTokenizer(br.readLine());
			int type   =  Integer.parseInt(st.nextToken());
			int number =  Integer.parseInt(st.nextToken());
			play(type,number);
		}
		System.out.println(answer);
	}
	public static void play(int type, int number) {
		switch(type) {
		case 1:
			if(s1.isEmpty()) {
				answer++;
				s1.add(number);
				return;
			}
			while(!s1.isEmpty()) {
				if(s1.peek()<number) {
					break;
				}
				else if(s1.peek()==number){
					return;
				}
				s1.pop();
				answer++;
			}
			s1.add(number);
			answer++;
			break;
		case 2:
			
			if(s2.isEmpty()) {
				answer++;
				s2.add(number);
				return;
			}
			while(!s2.isEmpty()) {
				if(s2.peek()<number) {
					break;
				}
				else if(s2.peek()==number){
					return;
				}
				s2.pop();
				answer++;
			}
			s2.add(number);
			answer++;
			break;
		case 3:
			if(s3.isEmpty()) {
				answer++;
				s3.add(number);
				return;
			}
			while(!s3.isEmpty()) {
				if(s3.peek()<number) {
					break;
				}
				else if(s3.peek()==number){
					return;
				}
				s3.pop();
				answer++;
			}
			s3.add(number);
			answer++;
			break;
		case 4:
			if(s4.isEmpty()) {
				answer++;
				s4.add(number);
				return;
			}
			while(!s4.isEmpty()) {
				if(s4.peek()<number) {
					break;
				}
				else if(s4.peek()==number){
					return;
				}
				s4.pop();
				answer++;
			}
			s4.add(number);
			answer++;
			break;
		case 5:
			if(s5.isEmpty()) {
				answer++;
				s5.add(number);
				return;
			}
			while(!s5.isEmpty()) {
				if(s5.peek()<number) {
					break;
				}
				else if(s5.peek()==number){
					return;
				}
				s5.pop();
				answer++;
			}
			s5.add(number);
			answer++;
			break;
		default:
			if(s6.isEmpty()) {
				answer++;
				s6.add(number);
				return;
			}
			while(!s6.isEmpty()) {
				if(s6.peek()<number) {
					break;
				}
				else if(s6.peek()==number){
					return;
				}
				s6.pop();
				answer++;
			}
			s6.add(number);
			answer++;
			break;
			
		}
	}

}
