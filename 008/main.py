__author__ = 'tan'


class Solution:
    # @param {string} str
    # @return {integer}
    def myAtoi(self, str):
        str = str = str.strip()
        if str == '':
            return 0
        neg = False
        if str[0] == '-':
            neg = not neg
            str = str[1:]
        elif str[0] == '+':
            str = str[1:]
        if str == '':
            return 0
        ans = 0
        for ch in str:
            if (ch >= '0') and (ch <= '9'):
                ans = ans * 10 + int(ch)
            else:
                break
        if neg:
            ans = -ans
        if ans > (2**31 - 1):
            ans = 2**31 - 1
        if ans < (-2**31):
            ans = -2**31
        return ans

if __name__ == "__main__":
    s = raw_input("enter the string: ")
    print Solution().myAtoi(s)
