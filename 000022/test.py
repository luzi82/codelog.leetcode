import code

def tt(n,v):
    print(n,v)
    xx = code.Solution()
    vv = xx.generateParenthesis(n)
    print(vv)
    assert(set(v)==set(vv))

    
tt(3,[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
])
tt(0,[])
