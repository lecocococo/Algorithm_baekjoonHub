import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = bfs();

        System.out.println(answer);
    }
    static int bfs() {
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{1, 0});
        visited[1] = true;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == N) {
                return temp[1];
            }

            for (int i = 1; i <= arr[temp[0]]; i++) {
                if (temp[0] + i <= N &&!visited[temp[0] + i]) {
                    q.add(new int[]{temp[0] + i, temp[1] + 1});
                    visited[temp[0] + i] = true;
                }

            }

        }
        return -1;
    }
}
