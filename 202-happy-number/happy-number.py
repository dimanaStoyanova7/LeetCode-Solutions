class Solution:
    def isHappy(self, n: int) -> bool:
        # 19 -> 1 + 81 = 82 -> 68 -> 100 -> 1 
        seen = set()
        def next_num(x: int) -> int:
            sum = 0
            while x:
                x,d = divmod(x,10)
                sum += d*d
            return sum
        while n!=1 and n not in seen: # n is seen means we will loop
            seen.add(n)
            n = next_num(n)
        return n == 1
        