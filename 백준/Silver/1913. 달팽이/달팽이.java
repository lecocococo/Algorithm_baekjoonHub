import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int num;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int posx;
    static int posy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N][N];

        posx = 0;
        posy = 0;

        makeArr(-1, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            if (i != N - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
        System.out.println(posx + " " + posy);
    }

    static void makeArr(int i, int j) {
        int d = 0;
        int temp = N * N;
        while (temp > 0) {
            int nx = i + dx[d];
            int ny = j + dy[d];

            if(check(nx, ny) && !visited[nx][ny]){
                arr[nx][ny] = temp--;
                if (arr[nx][ny] == num) {
                    posx = nx + 1;
                    posy = ny + 1;
                }
                visited[nx][ny] = true;
                i = nx;
                j = ny;
            } else {
                d = (d + 1) % 4;
            }


        }
    }

    static boolean check(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }
        return true;
    }
}
