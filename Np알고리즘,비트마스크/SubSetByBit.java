
public class SubSetByBit {

	static int[] input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new int[] {7,1,4,2,3};
		makesubset();
	}

	public static void makesubset() {
		
		
		for(int i=0;i<Math.pow(2, input.length);i++) {
			
			for(int j=0;j<input.length;j++) {
				if((i&1<<j)!=0) {
					System.out.print(input[j]+ " ");
				}
			}
			System.out.println();
		}
		
	}
}
