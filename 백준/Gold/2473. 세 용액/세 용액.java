import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    static long minMixedSolution;
    static int ansLeft;
    static int ansRight;
    static int point;
    static int ansFirst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        minMixedSolution = Long.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

//        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < N; i++) {
            point = i;

            binarySearch(i, N - 1);
//            System.out.println("1");
        }
        int[] ans = new int[3];


        ans[0] = arr[ansFirst];
        ans[1] = arr[ansLeft];
        ans[2] = arr[ansRight];

        Arrays.sort(ans);

        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }

    static void binarySearch(int s, int e) {
        int start = s + 1;
        int end = e;

        while (start < end) {
            long t = arr[start] + arr[end];
            long sum = t + arr[point];
            if (minMixedSolution > Math.abs(sum)) {
                minMixedSolution = Math.abs(sum);
                ansFirst = point;
                ansLeft = start;
                ansRight = end;
            }
            if (sum > 0) {
                end--;
            }
            if (sum <= 0) {
                start++;
            }

        }

    }
}
