__author__ = 'tan'


class Solution:
    # @param {string} s
    # @param {string} p
    # @return {boolean}
    def isMatch(self, s, p):
        f = [[False for x in range(len(p)+1)] for x in range(len(s)+1)]
        f[0][0] = True
        for j in xrange(1, len(p)+1):
            for i in xrange(len(s)+1):
                if f[i][j-1]:
                    if (i < len(s)) and (p[j-1] == '.'):
                        f[i+1][j] = True
                    elif p[j-1] == '*':
                        if p[j-2] == '.':
                            t = i-1
                            while t <= len(s):
                                f[t][j] = True
                                t += 1
                        else:
                            f[i-1][j] = True
                            f[i][j] = True
                            t = i
                            while (t < len(s)) and (s[t] == s[t-1]):
                                f[t+1][j] = True
                                t += 1
                    else:
                        if (i < len(s)) and (s[i] == p[j-1]):
                            f[i+1][j] = True
                        if (j < len(p)) and (p[j] == '*'):
                            f[i][j+1] = True
        return f[len(s)][len(p)]

if __name__ == '__main__':
    s = raw_input("enter s: ")
    p = raw_input("enter p: ")
    print Solution().isMatch(s, p)
