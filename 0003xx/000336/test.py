import code
import random
import string

def tt(words,v):
    print(words,v)
    xx = code.Solution()
    vv = xx.palindromePairs(words)
    print(vv)
    assert(sorted(vv) == sorted(v))

tt(["bat", "tab", "cat"],[[0, 1], [1, 0]])
tt(["abcd", "dcba", "lls", "s", "sssll"],[[0, 1], [1, 0], [3, 2], [2, 4]])
tt(["a","abc","aba",""],[[0,3],[3,0],[2,3],[3,2]])
tt(["a","aa","aaa"],[[1,0],[0,1],[2,0],[1,2],[2,1],[0,2]])
