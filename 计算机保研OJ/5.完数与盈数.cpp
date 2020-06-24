#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>

using namespace std;

vector<int> getFactors(int num) {
    vector<int> ans;
    if (0 == num) return vector<int>();
    for (int factor = 2; factor <= num / 2; ++factor) {
        if (num % factor == 0 && num != factor) ans.push_back(factor);
    }
    ans.push_back(1);
    return ans;
};


int main() {
    int l = 2, r = 60;
    vector<int> wanNums, yingNums;
    for (int i = l; i <= r; ++i) {
        auto vec = getFactors(i);
        int sum = 0;
        for (auto num : vec) sum += num;
        if (sum == i) wanNums.push_back(i);
        else if (sum > i) yingNums.push_back(i);
    }
    cout << "E: ";
    for (auto num : wanNums) cout << num << ' ';
    cout << "G: ";
    for (auto num : yingNums) cout << num << ' ';
}