class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int current = 1;
        int range = 2 * w + 1;

        for (int s : stations) {
            int leftEdge = s - w; // 기지국 전파가 시작되는 지점
            
            if (current < leftEdge) {
                // 빈 공간(gap) 계산과 설치 대수 합산을 한 번에
                int gap = leftEdge - current;
                answer += (gap + range - 1) / range;
            }
            // 기지국이 겹치더라도 current를 뒤로 보낼 필요는 없으므로
            // 항상 기지국 전파 끝 다음 지점으로 갱신
            current = s + w + 1;
        }

        // 마지막 기지국 이후 남은 구간 처리
        if (current <= n) {
            answer += (n - current + range) / range; // (n - current + 1 + range - 1) 정리
        }

        return answer;
    }
}