class Solution(object):
    def largestCombination(self, candidates):
        """
        :type candidates: List[int]
        :rtype: int
        """
        if not candidates:
            return 0

        limit_bits = max(candidates).bit_length()
        res = 0

        for b in range(limit_bits):
            mask = 1 << b #creating the bitmask set to 1 and all other bits to 0
            cnt = 0
            for x in candidates:
                if x & mask:
                    cnt+=1
            res = max(res, cnt)
        return res
        