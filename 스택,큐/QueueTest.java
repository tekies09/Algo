import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.isEmpty());
		
		queue.offer("1");
		queue.offer("2");
		queue.offer("3");
		queue.offer("4");
		queue.offer("5");
		System.out.println(queue.size());
		System.out.println(queue.peek());
		
		System.out.println(queue.size());
		
		System.out.println(queue.poll());
		
		System.out.println(queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty());
	}

}
