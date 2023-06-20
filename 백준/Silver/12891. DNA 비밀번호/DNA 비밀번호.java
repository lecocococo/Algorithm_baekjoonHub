import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] values = new int[4];
        for (int i = 0; i < 4; i++) {
            values[i] = 0;
        }

        for (int i = 0; i < P; i++) {

            int idx = getDnaIndex(dna.charAt(i));
            values[idx]++;
        }

        int start = 0;
        int end = P - 1;
        int count = 0;

        while (end < S) {
            for (int i = 0; i <= 4; i++) {
                if (i == 4) {
                    count++;
                    break;
                }
                if (arr[i] > values[i]) {
                    break;
                }
            }

            if (end + 1 == S) {
                break;
            }

            int idx = getDnaIndex(dna.charAt(start++));
            values[idx]--;

            idx = getDnaIndex(dna.charAt(++end));
            values[idx]++;
        }

        System.out.println(count);
    }

    public static int getDnaIndex(char c) {
        switch(c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }

        return -1;
    }
}
