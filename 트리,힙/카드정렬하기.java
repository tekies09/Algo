import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		PriorityQueue<Long> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0;i<k;i++) {
			pq.add((long) Integer.parseInt(br.readLine()));
			
		}
		long sum=0;
		while(pq.size()>1) {
			
			long number1 = pq.poll();
			long number2 = pq.poll();

			sum= sum+number1+number2;
			
			pq.offer(number1+number2);
		
		}
		System.out.println(sum);
	}

}
