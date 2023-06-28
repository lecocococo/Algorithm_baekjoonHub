from collections import deque

def solution(queue1, queue2):
    total_sum = sum(queue1) + sum(queue2)
    answer_sum = total_sum // 2
    q1_sum = sum(queue1)
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    answer = 0
    while queue1 and queue2:
        if q1_sum < answer_sum:
            temp_val = queue2.popleft()
            q1_sum += temp_val
            queue1.append(temp_val)
            answer += 1
        elif q1_sum > answer_sum:
            q1_sum -= queue1.popleft()
            answer += 1
        else:
            return answer

    return -1