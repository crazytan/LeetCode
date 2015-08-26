__author__ = 'tan'


class Solution(object):
    def isUgly(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False
        if num == 1:
            return True
        while num % 2 == 0:
            num /= 2
        while num % 3 == 0:
            num /= 3
        while num % 5 == 0:
            num /= 5
        if num == 1:
            return True
        return False

if __name__ == '__main__':
    print Solution().isUgly(int(raw_input("enter num: ")))
