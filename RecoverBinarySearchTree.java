/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Time Complexity: O(n)
// Space Complexity: O(maxDepth)
class Solution {
    TreeNode first = null, middle = null, last = null, prev = null;

    public void recoverTree(TreeNode root) {
        if(root == null) {
            return ;
        }

        helper(root);

        if(first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if(first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    private void helper(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode top = stack.pop();

            if(prev != null && top.val < prev.val) {
                if(first != null) {
                    last = top;
                } else {
                    first = prev;
                    middle = top;
                }
            }
            prev = top;
            root = top.right;
        }
    }
}