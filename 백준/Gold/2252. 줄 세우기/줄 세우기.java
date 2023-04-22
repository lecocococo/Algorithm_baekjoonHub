import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;

    static int[] indegree;
    static List<Integer>[] g;
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br. readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];
        g = new List[N + 1];
        ans = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            g[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            g[A].add(B);

            indegree[B]++;
        }

        topologySort();

        StringBuilder sb = new StringBuilder();
        for (Integer an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }

    static void topologySort() {
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (Integer i : g[temp]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            ans.add(temp);
        }

    }
}
