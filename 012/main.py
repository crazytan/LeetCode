__author__ = 'tan'


class Solution:
    # @param {integer} num
    # @return {string}
    def intToRoman(self, num):
        cnt = [0 for i in range(7)]
        quant = [1000, 500, 100, 50, 10, 5, 1]
        roman = ['M', 'D', 'C', 'L', 'X', 'V', 'I']
        for i in xrange(7):
            while num >= quant[i]:
                cnt[i] += 1
                num -= quant[i]
        str = ''
        for i in xrange(7):
            if cnt[i] > 0:
                if cnt[i] <= 3:
                    str += roman[i] * cnt[i]
                else:
                    str += roman[i] + roman[i - 1]
        str = str.replace('DCD', 'CM')
        str = str.replace('LXL', 'XC')
        str = str.replace('VIV', 'IX')
        return str

if __name__ == '__main__':
    num = int(raw_input("enter the number: "))
    print Solution().intToRoman(num)
