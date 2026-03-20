#include <string>
#include <vector>

using namespace std;

int solution(string my_string, string target) {
    if (my_string.length() < target.length()) return 0;
    int limit = my_string.size()-target.size();
    for(int i =0; i<=limit;i++){
        bool check = true;
        for(int j = 0; j<target.size(); j++){
            if(my_string[i+j]!=target[j]){
                check = false;
                break;
            }
        }
        if(check) return 1;
    }
    return 0;
}