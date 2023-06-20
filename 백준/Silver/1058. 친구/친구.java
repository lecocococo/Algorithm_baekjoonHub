import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        friends = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'N') {
                    friends[i][j] = Integer.MAX_VALUE / 2 - 1;
                } else {
                    friends[i][j] = 1;
                }

                if (i == j) {
                    friends[i][j] = 0;
                }
            }
        }
        
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }
                    if (friends[i][j] > friends[i][k] + friends[k][j]) {
                        friends[i][j] = friends[i][k] + friends[k][j];
                    }
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < N; i++) {
            int cnt = 0;

            for (int j = 0; j < N; j++) {
                if (i == j){
                    continue;
                }

                if (friends[i][j] <= 2) {
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }
}
