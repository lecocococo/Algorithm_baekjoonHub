import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        N = Integer.parseInt(temp[0]);
        M = Integer.parseInt(temp[1]);

        arr = new int[N];
        int sum  =0;
        int max = -1;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }

//        System.out.println(sum);

        int t = find(max, sum);
        System.out.println(t);
    }

    public static int find(int s, int e){
        int start = s;
        int end = e;

        while(start <= end) {
            int mid = (start + end) /2;
//            System.out.println(mid);
            int count = getCount(mid);
//            System.out.println(count);

//            System.out.println(start + " " + end);
            if (count > M) {

                start = mid + 1;
            } else {
                end = mid - 1;
            }


        }
        return start;
    }

    public static int getCount(int mid){
        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (sum + arr[i] > mid) {
                cnt++;
                sum = 0;
            }
            sum += arr[i];

        }
        if (sum != 0) {
            cnt++;
        }

        return cnt;
    }
}
