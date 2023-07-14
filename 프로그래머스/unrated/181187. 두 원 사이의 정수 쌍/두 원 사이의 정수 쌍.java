class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for(int i = 1; i <= r2;i++) {
            
            long highPosition = (int) Math.floor(
                Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));
            
            long lowPosition = (int) Math.ceil(
                Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
            
            
            // System.out.println(highPosition + " " + lowPosition);
            answer += (highPosition - lowPosition);
        }
        
        answer += (1 * r2);
        answer *= 4;
        return answer;
    }
}