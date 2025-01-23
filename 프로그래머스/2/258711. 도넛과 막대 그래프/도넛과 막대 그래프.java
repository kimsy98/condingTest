import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> nodes = new HashMap<>();
        
        int vertex =0;
        int stick =0;
        int donut =0;
        int eight =0;
        for(int[] e : edges){
            int st = e[0];
            int end= e[1];
            nodes.putIfAbsent(st, new int[]{0, 0});
            nodes.putIfAbsent(end, new int[]{0, 0});
            //  if(!nodes.containsKey(st)){
            //     nodes.put(st, new int[]{0,0});
            // }
            // if(!nodes.containsKey(end)){
            //     nodes.put(end, new int[]{0,0});
            // }

            nodes.get(st)[0]++;
            nodes.get(end)[1]++;
        }
        
        for(int key : nodes.keySet()){
            int[] cnt = nodes.get(key);
            // System.out.println(Arrays.toString(cnt));
            if(cnt[0]>=2&&cnt[1]==0){
                vertex = key;
            }else if(cnt[0]==0&&cnt[1]>0){
                stick++;
            }else if(cnt[0]>=2 && cnt[1]>=2){
                eight++;
            }
        }
        
        donut = nodes.get(vertex)[0]- stick - eight;
        
        return new int[]{vertex, donut, stick, eight};
    }
}