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

vector<string> splitss(const string &s, char delimiter) {
    vector<string> tokens;
    string token;
    istringstream tokenStream(s);
    while (getline(tokenStream, token, delimiter)) {
        tokens.push_back(token);
    }
    return tokens;
}

int solution35() {
    string s;
    cin >> s;
    auto numStrs = splitss(s.substr(1, s.length() - 2), ',');
    vector<int> vec;
    for (string tmp:numStrs) {
        vec.push_back(stoi(tmp));
    }
    int ans = 0;
    int sum = 0;
    for (int i = 1; i < vec.size(); ++i) {
        sum += vec[i];
        if (sum <= 0) {
            sum = 0;
        }
        ans = max(ans, sum);
    }
    return ans;
}

//int main() {
//    cout << solution35() << endl;
//}