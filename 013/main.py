__author__ = 'tan'


class Solution:
    # @param {string} s
    # @return {integer}
    def romanToInt(self, s):
        s = s.replace('CM', 'DCD').replace('XC', 'LXL').replace('IX', 'VIV')
        s = s.replace('CD', 'CCCC').replace('XL', 'XXXX').replace('IV', 'IIII')
        val = {'M': 1000,
               'D': 500,
               'C': 100,
               'L': 50,
               'X': 10,
               'V': 5,
               'I': 1}
        ans = 0
        for ch in s:
            ans += val[ch]
        return ans

if __name__ == '__main__':
    s = raw_input("enter the roman: ")
    print Solution().romanToInt(s)
