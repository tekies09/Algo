import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	int x;
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(this.x>=o.x) {
			return 1;
		}
		else {
		return -1;
		}
	}
	public Node(int x) {
		this.x = x;
	}
	
}
public class 최소힙 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		
		for(int i=0;i<k;i++) {
			int a = Integer.parseInt(br.readLine());
			if(a==0) {
				if(!pq.isEmpty()) {
					System.out.println(pq.poll().x);
				}
				else {
					System.out.println(0);
				}
			}
			else {
				pq.add(new Node(a));
			}
		}
	}

}
