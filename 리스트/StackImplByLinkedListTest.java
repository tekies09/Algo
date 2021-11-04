
public class StackImplByLinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackImplByLinkedList stack = new StackImplByLinkedList();
		
		System.out.println("--push --  hi ");
		stack.push("hi");
		stack.printList();
		System.out.println();
		
		System.out.println("--push --  hello ");
		stack.push("hello");
		stack.printList();
		System.out.println();
		
		System.out.println("--peek --   ");
		System.out.println(stack.peek());
		stack.printList();
		System.out.println();
		
		System.out.println("--pop --   ");
		System.out.println(stack.pop());
		stack.printList();
		System.out.println();
		
		System.out.println("-- empty check --   ");
		System.out.println(stack.isempty());
		System.out.println();
		
		System.out.println("--pop --   ");
		System.out.println(stack.pop());
		stack.printList();
		System.out.println();
		
		System.out.println("-- empty check --   ");
		System.out.println(stack.isempty());
		System.out.println();
	}

}
