import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class station {
	station nstation = null;
	station pstation = null;
	int stnum;
	public station(station pstation, station nstation, int stnum) {
		this.nstation = nstation;
		this.pstation = pstation;
		this.stnum = stnum;
	}
}

class stlist { 

	station first;
	
	public void insert(int num) {
		if(first==null) {
			first = new station(first,first,num); //이거당시에는 안들어감
			first.nstation = first;
			first.pstation = first;
		}
		else {
			station last = findLastStation();
			station nsta = new station(last,first,num); // nsta가 마지막노드가되므로 nsta의 전노드는 last nsta의 다음노드는 first
			first.pstation = nsta;
			last.nstation = nsta;
		}
	}
	
	public void print() {
		if(first.nstation==first) { // 길이가 1개인경우
			System.out.println(first.stnum);
		}
		else {
			station findst = first;
			while(findst.nstation!=first) {
				System.out.print(findst.stnum + " ");
				findst = findst.nstation;
			}
			System.out.println(findst.stnum);
			return ;
		}
	}
	
	public void printreverse() {
		if(first.nstation==first) { // 길이가 1개인경우
			System.out.println(first.stnum);
		}
		else {
			station lastst = first.pstation;
			station savelast = lastst;
			while(lastst.pstation!=savelast) {
				System.out.print(lastst.stnum + " ");
				lastst = lastst.pstation;
			}
			System.out.println(lastst.stnum);
			return ;
		}
	}
	
	
	
	
	public void BN(int num1 , int num2) {
		 // i , j , k 로 건설한다고  가정
		station istation = findStation(num1);
		station kstation = istation.nstation;
		System.out.println(kstation.stnum);
		station jstation = new station(istation,kstation,num2); // i j k 순으로된 jstation 설립
		istation.nstation = jstation;
		kstation.pstation = jstation;
	}
	
	public void BP(int num1 , int num2) {
		 //k j i 로 건설한다고 가정
		station istation = findStation(num1);
		station kstation = istation.pstation;
		System.out.println(kstation.stnum);
		station jstation = new station(kstation,istation,num2); // i j k 순으로된 jstation 설립
		istation.pstation = jstation;
		kstation.nstation = jstation;
	}
	public void CN(int num) {
		
		// i j k 순으로 있다고 가정
		station istation = findStation(num);
		station jstation = istation.nstation;
		station kstation = jstation.nstation;
		System.out.println(jstation.stnum);
		istation.nstation = kstation;
		kstation.pstation = istation;
		if(jstation==first) {
			first = jstation.nstation;
		}
	}
	public void CP(int num) {
		
		// k j i 순으로 있다고 가정
		station istation = findStation(num);
		station jstation = istation.pstation;
		station kstation = jstation.pstation;
		System.out.println(jstation.stnum);
		istation.pstation = kstation;
		kstation.nstation = istation;
		//삭제하려는 역이 첫번째역이라면 first를 재설정해줘야댐
		if(jstation==first) {
			first = jstation.nstation;
		}

	}
	public station findStation(int num) {
		station findst = first;
		if(findst.stnum==num) {
			return findst;
		}
		while(findst.nstation!=first) {
			findst = findst.nstation;
			if(findst.stnum==num) {
				return findst;
			}
		}
		return null;
	}
	
	
	public station findLastStation() {
		
		if(first.nstation==first) { // 길이가 1개인경우
			return first;
		}
		else {
			station findst = first;
			int i=0;
			while(findst.nstation!=first) {
				findst = findst.nstation;
			}
			return findst;
		}
	}
	
	
	
}


public class 철도공사 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		stlist subway = new stlist();
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int stcount = Integer.parseInt(st.nextToken());
		 int cmcount = Integer.parseInt(st.nextToken());


		 st = new StringTokenizer(br.readLine());
		 for(int i=0;i<stcount;i++) {
			 subway.insert(Integer.parseInt(st.nextToken()));
		 }
		 

		 for(int i=0;i<cmcount;i++) {		
			 st = new StringTokenizer(br.readLine());
			 switch(st.nextToken()) {
			 case "BN":
				 subway.BN(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				 break;
			 case "BP":
				 subway.BP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				 break;
			 case "CN":
				 subway.CN(Integer.parseInt(st.nextToken()));
				 break;
			 case "CP":
				 subway.CP(Integer.parseInt(st.nextToken()));
				 break;
			 }
		 }
		 
	}

}
