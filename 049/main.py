class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        chars = [chr(i) for i in range(ord('a'), ord('a') + 26)]
        s_map = {}
        for word in strs:
            cnt = {}
            for ch in word:
                if ch in cnt:
                    cnt[ch] += 1
                else:
                    cnt[ch] = 1
            s = ""
            for ch in chars:
                if ch in cnt:
                    s += str(cnt[ch])
                else:
                    s += "0"
            if s in s_map:
                s_map[s].append(word)
            else:
                s_map[s] = [word]
        ans = []
        for s in s_map:
            ans.append(sorted(s_map[s]))
        return ans


if __name__ == "__main__":
    print Solution().groupAnagrams([])
