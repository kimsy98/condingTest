import java.util.Stack;

public class Solution {
    public int[] solution(int[] arr) {
        // 스택 생성
        Stack<Integer> stack = new Stack<>();

        // arr 순회
        for (int i : arr) {
            if (stack.empty() || !stack.peek().equals(i)) {
                stack.push(i);
            }
        }

        // stack to array
        return stack.stream().mapToInt(i -> i).toArray();
    }
}