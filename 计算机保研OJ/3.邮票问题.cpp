#include<iostream>
#include<set>

using namespace std;

int main(){
    set<int> s;
    
    for(int i = 0 ; i <= 5;  ++i){
        for(int j = 0 ; j <= 4 ; ++j){
            for(int k = 0 ; k <= 6; ++k){
                if(i == 0 && j == 0 && k == 0) continue;
                s.insert(i * 8 + j * 10 + k * 18);
            }
        }
    }
    cout << s.size()<< endl;
    
}