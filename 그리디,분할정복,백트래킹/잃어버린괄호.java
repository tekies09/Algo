package Greedy;

import java.io.*;
import java.util.*;

public class 잃어버린괄호 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		int sum=0;

		String number="";
		int curnum = 0;
		boolean minuseflag = false;
		boolean firstflag = false;
		for(int i=0;i<line.length();i++) {
			char cur = line.charAt(i);
			if(cur-'0'>=0 && cur-'0'<10) {
				number = ""+ number+cur;
			}
			else {
				if(!firstflag) { //첫번째가 들어왔을때 
					sum += Integer.parseInt(number);
					firstflag= true;
					
					if(cur=='-') {
						minuseflag= true;
					}
					number="";
					continue;
				}
				
				if(!minuseflag) {
					sum += Integer.parseInt(number);
					if(cur=='-') {
						minuseflag = true;
					}
				}
				else {
					sum -= Integer.parseInt(number);
				}
				number="";
			}
		}
		
		if(!minuseflag) {
			sum += Integer.parseInt(number);
		}
		else {
			sum -= Integer.parseInt(number);
		}
		
		
		System.out.println(sum);
	}

}
