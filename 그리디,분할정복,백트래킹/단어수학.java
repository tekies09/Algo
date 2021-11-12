package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class wordValue implements Comparable<wordValue>{
	int value;
	char alpha;
	public wordValue(int value, char alpha) {
		this.value = value;
		this.alpha = alpha;
	}

	@Override
	public int compareTo(wordValue o) {
		// TODO Auto-generated method stub
		if(this.value <o.value) return 1;
		return -1;
	}
	
	
}
public class 단어수학 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k= Integer.parseInt(br.readLine()); 
		String[] wordlist = new String[k];

		
		int[] values = new int[26];
		int[] alpha = new int[26];
		
		for(int i=0;i<26;i++) {
			values[i] = 0;
			alpha[i] = -1;
		}
		
		
		for(int i=0;i<k;i++) {
			wordlist[i] = br.readLine();
		}
		//여기까지문제없음
		
		
		for(int i=0;i<k;i++) {
			String a = wordlist[i];
			int pow = a.length()-1;
			for(int j=0;j<a.length();j++) {
				int alp = a.charAt(j)-65;
				values[alp] = values[alp] + (int) Math.pow(10,pow-j);
			}
		}
		
		
		
		
		int count=0;
		for(int i=0;i<26;i++) {
			if(values[i]==0) continue;
			count++;
		}
		wordValue[] wv = new wordValue[count];
		count=0;
		for(int i=0;i<26;i++) {
			if(values[i]==0) continue;
			char a = (char) (i+65);
			wv[count] = new wordValue(values[i],a);
			count++;
		}
		
		Arrays.sort(wv);
		
		int start = 9;
		for(int i=0;i<wv.length;i++) {
			int number = wv[i].alpha-65;
			alpha[number]=start;
			start--;
		}
		
		
		
		
		
		
		int sum=0;
		for(int i=0;i<k;i++) {
			String a = wordlist[i];
			int pow = a.length()-1;
			for(int j=0;j<a.length();j++) {
				int alp = a.charAt(j)-65;
				sum = sum + alpha[alp]*(int) Math.pow(10,pow-j);
			}
		}
		System.out.println(sum);
		
		
	}

}
