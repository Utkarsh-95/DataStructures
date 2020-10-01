package InterviewBitTree;

import java.util.ArrayList;

public class SolutionFastest {

    public static TreeNode buildTree(ArrayList<Integer> list) {
        return buildTree(list, 0, list.size() - 1);
    }

    private static TreeNode buildTree(ArrayList<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        } else if (start == end) {
            return new TreeNode(list.get(start));
        }
        int maxIdx = findMaxIndex(list, start, end);
        TreeNode aNode = new TreeNode(list.get(maxIdx));
        aNode.left = buildTree(list, start, maxIdx - 1);
        aNode.right = buildTree(list, maxIdx + 1, end);

        return aNode;
    }

    private static int findMaxIndex(ArrayList<Integer> list, int start, int end) {
        int maxIdx = start;
        int current = list.get(start);
        for (int i = start + 1; i <= end; i++) {
            if (current < list.get(i)) {
                current = list.get(i);
                maxIdx = i;
            }
        }
        return maxIdx;
    }
}
