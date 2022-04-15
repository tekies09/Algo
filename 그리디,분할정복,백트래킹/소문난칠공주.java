package Backtracking;

import java.util.*;
import java.io.*;
public class 소문난칠공주 {
	static class  Person{
		int x;
		int y;
		public Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}

	static int N;
	static int answer;
	static int[][] array;
	static int[] member;
	static boolean[][] use;
	static int[] dx = new int[] {0,1,-1,0};
	static int[] dy = new int[] {1,0,0,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = 7;
		answer=0;
		array = new int[5][5];
		use = new boolean[5][5];
		member = new int[7];
		for(int i=0;i<5;i++) {
			String line  = br.readLine();
			for(int j=0;j<5;j++) {
				if(line.charAt(j)=='Y') {
					array[i][j] = 0;
				}
				else {
					array[i][j] = 1;
				}
			}
		}
		pri(0,0);
		System.out.println(answer);
	}
	
	
	static public void pri(int count, int cur) {
		if(count==7) {
			if(scount()) {
				if(connect()) answer++;
			}
			return;
		}

		
		for(int i=cur;i<25;i++) {
			member[count]=i;
			use[i/5][i%5] =true;
			pri(count+1,i+1);
			use[i/5][i%5] = false;
		}
	}
	
	
	static public boolean connect() {
		
		boolean visited[][] = new boolean[5][5];
		int firstx=-1;
		int firsty = -1;
		Loop:
		for(int i=0;i<5;i++) { 
			for(int j=0;j<5;j++) { //시작점찾기
				if(use[i][j]) { //사용중이라면 
					firstx=i;
					firsty=j;
					break Loop;
				}
			}
		}
		
		visited[firstx][firsty]=true;
		Queue<Person> q = new LinkedList<>();
		q.add(new Person(firstx,firsty));
		int count=0;
		while(!q.isEmpty()) {
			Person cur = q.poll();
			count++;
			
			if(count==7) break;
			for(int j=0;j<4;j++) {
				int nx = cur.x+dx[j];
				int ny = cur.y+dy[j];
				
				if(nx<0 || nx >4 || ny <0 || ny>4) continue;
				if(use[nx][ny] && !visited[nx][ny]) {
					visited[nx][ny]=true;
					q.add(new Person(nx,ny));
				}
			}
			
		}
		if(count==7) return true;
		return false;
	}
	static public boolean scount() {
		int count = 0;
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(use[i][j]) { //사용중이라면 
					count+= array[i][j];
				}
			}
		}
		if(count<4) return false;
		return true;
	}
	
}
