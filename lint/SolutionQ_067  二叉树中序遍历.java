package À¢Ã‚;

import java.util.LinkedList;
import java.util.List;

public class SolutionQ_067 {
	/*
	 * @param root: A Tree
	 * 
	 * @return: Preorder in ArrayList which contains node values.
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		LinkedList<Integer> preOrder = new LinkedList<>();
		if (root == null)
			return preOrder;
		preOrder.addAll(inorderTraversal(root.left));
		preOrder.add(root.val);
	
		preOrder.addAll(inorderTraversal(root.right));
		
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