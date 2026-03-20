#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
bool isPrime(long long num,int n){
    if(num<2) return false;
    for(long long i =2; i*i<=num;i++){
        if (num % i == 0) return false;    
    }
    return true;
}
int solution(int n, int k) {
    int answer = 0;
    string str;
    long long temp_n = n;
    while(n){
        str+= n%k+'0';
        n = n/k;
    }
    reverse(str.begin(), str.end());

    string temp="";
    for(char c : str){
        if(c=='0'){
            if(!temp.empty()){
                if(isPrime(stoll(temp),temp_n)) answer++;
            }
            temp="";
        }else{
            temp+=c;
        }
    }
    if(!temp.empty())if(isPrime(stoll(temp),temp_n)) answer++;
    
    return answer;
}