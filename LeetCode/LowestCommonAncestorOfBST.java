class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int minValue = Math.min(p.val, q.val);
        int maxValue = Math.max(p.val, q.val);
        return lca(root, minValue, maxValue
    }

    private TreeNode lca(TreeNode node, int min, int max){
        if(min <= node.val && node.val <= max)
            return node;
        else if(max < node.val)
            return lca(node.left, min, max);
        else
            return lca(node.rigth, min, max);
    }
}
