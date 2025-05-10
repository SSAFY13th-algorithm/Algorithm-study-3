import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ5639 {
	static class Node {
		int num;
		Node lchild;
		Node rchild;

		public Node(int num) {
			this.num = num;
			lchild = rchild = null;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Node root = new Node(Integer.parseInt(br.readLine()));

		Stack<Node> stack = new Stack<>();

		while (true) {
			String s = br.readLine();
			if (s == null || s.equals("")) // 입력 종료 처리
				break;

			if (stack.isEmpty()) {
				stack.push(root);
			}

			Node tmp = new Node(Integer.parseInt(s));

			if (stack.peek().num > tmp.num) { // 다음 출력되는 수가 현재 수보다 작다면
				stack.peek().lchild = tmp; // 왼쪽자식으로 저장
				stack.push(tmp);
			} else { // 크다면
				Node parent = null;
				while (!stack.isEmpty() && stack.peek().num < tmp.num) { // 그 노드의 적절한 위치 탐색
					parent = stack.pop();
				}
				parent.rchild = tmp; // 오른쪽 자식으로 저장
				stack.push(tmp);
			}
		}

		print(root);
	}

	public static void print(Node n) { // 후위순회
		if (n == null) {
			return;
		}
		print(n.lchild);
		print(n.rchild);
		System.out.println(n.num);
	}

}
