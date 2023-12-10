import sys

def check(str,left,right):
    while left < right:
        if str[left] == str[right]:
            left+=1
            right-=1
        else:
            return False
    return True

def pelin(a,left,right):
    while left<right:
        if a[left] == a[right]:
            left+=1
            right-=1
        else:
            c1 = check(a,left+1,right)
            c2 = check(a,left,right-1)
            if c1 or c2:
                return 1
            else:
                return 2
    return 0 

t = int(sys.stdin.readline().rstrip())

for i in range(t):
    a=list(sys.stdin.readline().rstrip())
    result = pelin(a,0,len(a)-1)
    print(result)