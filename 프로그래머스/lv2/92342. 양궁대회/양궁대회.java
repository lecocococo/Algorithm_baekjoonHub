import java.io.*;
import java.util.*;

class Solution {
    static int[] arr;
    static List<int[]> list;
    
    public int[] solution(int n, int[] info) {
        int[] answer = {-1};  
        int maxGap = -1;
        
        arr = new int[n];
        
        list = new ArrayList<>();
        
        comb(0, 0, n);
        
        
        
        
        for(int i = 0 ; i < list.size();i++){
            int[] info2 = new int[11];
            int[] temp = list.get(i);
            
            for(int j = 0 ;j < temp.length; j++) {
                info2[10 - temp[j]]++;
            }
                                  
            int apeach = 0, lion = 0;
            for (int idx = 0; idx < 11; idx++) {
                if (info[idx] == info2[idx] && info[idx] == 0) { // 라이언과 어피치 모두 한번도 화살을 맞히지 못한 경우
                    continue;
                } else if (info[idx] >= info2[idx]) { // 어피치가 라이언이 쏜 화살의 수 이상을 맞힌 경우
                    apeach += 10 - idx;
                } else { // 라이언이 어피치보다 많은 수의 화살을 맞힌 경우
                    lion += 10 - idx;
                }
            }

            if (lion > apeach) {
                int gap = lion - apeach;
                if (gap > maxGap) {
                    maxGap = gap;
                    answer = Arrays.copyOf(info2, 11);
                }
            }
        }
        
        
        return answer;
    }
    
    public void comb(int start, int cnt, int n) {
        if(cnt == n) {
            
            int[] temp = new int[n];
            for(int i = 0 ;i < n;i++){
                temp[i] = arr[i];
            }
            list.add(temp);
            // System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i = start; i < 11; i++) {
            arr[cnt] = i;
            // k++;
            comb(i, cnt + 1, n);
        }
    }
}