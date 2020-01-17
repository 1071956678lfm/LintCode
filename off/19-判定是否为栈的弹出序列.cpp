#include"header.h"

class Solution {
private:
    stack<int> st;
public:
    bool IsPopOrder(vector<int> in, vector<int> out) {
        int n = in.size();
        int idx_in = 0, idx_out = 0;
        while (idx_in <= n && idx_out < n) {
            while (!st.empty()) {
                if (st.top() == out[idx_out]) {
                    ++idx_out;
                    st.pop();
                } else {
                    break;
                }
            }
            if (idx_out >= n) break;
            while (idx_in < n && in[idx_in] != out[idx_out]) {
                st.push(in[idx_in++]);
            }
            if (idx_in > n) break;
            st.push(in[idx_in++]);
        }

        return st.empty();
    }
};