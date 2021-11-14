import java.util.PriorityQueue;

public class 더맵게 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] {1,2,3,9,10,12};
		System.out.println(solution(a,7));
		
	}
	 public static int solution(int[] scoville, int K) {
		    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		    for(int i=0;i<scoville.length;i++) {
		    	pq.add(scoville[i]);
		    }
		    int answer = 0;
		    while(!pq.isEmpty()) {
		    	int k1=pq.poll();
		    	if(k1<K) {
		    		if(pq.isEmpty()) {
		    			return -1;
		    		}
		    		int k2= pq.poll();
		    		pq.add(k1+k2*2);
		    		answer++;
		    	}
		    	else {
		    		return answer;
		    	}
		    }
		    return -1;
	    }
}
