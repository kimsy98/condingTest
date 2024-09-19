import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int cnt = 0;
    public static boolean[] visited;
    public static ArrayList<Integer>[] list;

    public static void Find(int depth, int start){
        if(depth == 2){
            return;
        }

        for (int i = 0; i < list[start].size(); i++) {
            int next = list[start].get(i);
            visited[next] = true;
            Find(depth + 1, next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        visited[1] = true;

        Find(0, 1);

        for (int i = 2; i < visited.length; i++) {
            if(visited[i]){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}