import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 브라우저스택응용 {
public static void main(String[] args) throws IOException {
	
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringBuilder sb = new StringBuilder();
	   StringTokenizer st = null;
	   String input = null;
	   String current = "https://www.ssafy.com";
	   
	   Stack<String> back = new Stack<String>();

	   Stack<String> forward = new Stack<String>();
	   while(true) {
		   input = br.readLine();
		   if(input.charAt(0)=='Q') break;
		   st = new StringTokenizer(input," ");
		   switch(st.nextToken()) {
		   case "V": //해당 사이트 방문 
			   forward.clear(); // 앞선기록 초기화
			   back.push(current);  // 백에다가 방문기록 넣기
			   current = st.nextToken(); //현재위치변경
			   System.out.println(current);
			   break;
		   case "B":
			 if(back.isEmpty()) {
				 System.out.println("뒤로갈페이지가없음");
			 }
			 else {
				 forward.push(current);
				 current =back.pop();
				 System.out.println(current);
			 }
			 break;
		   case "F":
				 if(forward.isEmpty()) {
					 System.out.println("앞으로");
				 }
				 else {
					 back.push(current);
					 current =forward.pop();
					 System.out.println(current);
				 }
				 break;
		   }
	   }
}
}
