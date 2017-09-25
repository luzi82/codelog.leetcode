import code

def tt(s,wordDict,v):
    print(s,wordDict,v)
    xx = code.Solution()
    vv = xx.wordBreak(s,wordDict)
    print(vv)
    assert(set(vv)==set(v))

    
tt("leetcode",["leet", "code"],["leet code"])
tt("leetcodex",["leet", "code"],[])
tt("eetcode",["leet", "code"],[])
tt("eetcode",["eet", "tcode"],[])
tt("eetcode",["eet", "tcode",'code'],['eet code'])
tt('catsanddog',["cat", "cats", "and", "sand", "dog"],["cats and dog", "cat sand dog"])
