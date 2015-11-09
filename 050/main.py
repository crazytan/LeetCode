class Solution(object):
    def myPow(self, x, n):
        """
        :type x: float
        :type n: int
        :rtype: float
        """
        if not n:
            return 1
        if not x:
            return 0
        if n < 0: return 1 / self.myPow(x, -n)
        if n == 1:
            return x
        pow = self.myPow(x, n / 2)
        if n % 2:
            return pow * pow * x
        return pow * pow

if __name__ == "__main__":
    print Solution().myPow(1.3, -5)
