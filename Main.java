import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode next;

  TreeNode(int val) {
    this.val = val;
    left = right = next = null;
  }
};

class Main {

  // Problem Statement #
  // Given a binary tree and a node, find the level order successor of the given
  // node in the tree. The level order successor is the node that appears right
  // after the given node in the level order traversal.

  private static void connect(TreeNode root) {
    if (root == null)
      return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();

      TreeNode prevNode = null;
      for (int i = 0; i < size; i++) {
        TreeNode currentNode = queue.poll();
        if (prevNode != null)
          prevNode.next = currentNode;
        prevNode = currentNode;
        // insert the children of current node to the queue
        if (currentNode.left != null)
          queue.add(currentNode.left);
        if (currentNode.right != null)
          queue.add(currentNode.right);
      }
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    Main.connect(root);

  }
}