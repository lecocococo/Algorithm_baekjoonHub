import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int max;
    static int sum;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        bisect();

        System.out.println(answer);
    }
    static int bisect() {
        int start = 0;
        int end = N - 1;
        int prevSum = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            sum = calc(mid);

            if (sum > prevSum) {
                start = mid + 1;
            } else {
                answer = arr[mid];
                end = mid - 1;
                prevSum = sum;
            }
        }

        return end;
    }



    static int calc(int mid) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.abs(arr[i] - arr[mid]);
        }
        return sum;
    }
}
