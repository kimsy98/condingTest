//  스택 수열

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int nextNum = 2;
        st.push(0);
        st.push(1);
        sb.append('+').append('\n');
        boolean check = false;
        for (int i =0; i<n; i++){

            while(!st.isEmpty()){
                if(st.peek()<arr[i]){
                    st.push(nextNum++);
                    sb.append('+').append('\n');
                } else if (st.peek()==arr[i]) {
                    st.pop();
                    sb.append('-').append('\n');
                    break;
                }else{
                    check = true;
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
            }
            if(check)break;
        }
        System.out.println(sb);

    }
}