__author__ = 'tan'


class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLongestSubstring(self, s):
        ans = 0
        leng = 0
        ch_set = {}
        index = -1
        for ch in s:
            index += 1
            if ch not in ch_set:
                ch_set[ch] = index
                leng += 1
            else:
                ans = leng if leng > ans else ans
                leng = index - ch_set[ch]
                index_ = ch_set[ch]
                ch_set = {}
                for i in xrange(index_ + 1, index + 1):
                    ch_set[s[i]] = i
        ans = leng if leng > ans else ans
        return ans

if __name__ == '__main__':
    s = raw_input("Please enter the string: ")
    print Solution().lengthOfLongestSubstring(s)
