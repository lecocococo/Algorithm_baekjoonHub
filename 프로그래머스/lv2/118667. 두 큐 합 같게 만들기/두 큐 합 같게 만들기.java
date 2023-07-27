import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long totalSum = sum(queue1) + sum(queue2);
        long answerSum = totalSum / 2;
        long q1Sum = sum(queue1);

        Queue<Integer> deque1 = new ArrayDeque<>();
        Queue<Integer> deque2 = new ArrayDeque<>();

        for (int val : queue1) {
            deque1.add(val);
        }

        for (int val : queue2) {
            deque2.add(val);
        }

        int answer = 0;
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            if (q1Sum < answerSum) {
                int tempVal = deque2.poll();
                q1Sum += tempVal;
                deque1.add(tempVal);
                answer++;
            } else if (q1Sum > answerSum) {
                q1Sum -= deque1.poll();
                answer++;
            } else {
                return answer;
            }
        }

        return -1;
    }

    private long sum(int[] array) {
        long sum = 0L;
        for (int val : array) {
            sum += val;
        }
        return sum;
    }
}
