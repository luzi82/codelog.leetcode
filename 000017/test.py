import code

def tt(digits,ret):
    print(digits,ret)
    xx = code.Solution()
    vv = xx.letterCombinations(digits)
    print(vv)
    assert(set(vv)==set(ret))

tt("23",["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"])
