__author__ = 'tan'


class Solution:
    # @param {integer} x
    # @return {boolean}
    def isPalindrome(self, x):
        if x == 0:
            return True
        if x < 0:
            return False
        n = 1
        l = 0
        while n <= x:
            n *= 10
            l += 1
        for i in xrange(1, l / 2 + 1):
            if self.digitAt(x, i) != self.digitAt(x, l - i + 1):
                return False
        return True

    def digitAt(self, x, i):
        return (x / 10**(i-1)) % 10

if __name__ == "__main__":
    x = int(raw_input("enter the integer: "))
    print Solution().isPalindrome(x)
