public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        Node result1 = solution.connect(root1);
        System.out.println("Output:");
        printTree(result1);

        assert result1.next == null;
        assert result1.left.next == result1.right;
        assert result1.left.left.next == result1.left.right;
        assert result1.left.right.next == result1.right.left;
        assert result1.right.left.next == result1.right.right;

        // Test Case 2
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        Node result2 = solution.connect(root2);
        System.out.println("Output:");
        printTree(result2);

        assert result2.next == null;
        assert result2.left.next == result2.right;

        // Test Case 3
        Node root3 = new Node();

        Node result3 = solution.connect(root3);
        System.out.println("Output:");
        printTree(result3);// should be 0 because int default value is 0

        assert result3.next == null;
    }

    // Helper method to print the connected tree
    private static void printTree(Node root) {
        if (root == null)
            return;

        Node currLevel = root;
        while (currLevel != null) {
            Node curr = currLevel;
            while (curr != null) {
                System.out.print(curr.val);
                if (curr.next != null)
                    System.out.print(" -> ");
                curr = curr.next;
            }
            System.out.println();
            currLevel = currLevel.left;
        }
    }
}
