package leet.Solution2019_2;

import java.util.HashMap;
import java.util.Map;

//138
public class CopyList {

    private class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    /**
     * A linked list is given such that each node
     * contains an additional random pointer which could point to any node in the list or null.
     * <p>
     * Return a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        for (RandomListNode ptr = head; ptr != null; ptr = ptr.next)
            map.put(ptr, new RandomListNode(ptr.label));
        for (RandomListNode ptr = head; ptr != null; ptr = ptr.next) {
            map.get(ptr).next = map.get(ptr.next);
            map.get(ptr).random = map.get(ptr.random);
        }
        return map.get(head);
    }

}

