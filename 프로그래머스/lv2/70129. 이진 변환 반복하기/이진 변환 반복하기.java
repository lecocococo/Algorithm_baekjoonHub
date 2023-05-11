class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        int cnt = 0;
        int zero = 0;
        String t = s;
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            
            if (t.length() == 1 && t.charAt(0) == '1') {
                break;
            }
            
            for(int i= 0 ; i < t.length(); i++){
                if (t.charAt(i) != '0'){
                    sb.append(t.charAt(i));
                } else {
                    zero++;
                }
            }
            
            
          
            // System.out.println(Integer.toString(sb.length(), 2));
            t = Integer.toString(sb.length(), 2);
            sb.setLength(0);
            cnt++;
        }
        
        // System.out.println(cnt + " " + zero);
        answer = new int[]{cnt , zero};
        return answer;
    }
}