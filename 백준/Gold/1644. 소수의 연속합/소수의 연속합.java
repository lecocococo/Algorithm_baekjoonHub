import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static boolean[] arr;
    static List<Integer> primes;
    static int ans;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        findPrime();

//        System.out.println(Arrays.toString(arr));
        primes = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (!arr[i]) {
                primes.add(i);
            }
        }

//        System.out.println(primes);

        solve();

        System.out.println(ans);
    }

    static void solve() {
        int sum = 0;
        int start = 0;
        int end = 0;

        while (true) {
            if (sum >= N) {
                sum -= primes.get(start++);
            } else if (end == primes.size()) {
                break;
            } else {
                sum += primes.get(end++);
            }

            if (sum == N) {
                ans++;
            }
        }
    }

    static void findPrime() {
        arr = new boolean[N + 1];

        // false이면 소수
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i < Math.sqrt(N + 1); i++) {
            if(!arr[i]){
                for (int j = i * i; j < N + 1; j += i) {
                    arr[j] = true;
                }
            }

        }
    }
}

