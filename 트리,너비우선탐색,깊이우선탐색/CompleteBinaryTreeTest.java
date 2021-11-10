
public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int size = 9;
		CompleteBinaryTree tree = new CompleteBinaryTree(size);
		
		for(int i=0; i<size;i++) {
			tree.add((char)(65+i)); // 아스키코드 65~ abcde 차례대로삽입
		}
		
		tree.bfs2();
	}
      /*
       *         A
       *       /   \
       *      B     C 
       *     / \   / \
       *    D   E F   G
       *   / \
       *  H   I 
       * 
       *  의 구조를 가지고있음 
       * 
       */
}
