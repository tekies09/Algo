package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class building{
	long index;
	long high;
	public building(long high, long index) {
		this.index=index;
		this.high = high;
	}
}
public class 옥상정원꾸미기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long count = Integer.parseInt(br.readLine());
		long answer = 0;
		long bindex = count;
		Stack<building> s1 = new Stack<>();
		Stack<building> s2 = new Stack<>();
		for(int i=0;i<count;i++) {
			long number = Integer.parseInt(br.readLine());
			s1.add(new building(number,--bindex));
		}
		
		
		while(!s1.isEmpty()) {
			building current = s1.pop();
			if(s2.isEmpty()) { //맨처음 값추가
				s2.add(current);
				continue;
			}
			
			while(!s2.isEmpty()) {
				
				building s2c = s2.peek();
				
				if(s2c.high>= current.high) { //더이상 볼 빌딩이없음
					s2.add(current);
					answer += current.index-s2c.index-1;
					break;
				}
				
				s2.pop();
			}
			
			if(s2.isEmpty()) {
				s2.add(current);
				answer += current.index;
			}
			
	//		System.out.println(answer + " : " + current.index + " : " + current.high);
		}
		System.out.println(answer);
		

		
		
		
	}

}
