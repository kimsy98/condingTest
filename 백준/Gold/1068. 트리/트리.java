import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] parent;
	static int delNode;
	static List<Integer>[] Node;
	static int leafNum;
//	static boolean[] vis;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		parent = new int[n];
		Node = new List[n];
		int root=-1;
//		vis = new boolean[n];
		
		for(int i =0; i<n;i++) {
			Node[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i <n; i++) {
			int parentNode = Integer.parseInt(st.nextToken());
			if(parentNode==-1) root = i;
			parent[i] = parentNode;
		}
		
		delNode = Integer.parseInt(br.readLine());

		if(delNode==root) {
			System.out.println(0);
			return;
		}
		
		for(int i = n-1; i>=0; i--) {
			int idx = parent[i];
			while(true){

				//부모 노드가 delNode일때
				if(idx==delNode) {
					parent[i] = -1;
					break;
				}
				//현재노드가 delNode일때
				if(i==delNode) {
					parent[i] = -1;
					break;
				}
				//삭제되는 노드가 아닐때 끝까지 올라가므로
				if(idx==-1||idx==root)break;
				else idx = parent[idx];
			}
		}
		

		
//		System.out.println(Arrays.toString(parent));
		
		for(int i = n-1; i>=0; i--) {
			if(parent[i]==-1) continue;
			Node[parent[i]].add(i);
		}

		dfs(root);
		System.out.println(leafNum);
	}
	static void dfs(int idx) {
		if(Node[idx].size()==0) {
			leafNum++;
			return;
		}
		for(int i=0; i<Node[idx].size();i++) {
			dfs(Node[idx].get(i));
		}
	}

}