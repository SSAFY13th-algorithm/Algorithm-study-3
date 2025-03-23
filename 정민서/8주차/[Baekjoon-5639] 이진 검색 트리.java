import java.util.*;
import java.io.*;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {

    static Node root;

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws IOException{

        root = new Node(Integer.parseInt(br.readLine()));

        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            insert(root, Integer.parseInt(input));
        }

        postorder(root);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void insert(Node node, int value) {

        if( value < node.value) {

            if (node.left == null) {
                node.left = new Node(value);
            } else {
                insert(node.left, value);
            }
        } else {

            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insert(node.right, value);
            }
        }
    }

    static void postorder(Node node) {

        if (node == null) {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value).append("\n");

    }

}
