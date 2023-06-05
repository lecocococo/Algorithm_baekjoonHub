import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        long sum = 0L;
        int i = 0, j = 0;
        while(true) {
            if (i == N && sum <= M){
                if (sum == M){
                    count++;
                }
                break;
            }
            if (sum > M) {
                sum -= arr[j++];
            } else if (sum <= M){
                if (sum == M){
                    count++;
                }
                sum += arr[i++];
            }

        }

        System.out.println(count);
    }
}
