import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
//	static boolean[] vis;
	static Node[] node;
	static int n;
	static int lastNode=1;

	static class Node{
		int left, right;
		Node(int left, int right){
			
			this.left = left;
			this.right = right;
			
		}
	}
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		node = new Node[n+1];
//		vis = new boolean[n+1];
		
//		for(int i =0; i<=n;i++) {
//			node[i] = new Node
//		}
		
		for (int i = 1; i <=n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
//			if(lastNode==a) {
//				if(c!=-1) {
//					lastNode = c;	
//				}
//				
//			}
			node[a] = new Node(b,c);
			
		}
		inOrder(1);
		
		siinOrder(1);
	}
	static int res;
//	static int visCnt;
	static void siinOrder(int i) {
		
//		if(!vis[i]) {
//			visCnt++;
//			vis[i] = true;
//		}
		//현재 위치한 노드의 왼쪽 자식 노드가 존재하고 아직 방문하지 않았다면, 왼쪽 자식 노드로 이동한다.
		if(node[i].left!=-1) {
			res++;
			siinOrder(node[i].left);
		}
		//그렇지 않고 현재 위치한 노드의 오른쪽 자식 노드가 존재하고 아직 방문하지 않았다면, 오른쪽 자식 노드로 이동한다.
		if(node[i].right!=-1) {
			res++;
			siinOrder(node[i].right);

		}
		if(i == lastNode) 
		{
			System.out.println(res);
			return;
		}
		else {
			res++;
		}
//		if(node[i].left==-1&&)
	}
	static void inOrder(int i) {

		if(node[i].left!=-1) {
			inOrder(node[i].left);
		}
		
		lastNode = i;
		
		if(node[i].right!=-1) {
			inOrder(node[i].right);

		}

	}
	

}