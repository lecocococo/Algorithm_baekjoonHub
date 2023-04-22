import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int[] times;
    static int[] indegree;
    static int[] outdegree;
    static List<Integer>[] pre;
    static int[] mVals;
    static List<Integer>[] g;
    static int num;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {

            StringTokenizer st = new StringTokenizer(br. readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            times = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            indegree = new int[N + 1];
            outdegree = new int[N + 1];
            pre = new List[N + 1];
            mVals = new int[N + 1];
            g = new List[N + 1];


            for (int i = 1; i < N + 1; i++) {
                g[i] = new ArrayList();
                pre[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                pre[B].add(A);
                g[A].add(B);

                outdegree[A]++;
                indegree[B]++;
            }


            num = Integer.parseInt(br.readLine());
            //System.out.println(Arrays.toString(mVals));
            topologySort();

            //System.out.println(Arrays.toString(mVals));
            sb.append(mVals[num]).append("\n");
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
            
            int max = 0;
            for (Integer k : pre[temp]) {
                if (mVals[k] > max) {
                    max = mVals[k];
                }
            }
            mVals[temp] = max + times[temp];

            for (Integer i : g[temp]) {
                indegree[i]--;
                if(indegree[i]==0) {
                    q.add(i);
                }

            }

        }

    }
}
