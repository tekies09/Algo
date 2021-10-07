
public class Powerset {


	static int[] hi = new int[] {5,6,10,11,16};
	static boolean[] is = new boolean[5];
	static int count=0;
	static int scount=0;
	
	public static void main(String[] args) {

		// subset(0);
		subsetsum(0);
		System.out.println("scount = " + scount);
	}
	
	public static void subsetsum(int cnt) {
		if(cnt==5) {
			int sum=0;
			for(int i=0;i<5;i++) {
				if(is[i]) {
					System.out.print(hi[i]+" ");
					sum=sum+hi[i];
				}
				else {
					System.out.print("X ");
				}
			}
			System.out.print(" sum : "+sum);
			if(sum==21) {
				System.out.print("이수들의 합은 21입니당");
				scount++;
			}
			System.out.println();
		}
		else {
			is[cnt]=true;
			subsetsum(cnt+1);
			is[cnt]=false;
			subsetsum(cnt+1);
		}
	}
	public static void subset(int cnt) {
		if(cnt==5) {
			for(int i=0;i<5;i++) {
				if(is[i]) {
					System.out.print(hi[i]);
				}
				else {
					System.out.print("X");
				}
			}
			count++;
			System.out.println();
		}
		else {
			is[cnt]=true;
			subset(cnt+1);
			is[cnt]=false;
			subset(cnt+1);
		}
	}
}
