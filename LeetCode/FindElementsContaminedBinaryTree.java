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

class FindElements {

    private HashSet<Integer> treeValues;

    public FindElements(TreeNode root) {
        this.treeValues = new HashSet<>();
        root.val = 0;
        cleanChildren(root);
    }
    
    public boolean find(int target) {
        return this.treeValues.contains(target);
    }

    private void cleanChildren(TreeNode parent) {
        this.treeValues.add(parent.val);
        if(parent.left != null) {
            parent.left.val = parent.val * 2 + 1;
            cleanChildren(parent.left);
        }
        if(parent.right != null) {
            parent.right.val = parent.val * 2 + 2;
            cleanChildren(parent.right);
        }
    }
}