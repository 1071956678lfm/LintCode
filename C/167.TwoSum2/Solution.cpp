//
// Created by mac on 2019/9/16.
//

#include <vector>

using namespace std;

class Solution {
public:
    /**
     * Given an array of integers that is already sorted in ascending order,
     * find two numbers such that they add up to a specific target number.
        The function twoSum should return indices of the two numbers such that they add up to the target,
         where index1 must be less than index2.
     * */
    vector<int> twoSum(vector<int> &numbers, int target);
};

vector<int> Solution::twoSum(vector<int> &numbers, int target) {
    int n = numbers.size();
    int begin = 0, end = n - 1;
    bool found = false;
    vector<int> ans;
    while (!found && begin < end) {
        if (numbers[begin] + numbers[end] == target) {
            found = true;
            ans.push_back(begin + 1);
            ans.push_back(end + 1);
        } else if (numbers[begin] + numbers[end] > target) {
            --end;
        } else {
            ++begin;
        }
    }
    return ans;
}