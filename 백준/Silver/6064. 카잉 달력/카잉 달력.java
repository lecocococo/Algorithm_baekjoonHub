import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int arr[]= new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            arr[2] -= 1;
            arr[3] -= 1;

            boolean flag = false;
            // x먼저 맞추고 y맞춤
            for (int i = arr[2]; i < (arr[0] * arr[1]); i += arr[0]) {
                if (i % arr[1] == arr[3]) {
                    System.out.println(i + 1);
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.println(-1);
            }
        }
    }
}
