class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        int gap = Math.abs(a-b);
        
        //절댓값이 1이고a,b 둘 중 큰게 무조건 짝수 인 경우가 바로 붙음
        // if(gap==1){
        //     if(a>b&&a%2==0){
        //          return 1;
        //     }else if(b>a&&b%2==0){
        //          return 1;
        //     }
        // }
        
        int aG = a/2 + a%2;
        int bG = b/2 + b%2;
        
        //group 을 구해서 같은 그룹이 나올 때까지 group은 num/2 + num%2;
        while(aG!=bG){
            answer++;
            aG = aG/2 + aG%2;
            bG = bG/2 + bG%2;
        }
        // System.out.println();
        return answer;
    }
}