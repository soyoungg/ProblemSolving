import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    char data;
    Node left;
    Node right;

    Node(char data){
        this.data = data;
    }
}

class Tree {
    Node root;

    public void createNode(char data, char leftData, char rightData) {
        if (root == null) {
            root = new Node(data);
            if (leftData != '.') {
                root.left = new Node(leftData);
            }
            if (rightData != '.') {
                root.right = new Node(rightData);
            }
        } else {
            searchNode(root, data, leftData, rightData);
        }
    }

    public void searchNode(Node node, char data, char leftData, char rightData) {
        if (node == null) {
            return;
        }
        if (node.data == data) {
            if (leftData != '.') {
                node.left = new Node(leftData);
            }
            if (rightData != '.') {
                node.right = new Node(rightData);
            }
        } else {
            searchNode(node.left, data, leftData, rightData);
            searchNode(node.right, data, leftData, rightData);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            if (node.left != null)
                preOrder(node.left);
            if (node.right != null)
                preOrder(node.right);
        }
    }


    public void inOrder(Node node) {
        if(node != null) {
            if(node.left != null)
                inOrder(node.left);
            System.out.print(node.data);
            if(node.right != null)
                inOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if(node != null) {
            if(node.left != null)
                postOrder(node.left);
            if(node.right != null)
                postOrder(node.right);
            System.out.print(node.data);
        }
    }
}
public class BJ1991_트리순회{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Tree tree = new Tree();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            char a = st.nextToken().charAt(0);
            char b = st.nextToken().charAt(0);
            char c = st.nextToken().charAt(0);

            tree.createNode(a, b, c);
        }

        tree.preOrder(tree.root);
        System.out.println();

        tree.inOrder(tree.root);
        System.out.println();

        tree.postOrder(tree.root);
    }
}




