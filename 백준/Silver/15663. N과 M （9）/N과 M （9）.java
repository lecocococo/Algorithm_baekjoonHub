import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static int[] arr;
    public static int[] l;
    public static boolean[] visited;
    private static Set<String> set = new HashSet<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        l = new int[M];
        visited = new boolean[N];
        solve(N, M,0);
        System.out.println(sb);

    }

    public static void solve(int N, int M, int depth) {
        if (depth == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int val : l) {
                sb2.append(val).append(' ');
            }
            if (!set.contains(sb2.toString())) {
                sb.append(sb2.toString()).append('\n');
                set.add(sb2.toString());
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]){
                visited[i] = true;
                l[depth] = arr[i];
                solve(N, M, depth + 1);
                l[depth] = 0;
                visited[i] = false;
            }
        }
    }
}
