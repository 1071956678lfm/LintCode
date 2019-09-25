//
// Created by mac on 2019/9/21.
//

#include <iostream>
#include <algorithm>
#include <cmath>
#include <cctype>
#include <sstream>
#include <vector>

using namespace std;

vector<string> split36(const string &s, char delimiter) {
    vector<string> tokens;
    string token;
    istringstream tokenStream(s);
    while (getline(tokenStream, token, delimiter)) {
        tokens.push_back(token);
    }
    return tokens;
}

void solution36() {
    int num = 0;
    cin >> num;
    auto nums = new int[num];
    for (int i = 0; i < num; ++i) {
        cin >> nums[i];
    }
    //solve
//    int maxEnd = nums[0];
//    int minEnd = nums[0];
//    int ans = nums[0];
//    for (int j = 0; j < num; ++j) {
//        int end1 = maxEnd * nums[j],
//                end2 = minEnd * nums[j];
//        maxEnd = max(max(end1, end2), nums[j]);
//        minEnd = min(min(end1, end2), nums[j]);
//        ans = max(maxEnd, minEnd);
//    }
    pair<int, int> ans;
    int maxResult = nums[0];
    for (int i = 0; i < num; i++) {
        double x = 1;
        for (int j = i; j < num; j++) {
            x *= nums[j];
            if (x > maxResult) {
                maxResult = x;
                ans.first = i;
                ans.second = j;
            }
        }
    }
    cout << '[' << nums[ans.first] << ',' << nums[ans.second] << ']';
}

//int main() {
//    solution36();
//    return 0;
//}