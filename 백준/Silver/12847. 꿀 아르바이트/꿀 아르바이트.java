import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i < m) {
                sum += arr[i];
            }
        }
        int s = 0;
        int e = m;
        long answer = sum;
        while (e < n) {
            long temp = sum + arr[e++] - arr[s++];

            if(answer < temp){
                answer = temp;
            }
            sum = temp;
        }

        System.out.println(answer);
    }
}
