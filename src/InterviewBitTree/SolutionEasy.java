package InterviewBitTree;

import java.util.ArrayList;

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SolutionEasy {

    public TreeNode tree(ArrayList<Integer> A, int start, int end) {
        if (end < start) {
            return null;
        }
        int max = Integer.MIN_VALUE, maxidx = -1;
        for (int i = start; i <= end; i++) {
            if (A.get(i) > max) {
                max = A.get(i);
                maxidx = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = tree(A, start, maxidx - 1);
        root.right = tree(A, maxidx + 1, end);
        return root;
    }

    public TreeNode buildTree(ArrayList<Integer> A) {
        TreeNode root = tree(A, 0, A.size() - 1);
        return root;
    }
}
