import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[6];
        int maxWidth = 0;
        int maxHeight = 0;
        int widthIdx=0;
        int heightIdx = 0;
        int dir = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dir = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());

            if ((dir == 1 || dir == 2) && maxWidth < arr[i]) {
                maxWidth = arr[i];
                widthIdx = i;
            } else if ((dir == 3 || dir == 4) && maxHeight < arr[i]) {
                maxHeight = arr[i];
                heightIdx = i;
            }
        }

        int right;
        int left;

        if (widthIdx + 1 == 6) {
            right = 0;
        } else {
            right = widthIdx + 1;
        }

        if (widthIdx - 1 == -1) {
            left = 5;
        } else {
            left = widthIdx - 1;
        }

        int minHeight = Math.abs(arr[right] - arr[left]);

        if (heightIdx + 1 == 6) {
            right = 0;
        } else {
            right = heightIdx + 1;
        }

        if (heightIdx - 1 == -1) {
            left = 5;
        } else {
            left = heightIdx - 1;
        }

        int minWidth = Math.abs(arr[right] - arr[left]);

        int answer = ((maxWidth * maxHeight) - (minHeight * minWidth)) * N;
        System.out.println(answer);
    }
}
