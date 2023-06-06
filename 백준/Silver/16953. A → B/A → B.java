import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        long answer = bfs();

        System.out.println(answer);
    }
    static long bfs() {
        Queue<long[]> q = new ArrayDeque();
        q.add(new long[]{A, 1});
        while (!q.isEmpty()) {
            long[] temp = q.poll();
            if (temp[0] == B) {
                return temp[1];
            }
            long a = temp[0] * 2L;
            long b = temp[0] * 10L + 1;
//            System.out.println(a + " " + b);
            if (a <= B) {
                q.add(new long[]{a, temp[1] + 1});
            }
            if (b <= B) {
                q.add(new long[]{b, temp[1] + 1});
            }
        }
        return -1;
    }
}
