import java.util.Stack;
public class STACK {
public static void main(String[] args) {
	
	Stack<String> stack  = new Stack<String>();
	
	System.out.println(stack.isEmpty()+"/"+stack.size());
	
	
	stack.push("GG");
	stack.push("G1G");
	stack.push("G2G");
	stack.push("G3G");
	System.out.println(stack.isEmpty()+"/"+stack.size());
	
	
	stack.pop();
	stack.pop();
	System.out.println(stack.isEmpty()+"/"+stack.size());
}
}
