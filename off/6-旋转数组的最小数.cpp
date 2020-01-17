#include"header.h"

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。——左移
//输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
//例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
//NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
class Solution {
public:
    int minNumberInRotateArray(vector<int> nums) {
        if (nums.empty()) return 0;

        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] > nums.back()) l = mid + 1;
            else r = mid;
        }

        return nums[l];
    }
};