import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가르침 {

	static int maxlearn = Integer.MIN_VALUE;
	static int N;
	static int K;
	static String[] word;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		word = new String[N];
		K = Integer.parseInt(st.nextToken());
		K=K-5; //antic
		//ascii a = 97 
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			String sword ="";
			for(int a=4;a<str.length()-4;a++) {
				sword = sword+str.charAt(a);
			}
			word[i] = sword;
		}
		//a =0 c= 2 i=8  n = 13  t = 19  
		int flag=0;
		flag = flag | 1<<0; flag = flag | 1<<2; flag = flag | 1<<8; flag = flag | 1<<13; flag = flag | 1<<19;
		
		if(K<0) {
			System.out.println(0);
		}
		else if(K==21) {
			System.out.println(N);
		}
		else {
			learn(0,0,flag);
			System.out.println(maxlearn);
		}
	}
	public static void learn(int count,int start,int flag) {
		if(count==K) {
			int rcount=0;
			for(int i=0;i<N;i++) {
				String use = word[i];
				boolean check = true;
					for(int j=0;j<use.length();j++) {
						int number = use.charAt(j) - 97;
						if((flag & 1 <<number)==0) {
							check =false;
							break;
						}
					}
				if(!check) {
					rcount++;
				}
			}
				maxlearn = Math.max(maxlearn,rcount);

			return;
		}
		
		for(int i=start;i<26;i++) {
			if((flag & 1 <<i )==0) {
			learn(count+1,i,(flag | 1<<i ));
			}
		}
	}
}
