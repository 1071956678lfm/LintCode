package lint

��;

import java.util.LinkedList;
import java.util.List;

public class SolutionQ_066 {
	/*
	 * @param root: A Tree
	 * 
	 * @return: Preorder in ArrayList which contains node values.
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		LinkedList<Integer> preOrder = new LinkedList<>();
		if (root == null)
			return preOrder;
		preOrder.add(root.val);
		preOrder.addAll(preorderTraversal(root.left));
		preOrder.addAll(preorderTraversal(root.right));
		
		return preOrder;

	}
}

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}