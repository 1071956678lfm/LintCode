#include<vector>
#include<iostream>
#include <cmath>

using namespace std;

// 最大质因数获取
//对于给定的字符序列，从左至右将所有的数字字符取出拼接成一个无符号整数（字符序列长度小于100，拼接出的整数小于2^31,），计算并输出该整数的最大素因子（如果是素数，则其最大因子为自身）
class Solution {
public:
    void run() {
        int N;
        std::cin >> N;
        vector<string> inputs;
        for (int i = 0; i < N; ++i) {
            string cur;
            std::cin >> cur;
            inputs.push_back(cur);
        }
        vector<int> vecs(N, 0);
        for (int i = 0; i < N; ++i) {
            vecs[i] = str2int(inputs[i]);
        }
        for (auto num : vecs) {
            cout << getFactor(num) << endl;
        }
    }

    // 快速质因数分解
    int getFactor(int num) {
        if (0 == num) return num;
        int ans = 0;
        for (int tmp = 2; tmp <= sqrt(1.0 * num); ++tmp) {
            while (num % tmp == 0) {
                ans = tmp;
                num /= tmp;
            }
            //因子全部除完了
            if (num == 1)break;
        }
        //仅有两个因子, 自己和1
        if (num != 1) {
            ans = num;
        }
        return ans;
    }

    int str2int(const string &s) {
        int ans = 0;
        for (char ch : s) {
            if (ch >= '0' && ch <= '9') {
                int val = ch - '0';
                ans *= 10;
                ans += val;
            }
        }
        return ans;
    }
};


int main() {
    auto S = Solution();
    S.run();
};