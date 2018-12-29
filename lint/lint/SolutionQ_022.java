package lint

��;

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
	 * ���÷ǵݹ�ķ�ʽ
	 * 
	 * �����÷ǵݹ�������������΢����һ�㡣���Ǻ����ж����������ݽṹ�����԰������ǽ�����⡣
	 * ˼·����������ԭ�ȵ��б�Ҳ������������еĲ���nestedList����һ������
	 * ��Ȼ��nestedList��ͷ���Ƕ��е�ͷ��β���Ƕ��е�β��Ȼ�����δӶ�����ɾ��Ԫ��
	 * ��ɾ��������Ԫ��Ϊ��������ֱ�Ӽ������б�result���������������������е����⣺
	 * �����Ԫ�أ��϶��Ǹ��б��ˣ���������Ԫ�����β嵽���е�ǰͷ
	 * ��Ȼ����Ҫ����˳�򲻱䡣
	 * ���磬����ɾ��������Ԫ����[1, [2, 3]] ��1, [2, 3]������Ԫ�ذ�˳�������е�ǰ��
	 * ���������൱����ȥ�����������б�Ȼ�����ɾ�������ף���������Ĺ��̡�
	 * ���������൱��������������ս�����Ԫ�ص��б�ȫ��ȥ�������һ�������Ԫ��˳��
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