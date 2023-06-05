import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] temp;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        temp = new int[2];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        comb(0, 0);
        System.out.println(count);
    }

    static void comb(int depth, int cnt) {
        if (depth == 2) {
            if (temp[0] + temp[1] == M) {
                count++;
            }
            return;
        }
        for (int i = cnt; i < N; i++) {
            temp[depth] = arr[i];
            comb(depth + 1, i + 1);
            temp[depth] = arr[i];
        }
    }
}
