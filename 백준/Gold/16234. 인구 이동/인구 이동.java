//  인구 이동

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int l;
    static int r;
    static int[][] A;
    static boolean[][] visit;
    static int[] Nx  ={0, 1, -1, 0};
    static int[] Ny  ={1, 0, 0, -1};
    static boolean check = true;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        A = new int[n][n];
        visit = new boolean[n][n];

        for(int i =0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j =0; j<n; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(check){
            check =false;
            visit = new boolean[n][n];
            for(int i =0; i< n; i++){
                for (int j =0; j<n; j++){
                    if(visit[i][j])continue;
                    visit[i][j] = true;
                    bfs(i,j);
                }
            }
            if(check)answer++;
        }

//        for (int i =0; i <n ; i++){
//            System.out.println(Arrays.toString(A[i]));
//        }
        System.out.println(answer);
    }
    public static void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> sumQPos = new LinkedList<>();

        q.add(new int[] {i,j});
        sumQPos.add(new int[] {i,j});
        int assoCnt = 1;
        int assoSum = A[i][j];
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];
            for(int k =0; k<4; k++){
                int nx = x + Nx[k];
                int ny = y + Ny[k];
                if(nx<0|| nx>=n||ny<0|| ny>=n)continue;
                int gap = Math.abs(A[nx][ny]-A[x][y]);
//                System.out.println(gap +" gap");
                if(visit[nx][ny]||gap<l||gap>r)continue;
                visit[nx][ny] = true;
                q.add(new int[] {nx,ny});
                sumQPos.add(new int[] {nx,ny});
                assoSum+= A[nx][ny];
                assoCnt++;
//                System.out.println("****************");
//                System.out.println(assoSum +" " + assoCnt);
            }
        }
        if(assoCnt>=2){
            check =  true;
            int avg = assoSum/assoCnt;
            while(!sumQPos.isEmpty()){
                int[] pos = sumQPos.poll();
                int xPos = pos[0];
                int yPos = pos[1];
                A[xPos][yPos]  = avg;
            }
        }
//        System.out.println("------------------");
//        for (int k =0; k <n ; k++){
//            System.out.println(Arrays.toString(A[k]));
//        }


    }
}