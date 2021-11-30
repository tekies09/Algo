import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 반도체설계 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[size];
		int[] lis = new int[size];
		for(int i=0;i<size;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int length=0;
		for(int i=0;i<size;i++) {
			int index = Arrays.binarySearch(lis, 0, length, array[i]);
			if(index<0) index = -1*index-1;
			lis[index]=array[i];
			if(index==length) {
				length++;
			}
		}
		System.out.println(length);
	}

	
}
