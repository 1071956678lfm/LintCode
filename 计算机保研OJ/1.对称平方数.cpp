#include<iostream>

using namespace std;
bool isSym(int n);
void run(int n);


bool isSym(int n){
    if(n == 0) return 1;
    string nStr = to_string(n);
    int i = 0 , j = nStr.length() - 1;
    while(i < j){
        if(nStr[i] != nStr[j]) return 0;
        ++i;
        --j;
    }
    return 1;
}

void run(int n){
    for(int i = 1 ; i <= n ; ++i){
        if(isSym(i * i)){
            cout << i << endl;
        }
    }
}

int main(){
    int n = 256;
    run(n);
}