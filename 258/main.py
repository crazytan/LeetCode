__author__ = 'tan'


class Solution(object):
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        while num > 9:
            s = 0
            while num > 0:
                s += num % 10
                num /= 10
            num = s
        return num

if __name__ == '__main__':
    for i in range(100):
        print Solution().addDigits(i)
    # print Solution().addDigits(int(raw_input("enter num: ")))
