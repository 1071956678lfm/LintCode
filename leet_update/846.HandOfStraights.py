from typing import List


class Solution:
    def isNStraightHand(self, hand: List[int], W: int) -> bool:
        """
        Alice has a hand of cards, given as an array of integers.

        Now she wants to rearrange the cards into groups so that each group is size W,
        and consists of W consecutive cards.

        Return true if and only if she can.



        Example 1:

        Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
        Output: true
        Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
        Example 2:

        Input: hand = [1,2,3,4,5], W = 4
        Output: false
        Explanation: Alice's hand can't be rearranged into groups of 4.
        :param hand:
        :param W:
        :return:
        """
        arr = sorted(hand)
        if len(arr) % W != 0:
            return False
        while len(arr) != 0:
            num = arr[0]
            for i in range(1, W):
                if num + i not in arr:
                    return False
                else:
                    arr.remove(num + i)
            arr.remove(num)
        return True


ans = Solution().isNStraightHand(hand=[1], W=1)
print(ans)
