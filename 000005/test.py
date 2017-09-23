import code

def tt(s,v):
    print(s)
    xx = code.Solution()
    vv = xx.longestPalindrome(s)
    print(vv)
    assert(len(vv)==v)

    
tt('babad',3)
tt('abb',2)
tt('banana',5)
tt('asdfdsa',7)
tt('qasdfdsappdkfahf',7)

tt('asdfccccasdf',4)
tt('asdaccccasdf',6)
tt("babadada",5)