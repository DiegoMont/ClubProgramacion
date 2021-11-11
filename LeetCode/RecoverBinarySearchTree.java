class Solution {
    private TreeNode nodeOne;
    private TreeNode nodeTwo;
    private TreeNode prevValue;
    public void recoverTree(TreeNode root) {
        nodeOne = null; nodeTwo = null; prevValue = null;
        traverse(root);
        int temp = nodeOne.val;
        nodeOne.val = nodeTwo.val;
        nodeTwo.val = temp;
    }

    private void traverse(TreeNode node){
        if(node == null)
            return;
        traverse(node.left);
        if(prevValue != null){
            if(nodeOne == null){
                if(prevValue.val > node.val){
                    nodeOne = prevValue;
                    nodeTwo = node;
                }
            } else  if(node.val < nodeTwo.val)
                nodeTwo = node;
        }
        prevValue = node;
        traverse(node.right);
    }
}
