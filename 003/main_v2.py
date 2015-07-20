__author__ = 'tan'


class Solution:
    # @param {string} s
    # @return {integer}
    def lengthOfLongestSubstring(self, s):
        if s == '':
            return 0
        ans = 0
        head = 0
        arr = {s[0]: 0}
        index = 0
        for ch in s[1:]:
            index += 1
            if (ch in arr) and (arr[ch] >= head):
                if (index - head) > ans:
                    ans = index - head
                head = arr[ch] + 1
            arr[ch] = index
        if (len(s) - head) > ans:
            ans = len(s) - head
        return ans

if __name__ == '__main__':
    s = raw_input("Please enter the string: ")
    print Solution().lengthOfLongestSubstring(s)
