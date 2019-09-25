//
// Created by mac on 2019/9/21.
//
#include <iostream>

using namespace std;

long cal(int x) {
    if (x == 0) return 1;
    if (x == 1) return 1;
    if (x == 2) return x - (x - 1);
    if (x == 3) return x - (x - 1) * (x - 2);
    if (x == 4) return x - (x - 1) * (x - 2) / (x - 3);
    return x - (x - 1) * (x - 2) / (x - 3) + cal(x - 4);
}

int solution39() {
    int N;
    cin >> N;
    if (N == 0) return 1;
    if (N == 1) return 1;
    if (N == 2) return 2;
    if (N == 3) return 6;
    return (int) (N * (N - 1) / (N - 2) + cal(N - 3));
}

//int main() {
//    cout << solution39();
//    return 0;
//}

