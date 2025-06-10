//  듣보잡

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), 1);
        }
        for(int i =0; i<m;i++){
            st = new StringTokenizer(br.readLine());
            String man = st.nextToken();
            map.put(man, map.getOrDefault(man,0)+1);
            if(map.get(man)>1){
                cnt++;
            }
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        for(String key : keySet){
            if(map.get(key)>1)sb.append(key).append('\n');
        }
        System.out.println(cnt);
        System.out.println(sb);
    }
}