package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class 오큰수 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int bcount = count;
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      StringBuilder sb = new StringBuilder();
	      Stack<Integer> s =new Stack<>();
	      Stack<Integer> bs = new Stack<>();
	      for(int i=0;i<count;i++) {
	    	  s.add(Integer.parseInt(st.nextToken()));
	      }
	      int[] answer = new int[count];
	      String line = "-1";
	      answer[--count] = -1;
	      bs.add(s.pop());
	      
	      
	      while(!s.isEmpty()) {
	    	  int now = s.pop();
	    	  boolean flag = false;
	    	  while(!bs.isEmpty()) {
	    		  int bnow = bs.peek();
	    		  
	    		  if(bnow<=now) {
	    			  bs.pop();
	    			  continue;
	    		  }
	    		  
	    		  answer[--count] = bnow;
	    		  flag = true;
	    		  break;
	    	  }
	    	  
	    	  if(!flag) answer[--count] = -1;
	    	  bs.add(now);
	      }
	      for(int i=0;i<bcount;i++) {
	    	  sb.append(answer[i]).append(" ");
	      }
	      System.out.println(sb);
	}

}
