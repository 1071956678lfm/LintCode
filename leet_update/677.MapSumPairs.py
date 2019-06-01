class MapSum(object):
    """
    Implement a MapSum class with insert,
    and sum methods.

    For the method insert, you'll be given a pair of (string, integer).
    The string represents the key and the integer represents the value.
    If the key already existed, then the original key-value pair will be overridden to the new one.

    For the method sum, you'll be given a string representing the prefix,
     and you need to return the sum of all the pairs' value whose key starts with the prefix.
    """

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.dic = {}

    def insert(self, key: str, val: int) -> None:
        self.dic[key] = val

    def sum(self, prefix: str) -> int:
        sum = 0
        for k, v in self.dic.items():
            if k.startswith(prefix):
                sum += v
        return sum


m = MapSum()
m.insert('ab',3)
m.insert('abc',4)
print(m.sum('a'))
