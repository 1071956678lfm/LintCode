//
// Created by mac on 2019/9/21.
//
#include <iostream>
#include <cctype>

void solution32();

using namespace std;

bool prime(int n) {
    return (n % 4 == 0 && n % 100 != 0) || (n % 400 == 0);
}

//int main() {
//    solution32();
//    return 0;
//}

void solution32() {
    int a[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
//    cin >> y >> m >> d;
    string s;
    cin >> s;
    string tmpNumber;
    int count = 0;
    int *nums = new int[3];
    for (int j = 0; j < s.length(); ++j) {
        if (isnumber(s[j])) {
            tmpNumber = tmpNumber + s[j];
        } else {
            nums[count++] = stoi(tmpNumber);
            tmpNumber = string();
            j += 1;
        }
    }
    nums[count++] = stoi(tmpNumber);
    int y = nums[0], m = nums[1], d = nums[2];

    int sum = d;
    for (int i = 1; i <= m - 1; i++) {
        sum += a[i];
    }
    if (m >= 3 && prime(y)) {
        sum++;//如果是闰年，且超过了2月，则多加一天
    }
    cout << sum << endl;
}
