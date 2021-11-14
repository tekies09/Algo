import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	char data;
	Node left;
	Node right;
	public Node(char data) {
		this.data = data;
	}
	
}
public class 트리순회 {

	static int size;
	static Node[] list;
	static StringBuilder sb1,sb2,sb3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		sb1 = new StringBuilder();
		sb2 = new StringBuilder();
		sb3 = new StringBuilder();
		StringTokenizer st;
		list = new Node[size];
		for(int n=0;n<size;n++) {
			list[n] = new Node((char)(65+n));
		}
		for(int n=0;n<size;n++) {
			st= new StringTokenizer(br.readLine());
			Node rootNode = null,leftNode,rightNode;
			char rootchar,leftchar,rightchar;
			rootchar  = st.nextToken().charAt(0);
			leftchar  = st.nextToken().charAt(0);
			rightchar = st.nextToken().charAt(0);
			for(int k=0;k<size;k++) {
				if(list[k].data==rootchar)
				{
					rootNode = list[k];
					break;
				}
			}
			
			if(leftchar !='.') {
				for(int k=0;k<size;k++) {
					if(list[k].data==leftchar)
					{
						rootNode.left = list[k];
						break;
					}
				}
			}
			if(rightchar !='.') {
				for(int k=0;k<size;k++) {
					if(list[k].data==rightchar)
					{
						rootNode.right = list[k];
						break;
					}
				}
			}
		}
		
		
		pre(list[0]);
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb3);
	}
	

	public static void pre(Node index) {
		sb1.append(index.data);
		if(index.left!=null) pre(index.left);
		sb2.append(index.data);
		if(index.right!=null) pre(index.right);
		sb3.append(index.data);
	}

}
