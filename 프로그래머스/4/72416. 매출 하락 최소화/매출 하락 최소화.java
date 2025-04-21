import java.util.*;
class Solution {
    public int[] C;
    public int[][] dp;
    public Map<Integer, List<Integer>> map = new HashMap<>();

    //isContain = 0 : 해당 노드를 포함하지 않으면서 하위 최소 코스트
    //isContain = 1 : 해당 노드를 포함하면서 하위 최소 코스트
    public int dfs(int cur, int isContain) {
        //기저 조건
        if (dp[cur][isContain] != Integer.MAX_VALUE) return dp[cur][isContain];
        if (!map.containsKey(cur)) return isContain == 0 ? 0 : C[cur];

        int result = isContain == 0 ? 0 : C[cur];
        int minContainDiff = Integer.MAX_VALUE;       //하위 노드 중 참석 했을 때 - 불참석 했을때 코스트 차이 최소값 
        boolean containExist = false;             //하위 노드 중 한명이라도 참석했는지 여부
        //하위 노드 최소값 합을 구해줌
        for (int i = 0; i < map.get(cur).size(); i++) {
            int target = map.get(cur).get(i);
            int notContain = dfs(target, 0);
            int contain = dfs(target, 1);
            minContainDiff = Math.min(minContainDiff, contain - notContain);
            if (notContain < contain) {
                result += notContain;
            } else {
                result += contain;
                containExist = true;
            }
        }
        //현재 노드 미포함 + 하위 노드 미포함 케이스 -> 하위 노드 참석 코스트 최소값 더해줌
        if (isContain == 0 && !containExist)
            result += minContainDiff;

        return dp[cur][isContain] = result;
    }
    public int solution(int[] sales, int[][] links) {
        //초기화
        C = new int[sales.length + 1];
        dp = new int[sales.length + 1][2];
        for (int i = 0; i < sales.length + 1; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        for (int i = 0; i < sales.length; i++)
            C[i+1] = sales[i];
        for (int i = 0; i < links.length; i++) {
            int from = links[i][0];
            int to = links[i][1];
            if (map.containsKey(from)) {
                map.get(from).add(to);
            } else {
                map.put(from, new ArrayList<>());
                map.get(from).add(to);
            }
        }

        //dfs 시작
        //1번노드 하위 최소 코스트 리턴
        return Math.min(dfs(1, 0), dfs(1, 1));
    }
}