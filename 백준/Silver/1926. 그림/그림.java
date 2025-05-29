import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] arr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] check;
    static int answerArea;
    static int answerCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] ==1&!check[i][j]){
                    answerCnt++;
                    check[i][j] =true;
                    answerArea= Math.max(answerArea,bfs(i,j));

                }
            }
        }
        System.out.println(answerCnt);
        System.out.println(answerArea);

    }
    public static int bfs(int i, int j){
        int area = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i,j});
        while(!q.isEmpty()){
            int[] pos = q.poll();
            for(int k =0; k<4; k++){
                int nx = pos[0]+ dx[k];
                int ny = pos[1]+ dy[k];
                if(nx<0|| nx>= n|| ny<0|| ny>=m)continue;
                if(arr[nx][ny]==0|| check[nx][ny])continue;
                check[nx][ny] = true;
                q.add(new int[] {nx, ny});
                area++;

            }
        }
        return area;

    }

}