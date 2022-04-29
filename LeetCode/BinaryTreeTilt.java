class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Hola");
    }
}

class Solution {
    int sum;
    public int findTilt(TreeNode root) {
        sum = 0;
        sumBranches(root);
        return sum;
    }

    private int sumBranches(TreeNode node) {
        if(node == null)
            return 0;
        int leftSum = node.left == null ? 0: sumBranches(node.left);
        int rightSum = node.right == null ? 0: sumBranches(node.right);
        int tilt = Math.abs(leftSum - rightSum);
        sum += tilt;
        return node.val + leftSum + rightSum;
    }
}

public class TreeNode {
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
