import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int[] temp = new int[2];
                temp[0] = Integer.parseInt(st.nextToken());
                temp[1] = Integer.parseInt(st.nextToken());
                arr[temp[0]] = temp[1];
            }

            int answer = solve();

            System.out.println(answer);
        }
    }

    static int solve() {
        // 합격자 찾기
        // 마지막 합격자 보단 y가 무조건 작아야 합격
        int count = 1;
        int val = arr[1];

        for (int i = 2; i <= N; i++) {
            if (arr[i] < val) {
                count++;
                val = arr[i];
            }
        }
        return count;
    }

}
