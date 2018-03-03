package À¢Ã‚;

import java.util.LinkedList;
import java.util.List;

public class SolutionQ_068 {
	/*
	 * @param root: A Tree
	 * 
	 * @return: Preorder in ArrayList which contains node values.
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> preOrder = new LinkedList<>();
		if (root == null)
			return preOrder;
		preOrder.addAll(postorderTraversal(root.left));
		preOrder.addAll(postorderTraversal(root.right));
		preOrder.add(root.val);
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