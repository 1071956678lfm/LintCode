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
#define ORT "ORT"       //普通直角三角形
#define LRT "LRT"       //等腰直角三角形
#define OIT "OIT"       //普通等腰三角形
#define ET "ET"         //等边三角形
#define OT "OT"         //普通三角形
#define NT "NT"         //不能形成三角形


//获取长度
double getDistance(const pair<int, int> &vec) {
    return sqrt(vec.first * vec.first +
                vec.second * vec.second);
}

pair<int, int> points2vec(const pair<int, int> &p1, const pair<int, int> &p2) {
    int a = p2.first - p1.first;
    int b = p2.second - p1.second;
    return pair<int, int>(a, b);
}

int vecMul(const pair<int, int> &p1, const pair<int, int> &p2) {
    return p1.first * p2.first +
           p1.second * p2.second;
}

vector<string> splits(const string &s, char delimiter) {
    vector<string> tokens;
    string token;
    istringstream tokenStream(s);
    while (getline(tokenStream, token, delimiter)) {
        tokens.push_back(token);
    }
    return tokens;
}

string solution34() {
    string s;
    cin >> s;
    s = s.substr(1, s.length() - 2);
    auto strings = splits(s, ',');
    pair<int, int> v1 = pair<int, int>(stoi(strings[0]), stoi(strings[1]));
    pair<int, int> v2 = pair<int, int>(stoi(strings[2]), stoi(strings[3]));
    pair<int, int> v3 = pair<int, int>(stoi(strings[4]), stoi(strings[5]));

    //get vectors
    pair<int, int> a = points2vec(v1, v2);
    pair<int, int> b = points2vec(v2, v3);
    pair<int, int> c = points2vec(v3, v1);

    double lenA = getDistance(a);
    double lenB = getDistance(b);
    double lenC = getDistance(c);

    if (lenA + lenB <= lenC || lenA + lenC <= lenA) {
        return NT;
    }

    if (lenA == lenB && lenA == lenC) {
        return ET;
    }
    //Two of the dis is equal.
    if (lenA == lenB || lenA == lenC || lenB == lenC) {
        if (vecMul(a, b) * vecMul(b, c) * vecMul(c, a) == 0) {
            return LRT;
        } else {
            return OIT;
        }
    }
    if (vecMul(a, b) * vecMul(b, c) * vecMul(c, a) == 0) {
        return ORT;
    }
    return OT;
}

//int main() {
//    string s = solution34();
//    cout << s << endl;
//    return 0;
//}