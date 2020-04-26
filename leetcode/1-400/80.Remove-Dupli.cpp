#include "header.h"
class Solution
{
public:
    int removeDuplicates(vector<int> &nums)
    {
        int i = 0 ;
        for(int j = 0 ; j < nums.size(); ++j){
            // It means that if nums[j] == nums[i - 2] , the idx i should hold on and j move as usual 
            // Until nums[j] != nums[i - 2] , and then replace nums[i] with nums[j].
            // In this way , nums[i - 2] and nums[i - 1] is the same element , while nums[i] != nums[i - 1]
            if(i < 2 || nums[j] > nums[i - 2]) nums[i++] = nums[j];
        }
        return i;
    }
};