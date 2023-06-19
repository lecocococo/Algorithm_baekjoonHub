import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

    static int kx;
    static int ky;
    static int sx;
    static int sy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        kx = temp[0].charAt(0)-'A';
        ky = temp[0].charAt(1)-'0'-1;

        sx = temp[1].charAt(0)-'A';
        sy = temp[1].charAt(1)-'0'-1;

        N = Integer.parseInt(temp[2]);

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            List<Integer> pos = move(kx, ky, command);

            if (!check(pos.get(0), pos.get(1))) {
                continue;
            }

            if(pos.get(0) == sx && pos.get(1) == sy) {
                List<Integer> stone = move(sx, sy, command);
                if (check(stone.get(0), stone.get(1))) {
                    sx = stone.get(0);
                    sy = stone.get(1);
                    kx = pos.get(0);
                    ky = pos.get(1);
                }
            }else {
                kx = pos.get(0);
                ky = pos.get(1);
            }
        }

        StringBuilder sb = new StringBuilder();
        //마지막 위치 출력
        sb.append((char) (kx + 65)).append(ky + 1).append("\n");
        sb.append((char) (sx + 65)).append(sy + 1).append("\n");
        System.out.print(sb);
    }

    private static boolean check(int x, int y) {
        if(x < 0 || x >= 8 || y < 0 || y >= 8) {
            return false;
        }
        return true;
    }

    private static List<Integer> move(int x, int y,String command) {
        int nx = 0;
        int ny = 0;
        List<Integer> pos = new ArrayList<>();

        switch (command) {
            case "R":
                nx = x + dx[0];
                ny = y + dy[0];
                break;
            case "L":
                nx = x + dx[1];
                ny = y + dy[1];
                break;
            case "B":
                nx = x + dx[2];
                ny = y + dy[2];
                break;
            case "T":
                nx = x + dx[3];
                ny = y + dy[3];
                break;
            case "RT":
                nx = x + dx[4];
                ny = y + dy[4];
                break;
            case "LT":
                nx = x + dx[5];
                ny = y + dy[5];
                break;
            case "RB":
                nx = x + dx[6];
                ny = y + dy[6];
                break;
            case "LB":
                nx = x + dx[7];
                ny = y + dy[7];
                break;

        }
        pos.add(nx);
        pos.add(ny);

        return pos;
    }
}
