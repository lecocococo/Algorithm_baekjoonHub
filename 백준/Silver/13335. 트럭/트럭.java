import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int bridge = 0;

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < w; i++) {
            q.add(0);
        }

        while (!q.isEmpty()) {
            time++;
            bridge -= q.poll();
            if (!truck.isEmpty()) {
                int t = truck.peek();
                if (bridge + t <= L) {
                    bridge += t;
                    q.offer(truck.poll());
                } else {
                    q.offer(0);
                }
            }
        }
        System.out.println(time);
    }
}
