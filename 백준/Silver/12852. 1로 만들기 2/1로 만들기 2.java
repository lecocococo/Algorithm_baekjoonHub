import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;

    static int[][] arr;
    static int cnt;
    static List<Integer> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        arr = new int[N + 1][4];

        bfs();

        System.out.println(cnt);



        StringBuilder sb = new StringBuilder();
        for (Integer an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);


    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        Queue<List> lq = new ArrayDeque<>();
        visited[N] = true;
        q.add(new int[] {N, 0});
        List<Integer> li = new ArrayList<>();
        li.add(N);
        lq.add(li);

        visited[N] = true;

        while (!q.isEmpty()) {
            int[] num = q.poll();
            List<Integer> list = lq.poll();

            if (!visited[num[0]]) {

            }
            if (num[0] == 1) {
                cnt = num[1];
                ans = list;
                return;
            }

            if (num[0] % 3 == 0 && !visited[num[0]/ 3]) {
                q.add(new int[] {num[0]/3, num[1] + 1});
                List<Integer> list2 = new ArrayList<>(list);
                list2.add(num[0] / 3);
                visited[num[0]/3] = true;
                lq.add(list2);
                arr[num[0]/3][3] = num[0];
            }

            if (num[0] % 2 == 0 && !visited[num[0]/ 2]) {
                q.add(new int[] {num[0]/2, num[1] + 1});
                List<Integer> list2 = new ArrayList<>(list);
                list2.add(num[0] / 2);
                visited[num[0]/2] = true;
                lq.add(list2);
                arr[num[0]/2][2] = num[0];
            }

            if (num[0] > 1 && !visited[num[0] - 1]) {
                q.add(new int[] {num[0] - 1, num[1] + 1});
                List<Integer> list2 = new ArrayList<>(list);
                list2.add(num[0] - 1);
                visited[num[0] - 1] = true;
                lq.add(list2);
                arr[num[0] -1][1] = num[0];
            }

        }

    }
}
