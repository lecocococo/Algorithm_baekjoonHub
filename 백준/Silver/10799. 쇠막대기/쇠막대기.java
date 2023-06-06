import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Queue<Character> q = new ArrayDeque<>();

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                q.add('(');
            }
            if (arr[i] == ')') {
                if (arr[i - 1] == '(') {
                    q.poll();
                    answer += q.size();
                } else {
                    q.poll();
                    answer += 1;
                }

            }
        }

        System.out.println(answer);
    }
}
