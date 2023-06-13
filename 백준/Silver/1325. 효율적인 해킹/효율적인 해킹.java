import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<Integer>[] g;
    static boolean[] visited;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        g = new List[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            g[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            g[A].add(B);
        }

        list = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            Arrays.fill(visited, false);
            solve(i);
        }
        int max = 0;
        for (int i = 1; i <= N; i++)
        {
            max = Math.max(max, list[i]);
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + 1; i++) {
            if (list[i] == max) {
                sb.append(i).append(" ");
            }

        }
        System.out.println(sb.toString());

    }
    
    static void solve(int v) {
        visited[v] = true;

        for (int i : g[v]){
            if (visited[i]==false){
                list[i]++;
                solve(i);
            }
        }

    }
}
