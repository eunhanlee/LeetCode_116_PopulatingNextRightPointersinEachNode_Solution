class Solution {
    /**
     * Connects the right pointers of each node in the given binary tree.
     *
     * @param root The root node of the binary tree.
     * @return The root node of the connected binary tree.
     */
    public Node connect(Node root) {
        if (root == null)
            return null;

        // The leftmost node in the current level
        Node levelStart = root;

        while (levelStart.left != null) {
            // The current node
            Node curr = levelStart;

            while (curr != null) {
                // Set the next pointer of the current node's left child to its right child
                curr.left.next = curr.right;
                // Set the next pointer of the current node's right child to the left child of the next node
                if (curr.next != null) curr.right.next = curr.next.left;
                // Move to the next node in the level
                curr = curr.next;
            }

            // Move to the leftmost node of the next level
            levelStart = levelStart.left;
        }

        return root;
    }
}
