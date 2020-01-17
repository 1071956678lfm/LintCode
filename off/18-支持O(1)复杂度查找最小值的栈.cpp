#include"header.h"
class Solution {
private:
    stack<int> sk;
    stack<int> minSk;
public:
    void push(int value) {
        sk.push(value);
        if(minSk.empty() || minSk.top() >= value) minSk.push(value);
    }
    void pop() {
        int min = minSk.top();
        if(min == sk.top()){
            minSk.pop();
        }        
        sk.pop();
    }
    int top() {
        return sk.top();
    }
    int min() {
        return minSk.top();
    }
};