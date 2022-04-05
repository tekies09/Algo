package Queue;
import java.util.*;
import java.io.*;
public class 앵무새 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int type = Integer.parseInt(br.readLine());
		Queue[] qlist = new Queue[type];
		for(int i=0;i<type;i++) {
			qlist[i] = new LinkedList<String>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			while(st.hasMoreTokens()) {
				qlist[i].add(st.nextToken());
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		boolean flag = false;
		while(st.hasMoreTokens()) {
			boolean cflag = true;
			String word = st.nextToken();
			for(int i=0;i<type;i++) {
				if(!qlist[i].isEmpty()) {
				if(qlist[i].peek().equals(word)) {
					qlist[i].poll();
					cflag = false;
					break;
				}
				}
			}
			
			
			
			// 매치하는값이 없을떄
			if(cflag) {
				flag = true;
				break;
			}	
		}
		
		for(int i=0;i<type;i++) {
			if(!qlist[i].isEmpty()) {
				flag = true;
			}
		}
		
		if(flag) {
			System.out.println("Impossible");
		}
		else {
			System.out.println("Possible");
		}
	}

}
