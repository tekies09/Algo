package Queue;
import java.util.*;
import java.io.*;



public class 트럭 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int time= 0;
		int cWeight = 0;
		Queue<Integer> TruckList = new LinkedList<>();
		
		st= new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
		
			int cur = Integer.parseInt(st.nextToken());
			while(true) { // 1초 단위로 갱신해줄거임
				if(TruckList.isEmpty()) { // 보드 위에 아무도없다면 바로 추가 
					time++;
					cWeight+=cur;
					TruckList.add(cur);
					break;
				}
				
				// 0이라는 토큰을 넣고 빼는 역할을 한사이클로 해야되는데 꽉차면 빼고 그다음에 안꽉차면 넣는과정을해야됨
				
				if(TruckList.size()==w) {
					cWeight-= TruckList.poll();
					continue;
				}
				if(cWeight+cur>l) { //무게를 초과해서 건널수없는경우 0토큰으로 1초가지남을표시해줌
					time++;
					TruckList.add(0);
				}
				else {
					time++;
					TruckList.add(cur);
					cWeight+= cur;
					break;
				}
			}

		}
		//이거 까지하면 결국 끝날때는 마지막트럭이 올라간상태로 끝난다
		//그러면 그때의 time + 다리의 길이를 더하면 총시간이나옴
	
		System.out.println(time+w);
		
		
		
	}

}
