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
public class InorderFast {

    public TreeNode getSuccessor(TreeNode a, int b) {
        if (a == null) {
            return null;
        }
        TreeNode itr = a;
        TreeNode an = null;
        while (itr != null) {
            if (itr.value == b) {
                break;
            } else if (itr.value > b) {
                an = itr;
                itr = itr.left;
            } else {
                itr = itr.right;
            }
        }
        if (itr.right != null) {
            itr = itr.right;
            while (itr.left != null) {
                itr = itr.left;
            }
            return itr;
        }
        return an;
    }
}
