__author__ = 'tan'


class Solution:
    # @param {string} s
    # @return {string}
    def longestPalindrome(self, s):
        if s == '': return 0
        ans = 0
        result = ''
        head = 0
        for i in xrange(1, len(s)):
            if s[i] != s[i - 1]:
                length, palin = self.findMaximum(s, head, i - 1)
                if length > ans:
                    ans = length
                    result = palin
                head = i
        if (len(s) - head) > ans:
            result = s[head:len(s)]
        return result

    def findMaximum(self, s, l, r):
        while (l > 0) and (r < (len(s) - 1)):
            if s[l - 1] != s[r + 1]:
                break
            l -= 1
            r += 1
        return r - l + 1, s[l:r + 1]

if __name__ == "__main__":
    s = raw_input("enter the string: ")
    print Solution().longestPalindrome(s)
