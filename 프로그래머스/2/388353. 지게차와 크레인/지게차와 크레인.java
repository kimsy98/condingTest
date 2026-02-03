import java.util.*;
class Solution {
    static int[] rMove = {0,-1,1,0};
    static int[] cMove = {1,0,0,-1};
    static List<int[]> delPos = new ArrayList<>();
    static boolean[][] visit;
    static Queue<int[]> oQ = new LinkedList<>();

    public int solution(String[] storage, String[] requests) {
        int answer = 0;

        //초기화
        char[][] container = new char[storage.length+2][storage[0].length()+2];
        visit = new boolean[storage.length+2][storage[0].length()+2];
        for(int i = 0; i<container.length; i++){
            for(int j =0; j<container[0].length; j++){
                container[i][j] = 'x';
            }
        }
        //컨테이너 위치 추가
        for(int i = 0; i<storage.length; i++){
            String arr = storage[i];
            for(int j =0; j<arr.length(); j++){
                container[i+1][j+1] = arr.charAt(j);
            }
        }
        
        
        
        
        
        //작업 처리
        for(String req : requests){
            delPos = new ArrayList<>();
            visit = new boolean[storage.length+2][storage[0].length()+2];
            
            if(req.length()>=2)crain(container, req.charAt(0));
            else {
                for(int i = 1; i<container.length-1; i++){
                    for(int j =1; j<container[0].length-1; j++){   
                            // System.out.println("진입 위치  : "+ i+" "+ j);
                        if(container[i][j] != 'x'&&!visit[i][j]){
                            if(container[i][j]=='o'){
                                oQ.add(new int[] {i, j});
                            }else{
                            bfs(container, req.charAt(0), i, j);
                            }
                        }
                    }
                }

            }
            for(int[] pos: delPos){
                int n = pos[0];
                int m = pos[1];

                container[n][m] = 'x';
            }
//             System.out.println("-----------before");
//                        for(char[] containerArr : container){
//             System.out.println(containerArr);
            
//             }            
//             System.out.println("-----------");
            
            deleteO(container);
            
//             for(char[] containerArr : container){
//             System.out.println(containerArr);
            
//             }            
//             System.out.println("-----------");


        }
        for(char[] pos : container){
            for(char con : pos){
                if(con!='x'&&con!='o')answer++;
            }
        }
        return answer;
    }
    public void bfs(char[][] container, char request, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        int[] pos = new int[2];
        pos[0] = n;
        pos[1] = m;
        q.add(pos);
        visit[n][m] = true;
        if(container[n][m]==request){
            for(int next =0; next<4; next++){
                int nx = n+ rMove[next];
                int ny = m+ cMove[next];
                if(container[nx][ny]=='x'){
                    // System.out.println("처음 들어와서 삭제 리스트 추가 : "+ n+" "+ m);        
                    delPos.add(new int[] {n, m});
                    break;
                }
            }
        }
        while(!q.isEmpty()){
            int[] position = q.poll();
            int r = position[0];
            int c = position[1];
            for(int i =0; i<4; i++){
                int nr = r+ rMove[i];
                int nc = c+ cMove[i];
                //범위 밖 제외
                if(nr<1||nr>=container.length-1||nc<1||nc>=container[0].length-1)continue;
                //방문 했거나 빈 공간 제외
                if(container[nr][nc]=='x'||container[nr][nc]=='o'||visit[nr][nc])continue;
                // if(container[nr][nc]=='o'){
                //     oQ.add(new int[] {nr, nc});
                //     continue;
                // }
                visit[nr][nc] = true;
                if(container[nr][nc]==request){
                    for(int next =0; next<4; next++){
                        int nx = nr+ rMove[next];
                        int ny = nc+ cMove[next];
                        if(container[nx][ny]=='x'){
                            
                            delPos.add(new int[] {nr, nc});
                            // System.out.println("삭제 리스트 추가 : "+ nr+" "+ nc);
                            break;
                        }
                    }
                }
                // System.out.println("다음 큐: "+ nr+" "+ nc);            
                q.add(new int[] {nr,nc});
            }
        }
    }
    public void deleteO(char[][] container){
        Queue<int[]> q = new LinkedList<>();
        int[] pos = new int[2];
        q.add(new int[] {0,0});
        boolean[][] visited = new boolean[container.length][container[0].length];
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] position = q.poll();
            int i =position[0];
            int j =position[1];
            
            for(int next =0; next<4; next++){
                int nx = i+ rMove[next];
                int ny = j+ cMove[next];
                if(nx<0||nx>=container.length||ny<0||ny>=container[0].length||visited[nx][ny])continue;
                if(container[nx][ny]=='x'||container[nx][ny]=='o'){
                    visited[nx][ny] = true;
                    container[nx][ny]='x';
                    q.add(new int[] {nx,ny});
                }
            }            
        }

    }
    public void crain(char[][] container, char request){
        for(int i = 1; i<container.length-1; i++){
            for(int j =1; j<container[0].length-1; j++){
                if(container[i][j]==request){
                    boolean check = false;
                    for(int k = 0; k<4; k++){
                        int nr = i+ rMove[k];
                        int nc = j+ cMove[k];
                        if(container[nr][nc]=='x'){
                            check =true;
                            container[i][j] = 'x';
                        }
                    }
                    if(!check){
                        container[i][j] = 'o';
                        // oQ.add(new int[] {i,j});
                    }
                }
            }
        }
    }
}