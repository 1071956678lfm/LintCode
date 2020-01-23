#include"header.h"

class Solution {
public:
    int GetNumberOfK(vector<int> data ,int k) {
        if(data.empty() ||
           data.front() > k || 
           data.back() < k) 
            return 0;
        
        int idxSmall = firstSmallIdx(data , k),
            idxBigger = firstBiggerIdx(data , k);
        return idxBigger - idxSmall + 1;
    }
    
    int firstSmallIdx(vector<int>& data , int k){
        int l = 0 , r = data.size() - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(data[mid] >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }
    
    int firstBiggerIdx(vector<int>& data , int k){
        int l = 0 , r = data.size() - 1;
        while(l < r ){
            int mid = l + r + 1 >> 1;
            if(data[mid] <= k) l = mid;
            else r = mid - 1;
        }
        return  l;
    }
};