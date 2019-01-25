package leet.Vacation2019_1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
//341


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
interface NestedInteger {
    /**
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    boolean isInteger();

    /**
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list
     */
    Integer getInteger();

    /**
     * @return the nested list that this NestedInteger holds, if it holds a nested list
     * Return null if this NestedInteger holds a single integer
     */
    List<NestedInteger> getList();
}

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * <p>
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,4,6].
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> ans;
    private int index = 0;
    private int size;
    public NestedIterator(List<NestedInteger> nestedList) {
        ans = new LinkedList<>();
        deal(nestedList);
        size=ans.size();
    }

    private void deal(List<NestedInteger> nestedList) {
        if (nestedList.size() == 0)
            return;
        int i = 0;
        NestedInteger nestedInteger = nestedList.get(i);
        if (nestedInteger.isInteger()) {
            ans.add(nestedInteger.getInteger());
        } else {
            deal(nestedInteger.getList());
        }
        deal(nestedList.subList(1, nestedList.size()));
    }

    @Override
    public Integer next() {
        return ans.get(index++);
    }

    @Override
    public boolean hasNext() {
        return size != index;
    }

}
