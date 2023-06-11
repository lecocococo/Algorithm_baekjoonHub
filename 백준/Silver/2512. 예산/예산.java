import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        M = Integer.parseInt(br.readLine());

        if (sum <= M) {
            System.out.println(max);
        } else {
            int num = solve();
            System.out.println(num - 1);
        }
    }

    public static int solve() {
        int max = 0;
        int start = 0;
        int end = M;
        int prev = Integer.MAX_VALUE;
        while (start < end) {
            int mid = (start + end) / 2;
            if (sum(mid) <= M) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static int sum(int pos) {
        int val = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] <= pos) {
                val += arr[i];
            } else {
                val += pos;
            }
        }

        return val;
    }
}
