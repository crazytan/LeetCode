__author__ = 'tan'


class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        s.strip()
        words = filter(None, s.split(' '))
        words = words[::-1]
        return ' '.join(words)

if __name__ == '__main__':
    s = raw_input("input s: ")
    print Solution().reverseWords(s)
