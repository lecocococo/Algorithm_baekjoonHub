class Solution {
    static int count;
    static int tg;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        count = 0;
        tg = target;
        
        dfs(numbers, 0, 0);
        
        System.out.println(count);
        return count;
    }
    
    public static void dfs(int[] numbers, int num, int cnt) {
        
        if (cnt == numbers.length) {
            if(num == tg) {
                count++;
            }
            return;
        }
        
        dfs(numbers, num + numbers[cnt], cnt + 1);
        dfs(numbers, num - numbers[cnt], cnt + 1);

    }
    
}