package Backtracking;

import java.util.*;
import java.io.*;

public class 이공사팔 {

	static int N;
	static int answer;
	static boolean[][] combc;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] array;

		array = new int[N][N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int cur = Integer.parseInt(st.nextToken());
				array[i][j] = cur;
			}
		}
		answer =-1; 
		
		
		

		move(array,0);
		System.out.println(answer);
	}
	public static void move(int[][] array,  int count) {
		
		if(count==5) {
			answer = Math.max(arraymax(array),answer);
			return ;
		}
		
		for(int i=0;i<4;i++) {

			//4방향으로 재귀타기 
			move(movearray(array,i),count+1);
			
		}

	}
	
	public static int[][] movearray(int[][] array, int dir){
		combc = new boolean[N][N];
		if(dir==0) { //위로 당기기
			for(int i=0;i<N;i++) { //y의 좌표
				
				for(int j=1;j<N;j++) { //x 의 좌표부터 당겨주기
					int cur = array[j][i];
					boolean exist = false;
					for(int k=j-1;k>=0;k--) { // 해당 좌표부터 위로 당겻을때 검사해주기
						
						if(array[k][i]!=0) { // 앞에 검사하는데  합칠수있을경우만 체크 
							if(array[k][i]==cur && !combc[k][i]) {
								exist = true;
							}
							break;
						}
						// 검사한 원소의 자리가 비어있지않고 동일하며 합쳐진 기록이없다면 그곳으로  합쳐서 당겨오기
					}
				if(!exist) { //해당 좌표를 당겼을때 합쳐질수없다면 빈곳중에 남는자리로 당겨오기
					
					for(int k=0;k<=j;k++) {
						if(array[k][i]==0) {
							array[k][i]=cur;
							array[j][i]=0;
							break;
						}
					}
					
					}
				else { //합치기가능한경우 합쳐주기
					for(int k=j-1;k>=0;k--) {
						if(array[k][i]!=0) {
							combc[k][i] = true;
							array[k][i]+=cur;
							array[j][i] = 0;
							break;
						}
					}
					}
				}
			}
		}
		else if(dir==1) { //아래로당겨주기
			for(int i=0;i<N;i++) { //y의 좌표
				
				for(int j=N-2;j>=0;j--) { //x 의 좌표부터 당겨주기
					int cur = array[j][i];
					boolean exist = false;
					for(int k=j+1;k<N;k++) { // 해당 좌표부터 위로 당겻을때 검사해주기
						
						if(array[k][i]!=0) { // 앞에 검사하는데  합칠수있을경우만 체크 
							if(array[k][i]==cur && !combc[k][i]) {
								exist = true;
							}
							break;
						}
						// 검사한 원소의 자리가 비어있지않고 동일하며 합쳐진 기록이없다면 그곳으로  합쳐서 당겨오기
					}
				if(!exist) { //해당 좌표를 당겼을때 합쳐질수없다면 빈곳중에 남는자리로 당겨오기
					
					for(int k=N-1;k>=j;k--) {
						if(array[k][i]==0) {
							array[k][i]=cur;
							array[j][i]=0;
							break;
						}
					}
					
					}
				else { //합치기가능한경우 합쳐주기
					for(int k=j+1;k<N;k++) {
						if(array[k][i]!=0) {
							combc[k][i] = true;
							array[k][i]+=cur;
							array[j][i] = 0;
							break;
						}
					}
					}
				}
			}
		}
		else if(dir==2) { //오른쪽 
	for(int i=0;i<N;i++) { //x의 좌표
				
				for(int j=N-2;j>=0;j--) { //y 의 좌표부터 당겨주기
					int cur = array[i][j];
					boolean exist = false;
					for(int k=j+1;k<N;k++) { // 해당 좌표부터  당겻을때 검사해주기
						
						if(array[i][k]!=0) { // 앞에 검사하는데  합칠수있을경우만 체크 
							if(array[i][k]==cur && !combc[i][k]) {
								exist = true;
							}
							break;
						}
						// 검사한 원소의 자리가 비어있지않고 동일하며 합쳐진 기록이없다면 그곳으로  합쳐서 당겨오기
					}
				if(!exist) { //해당 좌표를 당겼을때 합쳐질수없다면 빈곳중에 남는자리로 당겨오기
					
					for(int k=N-1;k>=j;k--) {
						if(array[i][k]==0) {
							array[i][k]=cur;
							array[i][j]=0;
							break;
						}
					}
					
					}
				else { //합치기가능한경우 합쳐주기
					for(int k=j+1;k<N;k++) {
						if(array[i][k]!=0) {
							combc[i][k] = true;
							array[i][k]+=cur;
							array[i][j] = 0;
							break;
						}
					}
					}
				}
			}
		}
		else { //왼쪽
			for(int i=0;i<N;i++) { //x의 좌표
				
				for(int j=1;j<N;j++) { //y 의 좌표부터 당겨주기
					int cur = array[i][j];
					boolean exist = false;
					for(int k=j-1;k>=0;k--) { // 해당 좌표부터 위로 당겻을때 검사해주기
						
						if(array[i][k]!=0) { // 앞에 검사하는데  합칠수있을경우만 체크 
							if(array[i][k]==cur && !combc[i][k]) {
								exist = true;
							}
							break;
						}
						// 검사한 원소의 자리가 비어있지않고 동일하며 합쳐진 기록이없다면 그곳으로  합쳐서 당겨오기
					}
				if(!exist) { //해당 좌표를 당겼을때 합쳐질수없다면 빈곳중에 남는자리로 당겨오기
					
					for(int k=0;k<=j;k++) {
						if(array[i][k]==0) {
							array[i][k]=cur;
							array[i][j]=0;
							break;
						}
					}
					
					}
				else { //합치기가능한경우 합쳐주기
					for(int k=j-1;k>=0;k--) {
						if(array[i][k]!=0) {
							combc[i][k] = true;
							array[i][k]+=cur;
							array[i][j] = 0;
							break;
						}
					}
					}
				}
			}
		}
		
		
		return array;
	}
	
	
	public static int arraymax(int[][] array) {
		int max=-1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(array[i][j]>max) max= array[i][j];
			}
		}
		return max;
	}
}
