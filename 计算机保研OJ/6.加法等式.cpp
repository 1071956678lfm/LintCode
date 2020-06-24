#include<iostream>
#include<vector>
#include<set>

using namespace std;

bool isValid(int a , int b , int c){
    if(a == 0) return 0;
    else if(b == 0) return 0;
    
    int num1 = a * 100 + b * 10 + c;
    int num2 = b * 100 + c * 10 + c;
    return num1 + num2 == 532;
}

int main(){
    for(int a = 0; a <= 9 ; ++a){
        for(int b = 0 ; b <= 9; ++b){
            for(int c = 0; c <= 9 ; ++c){
                if(isValid(a, b, c)){
                    cout << a << ' ' << 
                        b << ' ' <<
                        c << endl;
                }
            }
        }
    }
}