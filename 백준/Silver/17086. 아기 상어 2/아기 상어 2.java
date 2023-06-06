import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static Queue<int[]> q;
    static int[][] distance;
    static int answer;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1 ,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        distance = new int[N][M];
        q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = Integer.MAX_VALUE;
                if (arr[i][j] == 1) {
                    distance[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        bfs();

        System.out.println(answer);
    }

    static void bfs() {
        answer = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (check(nx, ny)) {
                    if (distance[nx][ny] > distance[temp[0]][temp[1]] + 1) {
                        distance[nx][ny] = distance[temp[0]][temp[1]] + 1;
                        q.add(new int[]{nx, ny});
                        answer = Math.max(answer, distance[nx][ny]);
                    }
                }
            }
        }
    }

    static boolean check(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return false;
        }
        return true;
    }
}
