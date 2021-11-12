import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//같은행에는 안둠  
public class NQueen {

	static int N;
	static int col[];
	static int count=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N+1]; 
		setQueens(1);
		System.out.println(count);
	}

	
	private static void setQueens(int NowRow) {
		

		/*
		 * 
		 *isavailable 체크를 먼저하는이뉴는 nowrow >n에 경우에서 카운팅을 해줄껀데
		 *일단 이전까지의 배치가 완벽해야 nqueen으로 카운팅을 가능하기때문에 
		 *
		*/
		

		
				// setQueens를 타고 들어왔을때 아직 배치전이지만 NowRow는 증가한상태이고 그전에 놓았던 Queen에 대해 검사를하고 잘못두엇다면 다시 return 해서 돌아감
		if(!isAvailable(NowRow-1)) {
			return ;
		}
	
		if(NowRow>N) { // N행까지 퀸으배치가 다 끝나고 그다음에 setQueens가 호출됬을경우임
			count++;
			return;
		}
	
		//현재 1열부터 N열까지 놓아보기
		
		
		//놓았으면 다음퀸 놓으로가기
		
		for(int i=1; i<=N;i++) {
			col[NowRow] = i; // NowRow번째 행의 Queen을 i번째 열의 설치 
			setQueens(NowRow+1); //설치후 다음행으로 이동
		}
	}
	
	
	private static boolean isAvailable(int NowRow) {
		for(int k=1;k<NowRow;k++) { // 1행부터 ~N-1까지의 NQueen자리와 현재 NowRow의 Queen위치검사
			if(col[NowRow]==col[k]) return false; //같은 열에있는경우 false 반환 
			//대각선검사 현재위치와 대각선에 있는 위치의 각각연산결과의 차이가 abs(행-행) == abs(열-열)이면 대각선에있음
			if(Math.abs(col[NowRow]-col[k])==Math.abs(NowRow-k)) return false;
		}
		return true; //대각+ 라인검사가 무사히 끝나면 놓을수있는거임 
	}
}
