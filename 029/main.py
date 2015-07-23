__author__ = 'tan'


class Solution:
    # @param {integer} dividend
    # @param {integer} divisor
    # @return {integer}
    def divide(self, dividend, divisor):
        neg = 1
        if dividend < 0:
            dividend = -dividend
            neg = -neg
        if divisor < 0:
            divisor = -divisor
            neg = -neg
        ans = 0
        mul = 1
        div = divisor
        while dividend >= divisor:
            if dividend >= div:
                dividend -= div
                ans += mul
                div <<= 1
                mul <<= 1
            else:
                div = divisor
                mul = 1
        if (neg > 0) and (ans > (2**31 - 1)):
            return 2**31 - 1
        if (neg < 0) and (ans > 2**31):
            return -2**31
        return ans * neg


if __name__ == '__main__':
    dividend = int(raw_input("input dividend: "))
    divisor = int(raw_input("input divisor: "))
    print Solution().divide(dividend, divisor)
