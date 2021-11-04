
public class StackImplByLinkedList {


	Node head = null;
	public void push(String data) {
		if(head == null) {
			head = new Node(data,null);
		}
		else {
			Node LastNode = getLastNode();
			LastNode.link = new Node(data,null);
		}
	}
	
	public boolean isempty() {
		if(head==null) {
			return true;
		}
		return false;
	}
	
	public String peek() {
		if(head==null) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		return getLastNode().data;
	}
	
	public String pop() {
		if(head==null) {
			System.out.println("스택이 비어있습니다.");
			return null;
		}
		Node LastNode = getLastNode();
		Node preLN = getPrevNode(LastNode);
		if(preLN==null) { //head인경우
			head=null;
		}
		else {  //head가아닌경우 이전노드의 연결을 이어줌
			preLN.link=LastNode.link;
			}
		LastNode.link=null;
		return LastNode.data;
	}
	
	public Node getPrevNode(Node target) {
		for(Node currNode=head;currNode!=null;currNode=currNode.link) {
			if(currNode.link==target) {
				return currNode;
			}
		}
		return null;
	}
	
	public Node getLastNode() {
		for(Node currNode=head;currNode!=null;currNode=currNode.link) {
			if(currNode.link==null) {
				return currNode;
			}
		}
		return null;
	}
	
	public void printList() {
		System.out.println(" L = ( ");
		for(Node currNode = head ; currNode!=null ; currNode=currNode.link) {
			System.out.print(currNode.data+ " ");
		}
		System.out.println(" ) ");
	}

}
