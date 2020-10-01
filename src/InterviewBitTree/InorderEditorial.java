/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterviewBitTree;

import java.util.Stack;

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
public class InorderEditorial {

    public TreeNode getSuccessor(TreeNode a, int b) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode currentNode = a;
        while (currentNode != null || !st.isEmpty()) {
            while (currentNode != null) {
                st.push(currentNode);
                currentNode = currentNode.left;
            }

            TreeNode temp = st.pop();
            if (temp.value > b) {
                return temp;
            }
            currentNode = temp.right;

        }
        return null;

    }
    
    public static void main(String[] args) {
        InorderEditorial in = new InorderEditorial();
        TreeNode node = new TreeNode(20);
        in.getSuccessor(node, 20);
    }
}
