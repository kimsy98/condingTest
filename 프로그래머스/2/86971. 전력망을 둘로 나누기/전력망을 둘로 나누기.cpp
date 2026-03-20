#include <string>
#include <vector>
using namespace std;

bool vis[101];
int net[101][101];
int answer = 101;
int dfs(int i, int n){
    
    vis[i] = true;
    int child = 1;
    for(int j = 1; j<=n; j++){
        if(net[i][j]==1&&!vis[j]){
            child+= dfs(j,n);
        }
    }
    
    answer = min(answer, abs(n-child*2));
    return child;
}
int solution(int n, vector<vector<int>> wires) {
    for(vector<int> v : wires){
        net[v[0]][v[1]] = 1;
        net[v[1]][v[0]] = 1;
    }
    dfs(1,n);
    
    return answer;
}
