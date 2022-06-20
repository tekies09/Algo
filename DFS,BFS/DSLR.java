package BFS;
import java.util.*;
import java.io.*;

class word {
	String word;
	String command;
	
	public word (String word,String command) {
		this.word= word;
		this.command = command;
	}
}

public class DSLR {

	static String x;
	static String y;
	
	static char[][] array;
	static int[][] visit;
	
	
	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<tc;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			x = st.nextToken();
			y = st.nextToken();
			
			String answer = bfs(x,y);
			sb.append(answer);
			sb.append("\n");
			

			
		}
		System.out.println(sb);
	}
	
	
	public static String zerocount(int nx) {
		String zc = "";
		String zerocount = "";
		if(nx<10) {
			zerocount = "000"; 
		}
		else if(nx<100){
			zerocount ="00";
		}
		else if(nx <1000) {
			zerocount = "0";
		}
		zc = zerocount+nx;
		return zc;
	}
	public static String bfs(String a,String b) {
		
		
	String answer="";
	Queue<word> q = new LinkedList<>();
	q.add(new word(zerocount(Integer.parseInt(a)),answer));
	b=zerocount(Integer.parseInt(b));
	int[] visited = new int[10000];
	visited[Integer.parseInt(a)] = 1;
	while(!q.isEmpty()) {
		word cur = q.poll();
		String curcom = cur.command;
		int curword = Integer.parseInt(cur.word);
		int d1w = cur.word.charAt(0)-'0';
		int d2w = cur.word.charAt(1)-'0';
		int d3w = cur.word.charAt(2)-'0';
		int d4w = cur.word.charAt(3)-'0';
		
		if(cur.word.equals(b)) {
			answer = cur.command;
			break;
		}
		
		// type D
		int dx = (curword *2)%10000;
		
		// type S
		int ds = (curword+9999)%10000;
		
		// type L
		int dl = d2w*1000+ d3w*100+d4w*10+d1w;
		// type R
		int dr = d4w*1000 + d1w*100 + d2w*10+d3w;
		
		if(visited[dx]==0) {
			
			visited[dx] = 1;
			q.add(new word(zerocount(dx),curcom+"D"));

		}
		if(visited[ds]==0) {
			visited[ds] = 1;
			q.add(new word(zerocount(ds),curcom+"S"));
		}
		if(visited[dl]==0) {
			visited[dl] = 1;
			q.add(new word(zerocount(dl),curcom+"L"));
		}
		if(visited[dr]==0) {
			visited[dr] = 1;
			q.add(new word(zerocount(dr),curcom+"R"));
		}
	}
	
	return answer;
	
	
	}
	
}
