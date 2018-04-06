package 刷题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, // rather than
 * a nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, // if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, // if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
public class Solution {

	// @param nestedList a list of NestedInteger
	// @return a list of integer
	public List<Integer> flatten(List<NestedInteger> nestedList) {
		return Method_2(nestedList);
	}
	/*
	 * 采用非递归的方式
	 * 
	 * 若是用非递归解决这个问题会稍微复杂一点。但是好在有队列这种数据结构，可以帮助我们解决问题。
	 * 思路是这样，将原先的列表，也就是上面代码中的参数nestedList看做一个队列
	 * 当然，nestedList的头就是队列的头，尾就是队列的尾。然后依次从队列中删除元素
	 * 若删除出来的元素为整数，则直接加入结果列表result；若不是整数，做法则有点特殊：
	 * 将这个元素（肯定是个列表了）中所有子元素依次插到队列的前头
	 * 当然，还要保持顺序不变。
	 * 例如，现在删除出来的元素是[1, [2, 3]] 则将1, [2, 3]这两个元素按顺序插入队列的前端
	 * 这样做，相当于是去除了最外层的列表。然后接着删除队列首，持续上面的过程。
	 * 这样，就相当于是逐个处理，最终将所有元素的列表全部去除，并且还保持了元素顺序
	 * */
	private List<Integer> Method_2(List<NestedInteger> nestedList) {
		List<Integer> listOfInt = new LinkedList<>();
		
		LinkedList<Integer> tmpList=(LinkedList<Integer>)listOfInt;
		
		for(NestedInteger num:nestedList) {
			if(num.isInteger())
				tmpList.addFirst(num.getInteger());
			else {
				List<NestedInteger> tmp=num.getList();
				
			}
		}
		
		return listOfInt;
	}

	/**
	 * @param nestedList
	 * @return
	 */
	public List<Integer> Method_1(List<NestedInteger> nestedList) {
		List<Integer> listOfInt = new ArrayList<Integer>();
		if (nestedList == null)
			return null;
		for (NestedInteger num : nestedList) {
			if (num.isInteger()) {
				listOfInt.add(num.getInteger());
			} else {
				listOfInt.addAll(flatten(num.getList()));
			}
		}

		return listOfInt;
	}
}

class Test {
	public static void main(String[] args) {
	}
}

interface NestedInteger {
	public boolean isInteger();

	public Integer getInteger();

	public List<NestedInteger> getList();
}