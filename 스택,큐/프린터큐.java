import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  StringTokenizer st;
		  int tc = Integer.parseInt(br.readLine());
		  for(int t = 0;t<tc;t++) {
			  st = new StringTokenizer(br.readLine());
			  int count = Integer.parseInt(st.nextToken());
			  int number = Integer.parseInt(st.nextToken());
			  Queue<int[]> queue = new LinkedList<>();
			  int answer = 0;
			  st = new StringTokenizer(br.readLine());
			  for(int i =0;i<count;i++) {
				  int[] k = new int[] {i,Integer.parseInt(st.nextToken())};
				  queue.offer(k);
			  }
			  while(!queue.isEmpty()) {
				 int[] first =  queue.poll();
				 Iterator it = queue.iterator();
				 boolean flag = false;
				 while(it.hasNext()) {
					 int[] now = (int[]) it.next();
					 if(now[1]>first[1]) {
						 flag = true;
						 break;
					 }
				 }		
				 if(flag) {
					  queue.offer(first); 
					 continue;
					 }
				 answer++;
				 if(first[0]==number) break;
			  }
			  System.out.println(answer);
			  
		  }
	}

}
