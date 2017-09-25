import code

def tt(s,wordDict,v):
    print(s,wordDict,v)
    xx = code.Solution()
    vv = xx.wordBreak(s,wordDict)
    print(vv)
    assert(vv==v)

    
tt("leetcode",["leet", "code"],True)
tt("leetcodex",["leet", "code"],False)
tt("eetcode",["leet", "code"],False)
tt("eetcode",["eet", "tcode"],False)
tt("eetcode",["eet", "tcode",'code'],True)
