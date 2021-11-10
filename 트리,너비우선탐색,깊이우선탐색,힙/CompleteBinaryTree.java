import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

	private char[] nodes; // 이진트리 저장할 배열
	private final int size; // 이진트리 크기
	private int lastIndex; //마지막 노드의 인덱스 즉 어디까지 배열이 차있는지 확인 
	
	public CompleteBinaryTree(int size) {
		this.size = size;
		nodes = new char[size+1];
	}
	
	public void add(char c) {
		if(lastIndex==size) return; // 배열크기에 꽉차있는경우 
		nodes[++lastIndex] = c;
	}

	public void bfs() {
		//배열로 관리하므로 탐색할 노드를 관리할 인덱스 저장 
		Queue<Integer> q = new LinkedList<Integer>(); //인덱스로 접근을 할거이므로 Integer로 
		q.offer(1);
		int current = 0 ; //탐색할 노드의 인덱스
		while(!q.isEmpty()) {
			current = q.poll();
			System.out.println(nodes[current]);
			if(current*2 <=lastIndex) q.offer(current*2); //해당노드의 왼쪽 자식이 범위안에있다면 
			if(current*2+1 <=lastIndex) q.offer(current*2+1); // 해당노드의 오른쪽 자식이 범위안에있따면
			
		}
	}
	
	public void bfs2() {   
		                // A / BC /DEFG / 이렇게 나눠서 탐색하게끔 분리된 구조로 구현
		Queue<Integer> q = new LinkedList<Integer>(); //인덱스로 접근을 할거이므로 Integer로 
		q.offer(1);
		int current = 0 ; //탐색할 노드의 인덱스
		int level = 0 , size=0;        // 사이즈란 위에  A/BC/DEFG 의경우 1/2/4의 사이즈를 가짐 

		
	
		while(!q.isEmpty()) {
		size = q.size();	
		System.out.print("level " + level+":");
 			while(--size>=0) {
			current = q.poll();
			System.out.print(nodes[current]+ " ");
			if(current*2 <=lastIndex) q.offer(current*2); //해당노드의 왼쪽 자식이 범위안에있다면 
			if(current*2+1 <=lastIndex) q.offer(current*2+1); // 해당노드의 오른쪽 자식이 범위안에있따면
			}	
			System.out.println();
		  level++;
		}

	}
}
