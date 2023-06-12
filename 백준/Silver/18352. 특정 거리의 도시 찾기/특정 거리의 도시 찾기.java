import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int K;
    static int X;
    static List<Integer>[] g;
    static boolean[] visited;
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        g = new List[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            g[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        ans = new ArrayList<>();

        solve();

        if (ans.size() < 1) {
            System.out.println(-1);
        } else {
            ans.sort(Comparator.naturalOrder());

            StringBuilder sb = new StringBuilder();
            for (int i : ans) {
                sb.append(i).append("\n");
            }
            System.out.println(sb.toString());
        }
    }

    static void solve() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{X, 0});
        visited[X] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int dist = temp[1];

            if (dist == K) {
                ans.add(temp[0]);
            }
            if(dist > K){
                return;
            }

            for (int i :g[temp[0]]) {
                if (!visited[i] && dist < K) {
                    q.add(new int[]{i, dist + 1});
                    visited[i] = true;
                }
            }
        }
    }
}
