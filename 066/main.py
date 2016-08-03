class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        if not len(digits):
            return [1]
        digits = digits[::-1]
        digits[0] += 1
        carry = digits[0] / 10
        digits[0] %= 10
        i = 1
        while (i < len(digits)) and carry:
            digits[i] += 1
            carry = digits[i] / 10
            digits[i] %= 10
            i += 1
        if carry:
            digits.append(1)
        return digits[::-1]

if __name__ == "__main__":
    print Solution().plusOne([9, 9, 9])
