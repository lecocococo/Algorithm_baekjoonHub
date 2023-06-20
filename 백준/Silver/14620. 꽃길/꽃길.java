import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;
    static boolean[][] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0);

        System.out.println(min);
    }
    
    static void solve(int depth, int sum) {
        if (depth == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!isPossible(i, j)){
                    continue;
                }

                int temp = sumCost(i, j);
                checkVisit(i, j, true);
                solve(depth + 1, sum + temp);
                checkVisit(i, j, false);
            }
        }
    }

    static boolean isPossible(int x, int y) {
        if (visited[x][y]) {
            return false;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (!checkRange(nx, ny) || visited[nx][ny]) {
                return false;
            }
        }

        return true;
    }

    static int sumCost(int x, int y) {
        int sum = map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            sum += map[nx][ny];
        }

        return sum;
    }

    static void checkVisit(int x, int y, boolean v) {
        visited[x][y] = v;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[nx][ny] = v;
        }
    }

    static boolean checkRange(int x, int y) {
        if (x < 1 || x > N || y < 1 || y > N) {
            return false;
        }

        return true;
    }
}
