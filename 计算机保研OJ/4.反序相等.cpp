#include<iostream>
#include<string>
#include<bits/stdc++.h> 
using namespace std;
bool isReverse(int num){
    int more = num * 9;
    if(more > 10000) return false;
    string sMin = to_string(more), sMax = to_string(num) ;
    reverse(sMin.begin() , sMin.end());
    return sMin == sMax;
}

int main(){
    int limit = 10000;
    for(int i = 1000 ; i * 9 < limit; ++i){
        if(isReverse(i)) cout << i << endl;
    }
}