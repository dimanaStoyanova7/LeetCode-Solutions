class Solution(object):
    def beforeAndAfterPuzzles(self, phrases):
        """
        :type phrases: List[str]
        :rtype: List[str]
        """
        n = len(phrases)
    # Precompute first word, last word, and (for convenience) the remainder of each phrase after the first word
        first = []
        last = []
        remainder_after_first = []
        for s in phrases:
            sp = s.split()
            first.append(sp[0])
            last.append(sp[-1])
            # Portion of s after the first word (including the leading space if present)
            if len(sp) == 1:
                remainder_after_first.append("")  # no remainder
            else:
                remainder_after_first.append(s[len(sp[0]):])  # leading space + rest

        # Map first word -> list of indices starting with that word
        idx_by_first = defaultdict(list)
        for i, w in enumerate(first):
            idx_by_first[w].append(i)

        out = set()
        # For each phrase i, find phrases j whose first word matches i's last word
        for i in range(n):
            lw = last[i]
            if lw not in idx_by_first:
                continue
            for j in idx_by_first[lw]:
                if i == j:
                    continue
                # Merge: phrase_i + (phrase_j without its first word)
                merged = phrases[i] + remainder_after_first[j]
                out.add(merged)

        return sorted(out)
            