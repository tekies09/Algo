import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LISByBinarySearch {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	// total time =10000
	int N = Integer.parseInt(st.nextToken()); 
	int[] result = new int[N];
	int[] array = new int[N];
	st = new StringTokenizer(br.readLine());
	for(int i=0;i<N;i++) {
		array[i] = Integer.parseInt(st.nextToken()); 
	}

	int size= 0; //채워진 원소수
	for(int i=0;i<N;i++) {
		int index = Math.abs(Arrays.binarySearch(result, 0,size,array[i]))-1;

		result[index] = array[i];
		
		if(index==size) ++size;
	}
	
	System.out.println(size);

}
}
