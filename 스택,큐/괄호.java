import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class 괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   StringBuilder sb = new StringBuilder();
		   
		   int T= Integer.parseInt(br.readLine());
		   for(int i=0;i<T;i++) {
			   Stack<Character> s = new Stack<Character>();
			   String Line = br.readLine();
			   String answer = "YES \n";
			   for(int k=0;k<Line.length();k++) {
				  char a = Line.charAt(k);
				  if(a==')') {
					  if(s.isEmpty()) {
						  answer = "NO \n";
						  break;
					  }
					  char StackChar = s.pop();
					  if(StackChar == a) {
						  answer = "NO \n";
						  break;
					  }
				  }
				  if(a=='(') {
					  s.push(a);
				  }
			   }
			   if(s.size()!=0) {
				   answer = "NO \n"; 
			   }
			   sb.append(answer);
		   }
		   System.out.println(sb);
	}
}
