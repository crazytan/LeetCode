__author__ = 'tan'


class Solution:
    # @param {integer} numerator
    # @param {integer} denominator
    # @return {string}
    def fractionToDecimal(self, numerator, denominator):
        if not numerator: return '0'
        neg = False
        if numerator < 0:
            neg = not neg
            numerator = -numerator
        if denominator < 0:
            neg = not neg
            denominator = -denominator
        dec = numerator / denominator
        numerator %= denominator
        if not numerator:
            return ('-' if neg else '') + str(dec)
        index = 0
        dic = {}
        ans = ''
        numerator *= 10
        while numerator:
            if numerator in dic:
                break
            else:
                dic[numerator] = index
                index += 1
                ans += str(numerator / denominator)
                numerator %= denominator
                numerator *= 10
        if not numerator:
            return ('-' if neg else '') + str(dec) + '.' + ans
        return ('-' if neg else '') + str(dec) + '.' + ans[:dic[numerator]] + '(' + ans[dic[numerator]:] + ')'

if __name__ == '__main__':
    numerator = int(raw_input("enter the numerator: "))
    denominator = int(raw_input("enter the denominator: "))
    print Solution().fractionToDecimal(numerator, denominator)
