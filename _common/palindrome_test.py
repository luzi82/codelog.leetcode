import palindrome
import string
import random

az = string.ascii_lowercase
ac = az[:3]

assert(palindrome.check_palindrome('')==True)

for _ in range(100):
    llen = random.randint(1,10)
    s_left = ''.join([ random.choice(az) for _ in range(llen) ])
    s0  = s_left + ''.join(reversed(s_left))
    s1 = s_left + ''.join(reversed(s_left[:-1]))
    assert(palindrome.check_palindrome(s0))
    assert(palindrome.check_palindrome(s1))

assert(not palindrome.check_palindrome('abc'))
assert(not palindrome.check_palindrome('abcd'))
assert(not palindrome.check_palindrome('abbb'))
assert(not palindrome.check_palindrome('abbc'))
assert(not palindrome.check_palindrome('abcbc'))

for j in range(10000):
    if j < 5:
        llen = j
    else:
        llen = random.randint(1,100)

    s = ''.join([ random.choice(ac) for _ in range(llen) ])
    palindrome_radius_list = palindrome.cal_palindrome_radius(s)
    
    #print(palindrome_radius_list)
    
    for i in range(len(s)):
        c0 = i*2
        radius0 = palindrome_radius_list[c0]
        l0 = i-radius0
        r0 = i+radius0+1

        assert(l0>=0)
        assert(l0<=len(s))
        assert(r0>=0)
        assert(r0<=len(s))
        assert(palindrome.check_palindrome(s,l0,r0))
        assert(palindrome.check_palindrome(s[l0:r0]))
        assert(not palindrome.check_palindrome(s,l0-1,r0+1))
        
        c1 = i*2 + 1
        if c1 < len(palindrome_radius_list):
            radius1 = palindrome_radius_list[c1]
            l1 = i-radius1+1
            r1 = i+radius1+1
            
            assert(palindrome.check_palindrome(s,l1,r1))
            assert(palindrome.check_palindrome(s[l1:r1]))
            assert(not palindrome.check_palindrome(s,l1-1,r1+1))
