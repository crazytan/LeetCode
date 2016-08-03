class ValidWordAbbr(object):
    def __init__(self, dictionary):
        """
        initialize your data structure here.
        :type dictionary: List[str]
        """
        self.dict = set()
        self.if_occur = {}
        for word in dictionary:
            if word not in self.dict:
                self.dict.add(word)
                abbr = self.abbrev(word)
                if abbr in self.if_occur:
                    self.if_occur[abbr] += 1
                else:
                    self.if_occur[abbr] = 1

    def abbrev(self, word):
        if len(word) <= 2:
            return word
        return word[0] + str(len(word) - 2) + word[-1]

    def isUnique(self, word):
        """
        check if a word is unique.
        :type word: str
        :rtype: bool
        """
        if word in self.dict:
            return self.if_occur[self.abbrev(word)] == 1
        else:
            return self.abbrev(word) not in self.if_occur

if __name__ == "__main__":
     vwa = ValidWordAbbr([ "hello"])
     print vwa.isUnique("hello")
     print vwa.isUnique("cart")
     print vwa.isUnique("cane")
     print vwa.isUnique("make")
