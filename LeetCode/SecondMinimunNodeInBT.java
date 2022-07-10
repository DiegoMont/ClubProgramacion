import java.util.HashSet;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private HashSet<Integer> set;
    private int smallest;
    private int secondSmallest;

    public int findSecondMinimumValue(TreeNode root) {
        set = new HashSet<>();
        smallest = root.val;
        secondSmallest = -1;
        traverseTree(root);
        return secondSmallest;
    }

    private void traverseTree(TreeNode root) {
        boolean wasAdded = set.add(root.val);
        if(wasAdded && root.val > smallest && (root.val < secondSmallest || secondSmallest == -1))
            secondSmallest = root.val;
        if(root.left == null)
            return;
        traverseTree(root.left);
        traverseTree(root.right);
    }
}