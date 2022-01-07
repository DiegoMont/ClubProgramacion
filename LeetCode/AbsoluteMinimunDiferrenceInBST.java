import java.util.LinkedList;

class Solution {
    private int minimumDifference;
    private LinkedList<Integer> orderedValues;
    public int getMinimumDifference(TreeNode root) {
        minimumDifference = Integer.MAX_VALUE;
        orderedValues = new LinkedList<>();
        inorderTraverse(root);
        return minimumDifference;
    }

    private void inorderTraverse(TreeNode node){
        if(node.left != null){
            inorderTraverse(node.left);
        }
        findDifference(node.val);
        orderedValues.add(node.val);
        if(node.right != null){
            inorderTraverse(node.right);
        }
    }

    private void findDifference(int num){
        int previousElement;
        try {
            previousElement = orderedValues.getLast();
            int nodeDifference = getDifference(previousElement, num);
            minimumDifference = (int) Math.min(minimumDifference, nodeDifference);
        } catch(Exception e){

        }
    }

    private int getDifference(int num1, int num2){
        int difference = (int) Math.abs(num1 - num2);
        return difference;
    }
}
