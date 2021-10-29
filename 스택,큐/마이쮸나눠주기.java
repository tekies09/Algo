import java.util.LinkedList;
import java.util.Queue;

public class 마이쮸나눠주기 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Queue<int[]> queue = new LinkedList<int[]>();
		int ccount = 20; // 20개의 마이쮸가 있다가정
		int start = 1;
		queue.offer(new int[] {start,1});
		
		while(ccount>0) {
			if(!queue.isEmpty()) {
				int[] p = queue.poll();
				int availableCnt = (ccount>=p[1])? p[1]:ccount; // 마이쮸를 나눠줫을때 요구갯수보다 적으면 남은거라도가져옴
				ccount-= availableCnt; //마이쮸 소모
				if(ccount==0) { //최후의 마이쮸승자
					System.out.println("최후의 승자는"+ p[0]+"번이"+ availableCnt+"만큼 마이쮸 가져감" );
				}
				else {
					System.out.println(p[0]+"번이"+ availableCnt+"만큼 마이쮸 가져감 | 남은마이쮸 : " + ccount );
					p[1]++; // 요구개수증가
					queue.offer(p);
					queue.offer(new int[] {++start,1}); //뉴페이스 등장 
					System.out.println(start+ "번이 줄을 섯습니당");
				}
			}
		}

	}

}
