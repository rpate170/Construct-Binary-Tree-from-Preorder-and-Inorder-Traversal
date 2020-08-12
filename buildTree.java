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
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return constructTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
    }
    
    public TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        // System.out.println("*************************");
        // System.out.println("inRoot: " + inRoot);
        // System.out.println("preStart: " + preStart);
        // System.out.println("inStart: " + inStart);
        // System.out.println("preEnd: " + preEnd);
        // System.out.println("inEnd: " + inEnd);
        // System.out.println("*************************");
        
        root.left = constructTree(preorder, preStart + 1, preStart + inRoot - inStart, inorder, inStart, inRoot - 1, map);
        root.right = constructTree(preorder, preStart + inRoot - inStart + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        
        return root;
    }
    
}
