import java.util.Arrays;

public class DisJoinSetTest {

	static int N;
	static int[] parents; // 부모 원소들 관리
	private static void make() {
		for(int i=0;i<N;i++) {
			parents[i] = i;
		}
	}
	
	
	private static int find(int x) {
		if(parents[x]==x) {
			return x;
		}
		return parents[x]=find(parents[x]);
	}
	
	private static boolean union(int x,int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) return false; //이미 대표하는 부모가같아서 유니온할필요 x
		parents[yRoot] = xRoot; // y의 부모는 자기자신을 연결했으나 x부모를 링크함으로써 x와  y의 유니온역할을함
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		N=5;
		parents = new int[N];
		//집합만들기
		make();
		//union
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(4,3));
		System.out.println(Arrays.toString(parents));
		
		
		System.out.println("find 진행");
		
		for(int i=N-1;i>=0;i--) {
			System.out.println(find(i));
			System.out.println(Arrays.toString(parents));
		}
		
	}

}
