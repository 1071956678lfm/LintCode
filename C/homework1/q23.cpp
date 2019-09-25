////
//// Created by mac on 2019/9/20.
////
//#include <iostream>
//#include <string>
//
//using namespace std;
//
//int main() {
//    string s;
//    cin >> s;
//    int n = s.length();
//    int p = n;
//    for (int i = n - 1; i > 0; --i) {
//        if (s[i] < s[i - 1]) {
//            p = i;
//            --s[i - 1];
//        }
//    }
//    for (int j = p; j < n; ++j) {
//        s[j] = '9';
//    }
//    int val = stoi(s);
//    cout << val;
//    return 0;
//}