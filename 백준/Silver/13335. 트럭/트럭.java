

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        int n, w, L;
        Queue<Truck> trucks = new LinkedList<>();
        Queue<Truck> bridge = new LinkedList<>();
        Queue<Truck> q = new LinkedList<>();

        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i =0; i<n; i++){
            trucks.add(new Truck(Integer.parseInt(st.nextToken())));
        }
        int nowL = 0;
        Truck start= trucks.poll();
        start.movePos();
        bridge.add(start);
        answer++;
        nowL+= start.getWeight();

        while(!bridge.isEmpty()){
            Truck truck;
            answer++;
            while(!bridge.isEmpty()){
                Truck truck1 = bridge.poll();
                truck1.movePos();
                if(truck1.getPos()>w){
                    nowL-=truck1.getWeight();
                    continue;
                }
                q.add(truck1);
            }
            while(!q.isEmpty())bridge.add(q.poll());

            if(!trucks.isEmpty()&&nowL+trucks.peek().getWeight()<=L){
                truck= trucks.poll();
                truck.movePos();
                nowL+= truck.getWeight();
                bridge.add(truck);
            }
//            System.out.println(bridge.peek().getPos());

        }
        System.out.println(answer);
    }

    static class Truck{
        int nowPos, weight;
        Truck(int weight){
            this.weight = weight;
            this.nowPos = 0;
        }
        int getWeight() {
            return weight;
        }
        int getPos(){
            return   nowPos;
        }
        void movePos(){
            nowPos+=1;
        }

    }
}