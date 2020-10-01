/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterviewBitTree;

/**
 *
 * @author Utkarsh Pratap Singh
 */

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class InorderSuccessorLight {

    public TreeNode getSuccessor(TreeNode root, int b) {
        TreeNode itr = root;
        TreeNode ans = null;
        while (itr.value != b) {
            if (b > itr.value) {
                itr = itr.right;
            } else {
                ans = itr;
                itr = itr.left;
            }
        }
        if (itr.right != null) {
            itr = itr.right;
            while (itr.left != null) {
                itr = itr.left;
            }
            return itr;
        } else {
            return ans;
        }
    }
}
