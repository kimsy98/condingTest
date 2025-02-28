import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0, currentServerCnt = 0;
        PriorityQueue<Server> activeServers = new PriorityQueue<>((a, b) -> a.end - b.end);

        for (int t = 0; t < 24; t++) {
            // 해당 시간에 방문한 사용자 수
            int people = players[t];

            // 서버 닫기 : 현재 켜진 서버 중 종료 시간이 t보다 작은 서버를 모두 닫음
            while (!activeServers.isEmpty() && activeServers.peek().end < t) {
                currentServerCnt -= activeServers.poll().cnt;
            }

            // 지금 모자란 서버 수 = (사람 수 / 처리량) - 이미 켜진 서버 수
            int needServerCnt = Math.max(0, people / m - currentServerCnt);

            // 모자란 서버 수가 1대 이상인 경우, 모자란만큼 "즉시" 서버를 켜야함
            if (needServerCnt > 0) {
                activeServers.add(new Server(needServerCnt, t + k - 1));
                currentServerCnt += needServerCnt;
                answer += needServerCnt;
            }
        }

        return answer;
    }

    private class Server {
        int end, cnt;

        private Server(int cnt, int end) {
            this.cnt = cnt;
            this.end = end;
        }
    }
}