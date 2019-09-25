//
// Created by mac on 2019/9/18.
//
#include <vector>
#include <stack>
#include <set>
#include <string>
#include <iostream>

using namespace std;

class Solution {
public:
    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

        Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * */
    int evalRPN(vector<string> &tokens);

private:
    int evalStr(const string &str);
};

int Solution::evalRPN(vector<string> &tokens) {
    stack<int> chars;
    set<char> char_set;
    char_set.insert({'+', '-', '*', '/'});
    int ans = 0;
    int index = 0;
    do {
        string s = tokens[index];
        if (s.length() == 1) {
            char ch = s[0];
            if (ch == '+') {
                int right_operand = chars.top();
                chars.pop();
                int left_operand = chars.top();
                chars.pop();
                chars.push(int(left_operand + right_operand));
            } else if (ch == '-') {
                int right_operand = chars.top();
                chars.pop();
                int left_operand = chars.top();
                chars.pop();
                chars.push(int(left_operand - right_operand));
            } else if (ch == '*') {
                int right_operand = chars.top();
                chars.pop();
                int left_operand = chars.top();
                chars.pop();

                chars.push(int(left_operand * right_operand));
            } else if (ch == '/') {
                int right_operand = chars.top();
                chars.pop();
                int left_operand = chars.top();
                chars.pop();
                chars.push(int(left_operand / right_operand));
            } else {
                chars.push(int(ch - '0'));
            }
        } else {
            chars.push(evalStr(s));
        }

        ++index;
    } while (index < tokens.size());
    return chars.top();
}

int Solution::evalStr(const string &str) {
    int ans = 0;
    bool neg = false;
    for (int i = 0; i < str.length(); ++i) {
        if (str[i] == '-') {
            neg = true;
            continue;
        }
        int num = int(str[i] - '0');
        ans = ans * 10 + num;
    }
    return neg ? -ans : ans;
}