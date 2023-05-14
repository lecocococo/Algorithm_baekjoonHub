a = int(input())
minus=[]
plus=[]
for i in range(a):
    n = int(input())
    if n<=0:
        minus.append(n)
    elif n>0:
        plus.append(n)
minus.sort()
plus.sort(reverse=True)
# print(minus)
# print(plus)
m_cnt = 0
p_cnt = 0
for i in range(0,len(minus),2):
    if minus[i]==0:
        break
    else:
        if i+1==len(minus):
            continue
        if minus[i+1] !=0:
            temp = minus[i] * minus[i+1]
        else:
            temp=0
        m_cnt+=temp
        
if len(minus)%2==1:
    m_cnt+=minus[len(minus)-1]
        
for i in range(0,len(plus),2):
    
    if plus[i]==1:
        p_cnt+=(len(plus) - i)
        break
    else:
        if i+1==len(plus):
            continue
        if plus[i+1]!=1:
            temp = plus[i] * plus[i+1]
        elif plus[i+1]==1:
            temp = plus[i] + plus[i+1]
        p_cnt+=temp
if len(plus)%2==1 and plus[len(plus)-1]!=1:
        p_cnt+=plus[len(plus)-1]
print(m_cnt+p_cnt)