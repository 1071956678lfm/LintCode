//
// Created by mac on 2019/9/21.
//
#include <iostream>
#include <string>
#include <cctype>
#include <vector>
#include <map>

#define max(x, y) ((x)<(y)?(y):(x))
#define min(x, y) ((x)>(y)?(y):(x))

#define EXP '^'
#define ADD '+'
using namespace std;

map<int, int> poly2intArr(const string &poly);

vector<pair<int, int>> polyAdd(const string &p1, const string &p2);
// 3x^4 + 4x^3 + 7x^0 + 12x^4
// 4x^0 + 10x^3
void solutionpoly() {
    string poly_1, poly_2;
    //read into
    char *ss = new char[1024];
    cin.getline(ss, 1024);
    poly_1 = ss;
    cin.getline(ss, 1024);
    poly_2 = ss;
    auto m = polyAdd(poly_1, poly_2);
    int n = m.size();
    string s;

    for (auto it = 0; it < n - 1; ++it) {
        cout << m[it].second << "x^" << m[it].first << " + ";
    }
    cout << m[n - 1].second << "x^" << m[n - 1].first;
}

map<int, int> poly2intArr(const string &poly) {
    bool isExp = false;
    map<int, int> ans;
    string xi, exp;
    for (int i = 0; i < poly.length(); ++i) {
        if (!isExp && isnumber(poly[i])) {
            xi = xi + poly[i];
        } else if (poly[i] == 'x') {
            ++i;
            isExp = true;
        } else if (isblank(poly[i])) {
            isExp = false;
            //skip  +
            i += 2;
            ans[stoi(exp)] += stoi(xi);
            exp = string();
            xi = string();
        } else if (isExp && isnumber(poly[i])) {
            exp = exp + poly[i];
        }
    }
    ans[stoi(exp)] += stoi(xi);
    return ans;
}

vector<pair<int, int>> polyAdd(const string &p1, const string &p2) {
    map<int, int> map1 = poly2intArr(p1), map2 = poly2intArr(p2);
    map<int, int> resultMap;
    for (auto &it : map1) {
        int first = it.first, second = it.second;
        map2[first] +=
                second;
    }
    vector<pair<int, int>> vecMap;

    vecMap.reserve(map2.size());
    for (auto &it:map2) {
        vecMap.emplace_back(it.first, it.second);
    }
    sort(vecMap.begin(), vecMap.end(), [](const pair<int, int> &p1, const pair<int, int> &p2) -> bool {
        return p2.first - p1.first;
    });

    return vecMap;
}

//int main() {
//    solutionpoly();
//    return 0;
//}