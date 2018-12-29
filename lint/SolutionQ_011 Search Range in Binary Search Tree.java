package Questions;

import java.util.LinkedList;
import java.util.List;

public class SolutionQ_011 {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        return searchRange(root, result, k1, k2);
    }

    private List<Integer> searchRange(TreeNode root, List<Integer> list, int k1, int k2) {
        if (root == null) {
            return list;
        }
        int tmpVal = root.val;
        if (tmpVal < k1)
            list = searchRange(root.right, list, k1, k2);
        else if (tmpVal > k2)
            list = searchRange(root.left, list, k1, k2);
        else {
            list.add(tmpVal);
            list = searchRange(root.right, list, k1, k2);
            list = searchRange(root.left, list, k1, k2);
        }
        return list;
    }

    public static void main(String[] args) {
        SolutionQ_011 solutionQ_011 = new SolutionQ_011();

    }
}
