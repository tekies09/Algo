
public class SingluLinkedListTest {
public static void main(String[] args) {
	SingluLinkedList list = new SingluLinkedList();
	
	list.addLastNode("1번");
	System.out.println(list.getLastNode());
	list.addFirstNode("0번");
	list.printList();
	System.out.println();
	list.addFirstNode("-1번");
	list.printList();
	System.out.println();
	
	list.insertAfterNode(list.getNode("0번"), "0.5번");
	list.printList();
	System.out.println();
	
	list.deleteNode("0.5번");
	list.printList();
	System.out.println();
	
	System.out.println(list.getPreviousNode(list.getNode("0번")));
}
}
