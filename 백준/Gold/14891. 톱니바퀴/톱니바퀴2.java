//  톱니바퀴

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] wheel = new int[4][];
        for(int i=0; i<4; i++){
            st= new StringTokenizer(br.readLine());
            wheel[i] = Stream.of(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
        }
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        while(k-->0){
            st = new StringTokenizer(br.readLine());
            int wheelNum = Integer.parseInt(st.nextToken())-1;
            int dir = Integer.parseInt(st.nextToken());
            Map<Integer, Integer> map =new HashMap<>();

            map.put(wheelNum,dir);
            int nowWheelNum = wheelNum;
            int nowDir = dir;
            for(int i = wheelNum+1;i<4; i++){
                if(wheel[i][6]!=wheel[nowWheelNum][2]){
                    map.put(i,nowDir*-1);
                }else{
                    map.put(i,0);
                    break;
                }
                nowWheelNum = i;
                nowDir = map.get(i);
            }
            nowWheelNum = wheelNum;
            nowDir = dir;
            for(int i = wheelNum-1;i>=0; i--){
                if(wheel[i][2]!=wheel[nowWheelNum][6]){
                    map.put(i,nowDir*-1);
                }else {
                    map.put(i,0);
                    break;
                }
                nowWheelNum = i;
                nowDir = map.get(i);
            }
            for(int key: map.keySet()){
                if(map.get(key)==1)right(wheel[key]);
                else if (map.get(key)==-1)left(wheel[key]);
            }

        }
        int score = 0;
        int pow = 1;
        for(int[] tooth : wheel){
            if(tooth[0]==1)score += pow;
            pow *= 2;
        }
        System.out.println(score);
    }
    public static int[] left(int[] tooth){
        int copyFirst = tooth[0];
        for(int i =0; i<tooth.length-1;i++){
            tooth[i] = tooth[i+1];
        }
        tooth[tooth.length-1] = copyFirst;
        return tooth;
    }
    public static int[] right(int[] tooth){
        int copyLast = tooth[tooth.length-1];
        for(int i =tooth.length-1; i>0;i--){
            tooth[i] = tooth[i-1];
        }
        tooth[0] = copyLast;
        return tooth;
    }
}
