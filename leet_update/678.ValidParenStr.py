"""
Given a string containing only three types of characters: '(', ')' and '*',
write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.

"""


class Solution:

    def checkValidString(self, s: str) -> bool:
        stack = []
        for index, ch in enumerate(s):
            if ch == '(' or ch == '*':
                stack.append(ch)
            elif ch == ')':
                if len(stack) == 0:
                    return False
                else:
                    if stack.count('(') == 0:
                        stack.pop()
                    else:
                        index = -1
                        while stack[index] != '(':
                            index -= 1
                        stack.pop(index)
            else:  # * condition
                stack.append(ch)

        if stack.count(')') != 0:
            return False
        if stack.count('(') == 0:
            return True
        else:  # 只含有 * , (
            index = stack.index('(')
            stack = stack[index:]
            tmp = []
            for item in stack:
                if item == '(':
                    tmp.append(item)
                else:  # *
                    if len(tmp) != 0:
                        tmp.pop(-1)
            return tmp.count('(') == 0


print(Solution().checkValidString("(())(())(((()*()()()))()((()()(*()())))(((*)()"))
