import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        arr = new int[N];
        sums = new int[N];

        temp = br.readLine().split(" ");
        int max = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(temp[i]);
            max = Math.max(max, arr[i]);
        }
//        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                sums[i] = arr[i];
            }
            if(i > 0) {
                sums[i] = sums[i - 1] + arr[i];
            }
        }



        int t = find(max, sums[N - 1]);

        System.out.println(t);
    }

    public static int find(int s, int e) {
        int first = s;
        int last = e;

        while(first <= last) {
            int mid = (first + last) / 2;

            int count = getGroupCount(mid);

            if(count > M) {
                first = mid + 1;
            } else if (count <= M){
                last = mid - 1;
            }


        }

        return first;
    }

    public static int getGroupCount(int mid) {
        int cnt = 1;
        int sum = 0;
        for(int i = 0;i < N;i++){
            sum += arr[i];
            if(sum > mid) {
                cnt++;
                sum = arr[i];
            }

        }

        return cnt;
    }
}
