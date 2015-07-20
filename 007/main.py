__author__ = 'tan'


class Solution:
    # @param {integer} x
    # @return {integer}
    def reverse(self, x):
        neg = False
        if x < 0:
            neg = True
            x = -x
        ans = 0
        while x > 0:
            ans = ans * 10 + x % 10
            x /= 10
        if neg:
            ans = -ans
        if ans > (2**31 - 1):
            ans = 0
        if ans < (-2**31):
            ans = 0
        return ans

if __name__ == "__main__":
    x = int(raw_input("enter x: "))
    print Solution().reverse(x)
