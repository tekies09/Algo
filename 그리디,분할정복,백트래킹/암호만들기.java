import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호만들기 {

	static int L,C;
	static int v=1,c=2;
	static int[] alpha;
	static int[] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alpha = new int[C];
		visited = new int[C];
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<C;i++) {
			alpha[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alpha);
		/*
		for(int i=0;i<C;i++) {
			System.out.print((char)alpha[i]+ " ");
		}
		*/
		
		printword(0,0);
	}
	private static void printword(int start, int count) {
		// TODO Auto-generated method stub
		if(count==L) {
			StringBuilder sb = new StringBuilder();
			int vowel=0,conso=0;
			for(int i=0;i<C;i++) {
				if(visited[i]==1) {
					if(alpha[i] == 'a' || alpha[i] == 'e' || alpha[i] == 'i' || alpha[i] == 'o' || alpha[i] == 'u' ) {
						vowel++;
					}
					else {
						conso++;
					}
					sb.append((char)alpha[i]);
				}
			}
			if(vowel>=v && conso>=c) {
			System.out.println(sb);
			}
			return;
		}
		
		for(int i=start;i<C;i++) {
				visited[i]=1;
				printword(i+1,count+1);
				visited[i]=0;
		}
	}
}
