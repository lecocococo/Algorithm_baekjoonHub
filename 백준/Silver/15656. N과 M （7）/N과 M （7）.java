import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int[] l;
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i =0; i<N;i++){
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
            for (int val : l) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            l[depth] = arr[i];
            solve(N, M, depth + 1);
        }
    }
}