__author__ = 'tan'


class Solution:
    # @param {string[]} strs
    # @return {string}
    def longestCommonPrefix(self, strs):
        if not strs:
            return ''
        ans = ''
        i = 0
        while i < len(strs[0]):
            ch = strs[0][i]
            for str in strs:
                if (i >= len(str)) or (str[i] != ch):
                    return ans
            ans += ch
            i += 1
        return ans

if __name__ == '__main__':
    s = raw_input("enter the strings: ").split(',')
    print Solution().longestCommonPrefix(s)
