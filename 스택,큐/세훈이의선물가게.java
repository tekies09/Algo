package Queue;
import java.util.*;
import java.io.*;
public class 세훈이의선물가게 {

	static class Product implements Comparable<Product>{
		
		int time;
		int type; //A는 1 B는 2로줌
		
		public Product(int time, int type) {
			this.time= time;
			this.type= type;
		}
		public int compareTo(Product o) {
			if(this.time==o.time) {
				return this.type-o.type;
			}
			return this.time-o.time;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int Amax = -1;
		int Bmax = -1;
		int Acount = 0;
		int Bcount= 0;
		PriorityQueue<Product> pq = new PriorityQueue<>();
		for(int i=0;i<C;i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			String type = st.nextToken();
			int count = Integer.parseInt(st.nextToken());
			
			int ntype=1;
			if(type.equals("R")) { //지수작업
				ntype=2;
				Bcount+= count;
				if(Bmax<start) Bmax = start;
				for(int j=0;j<count;j++) {
					pq.add(new Product(Bmax,ntype));
					Bmax+=M;
				}
				
			}
			else { //세훈작업
				Acount+= count;
				if(Amax<start) Amax = start;
				for(int j=0;j<count;j++) {
					pq.add(new Product(Amax,ntype));
					Amax+=N;
				}
			}
		}
		
		
		int index = 1;
		StringBuilder asb = new StringBuilder();
		asb.append(Acount).append("\n");
		StringBuilder bsb = new StringBuilder();
		bsb.append(Bcount).append("\n");
		while(!pq.isEmpty()) {
			Product cur = pq.poll();
			if(cur.type==2) {
				bsb.append(index).append(" ");
				index++;
			}
			else {
				asb.append(index).append(" ");
				index++;
			}

		}
		System.out.println(asb);
		System.out.println(bsb);
		
		
	}

}
