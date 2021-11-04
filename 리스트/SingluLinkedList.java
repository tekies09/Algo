
public class SingluLinkedList {

	
	private Node head;
	//첫번째 노드로 삽입하기
	
	public void addFirstNode(String data){
		Node newNode = new Node(data, head);
		head = newNode;
	}
	
	//탐색후 마지막 노드 가져오기
	public Node getLastNode() {
		for(Node currNode=head; currNode !=null; currNode=currNode.link) {
			if(currNode.link==null) { //마지막노드라면
				return currNode;
			}
		}
		return null;
	}
	
	//마지막 노드 삽입하기
	public void addLastNode(String data) {
		if(head==null) { // 리스트가 비어있는경우
			addFirstNode(data);
			return;
		}
		Node lastNode = getLastNode(); //마지막노드가져오기
		Node newNode  = new Node(data); // 적용할 나의 새 노드 생성
		lastNode.link = newNode; //마지막노드의 링크를 연결하는과정 
	}
	//중간노드삽입하기
	
	public void insertAfterNode(Node preNode,String data) {
		if(preNode==null) {
			System.out.println("이전노드가 없어서 삽입불가");
			return;
		}
		
		Node afterNode = preNode.link;
		Node newNode = new Node(data);
		preNode.link = newNode;
		newNode.link = afterNode;
		/* 좀더축약해서 2줄로가능
		 *  Node newNode = new Node(data ,preNode.link);
		 *  preNode.link= newNode; 
		 */
		
	}
	//data를 데이터락조깅ㅆ는 처음만나는 노드 리턴하기 
	public Node getNode(String data) {
		for(Node currNode = head ; currNode!=null ; currNode=currNode.link) {
			if(currNode.data.equals(data)) {
				return currNode;
			}
		}
		return null;
	}
	
	//target의 이전노드찾기
	public Node getPreviousNode(Node target) {
		for(Node currNode = head ; currNode!=null ; currNode=currNode.link) {
			if(currNode.link.equals(target)) {
				return currNode;
			}
		}
		return null;
	}
	
	
	//data를 갖고있는 노드 찾아 삭제 
	public void deleteNode(String data) {
		Node targetNode =getNode(data);
		if(targetNode ==null) {
			System.out.println("삭제할 노드 존재 X");
			return;
		}
		Node preNode = getPreviousNode(targetNode);
		if(preNode ==null) // target 이 head인경우
		{
		head = targetNode.link;	
		}else { //target이 head가 아닌경우
			preNode.link = targetNode.link;
		}	
		targetNode.link=null;
	}
	
	public void printList() {
		System.out.println(" L = ( ");
		for(Node currNode = head ; currNode!=null ; currNode=currNode.link) {
			System.out.print(currNode.data+ " ");
		}
		System.out.println(" ) ");
	}
}
