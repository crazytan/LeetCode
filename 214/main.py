__author__ = 'tan'


class Solution:
    # @param {string} s
    # @return {string}
    def shortestPalindrome(self, s):
        if len(s) <= 1: return s
        max = 0
        rr = -1
        head = 0
        for i in xrange(1, len(s)):
            if s[i] != s[i - 1]:
                l, r = self.findMaximum(s, head, i - 1)
                if (l == 0) and ((r - l + 1) > max):
                    max = r - l + 1
                    rr = r
                head = i
        if head == 0:
            return s
        sub = s[rr + 1:]
        return sub[::-1] + s

    def findMaximum(self, s, l, r):
        while (l > 0) and (r < (len(s) - 1)):
            if s[l - 1] != s[r + 1]:
                break
            l -= 1
            r += 1
        return l, r

if __name__ == '__main__':
    s = raw_input("enter s: ")
    print Solution().shortestPalindrome(s)
