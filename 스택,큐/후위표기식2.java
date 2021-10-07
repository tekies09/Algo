import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 후위표기식2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   StringBuilder sb = new StringBuilder();
		   
		   Stack<Double> s = new Stack<Double>();
		   int ntype = Integer.parseInt(br.readLine());
		   Double[] numbers = new Double[ntype];
		   String line = br.readLine();
		   
		   for(int i=0;i<ntype;i++) {
			   numbers[i] =  Double.parseDouble(br.readLine());
		   }
		   double total = 0;
		   for(int i=0;i<line.length();i++) {
			   char c = line.charAt(i);
			   if(c=='*' || c=='+' || c=='/' || c=='-') {
				   Double snum = s.pop();
				   Double fnum = s.pop();
				   if(c=='*') {
					   total = fnum*snum;
				   }
				   if(c=='+') {
					   total = fnum+snum;
				   }
				   if(c=='/') {
					   total = fnum/snum;
				   }
				   if(c=='-') {
					   total = fnum-snum;
				   }
				   s.push(total);
			   }
			   else {
				   s.push(numbers[c-'A']);
			   }
		   }
		   System.out.format("%.2f",s.peek());
	}

}
