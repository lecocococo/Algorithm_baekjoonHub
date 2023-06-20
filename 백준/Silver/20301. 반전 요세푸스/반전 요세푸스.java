import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr.add(i);
        }

        boolean flag = false;
        int front = 0;

        List<Integer> order = new ArrayList<>();
        int cnt = 0;
        while (!arr.isEmpty()) {
            int pos;
            if (flag) {
                pos = (front - K ) % arr.size();
                if (pos < 0) {
                    pos = arr.size() + pos;
                }
            } else {
                pos = (front + K - 1) % arr.size();
            }

            int num = arr.get(pos);
            arr.remove(pos);

            cnt++;
            if (cnt == M) {
                cnt = 0;
                flag = !flag;
            }

            order.add(num);
            front = pos;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : order) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }
}
