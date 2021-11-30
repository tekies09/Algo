import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	// total time =10000
	int N = Integer.parseInt(st.nextToken()); 
	int[] result = new int[N];
	int[] array = new int[N];
	st = new StringTokenizer(br.readLine());
	for(int i=0;i<N;i++) {
		result[i] = Integer.parseInt(st.nextToken()); 
	}

	for(int i=0;i<N;i++) {
		array[i] = 1;
		for(int j=0;j<i;j++) {
			if(result[i]>result[j]) array[i] = Math.max(array[i],array[j]+1); 
		}
	}
	int max = 0;
	for(int i=0;i<N;i++) {
		max = Math.max(max, array[i]);
	}
	System.out.println(max);
}
}
