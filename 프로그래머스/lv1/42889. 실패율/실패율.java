import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer;
        int users = stages.length;
        HashMap<Integer, Integer> temp = new HashMap<>();

        for (int stage : stages) {
            temp.put(stage, temp.getOrDefault(stage, 0) + 1);
        }

        HashMap<Integer, Double> fail = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            if (!temp.containsKey(i)) {
                fail.put(i, 0.0);
            } else {
                fail.put(i, (double) temp.get(i) / users);
                users -= temp.get(i);
            }
        }

        List<Map.Entry<Integer, Double>> sortedFail = new ArrayList<>(fail.entrySet());
        Collections.sort(sortedFail, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = sortedFail.get(i).getKey();
        }

        return answer;
    }
}
