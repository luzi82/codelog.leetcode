import math

class Solution:
    def nthUglyNumber(self, n: int, a: int, b: int, c: int) -> int:
        ab = a*b//math.gcd(a,b)
        bc = b*c//math.gcd(b,c)
        ac = a*c//math.gcd(a,c)
        abc = ab*c//math.gcd(ab,c)
        #print(('HHEOVWVRAB',ab,bc,ac,abc))
        #return 0
        
        ret_min = 1
        ret_max = 2*10**9+1
        
        while True:
            ret_mid = (ret_min + ret_max) // 2
            #print(('KJVCZKFJEX',ret_mid))
            fa = ret_mid // a
            fb = ret_mid // b
            fc = ret_mid // c
            fab = ret_mid // ab
            fbc = ret_mid // bc
            fac = ret_mid // ac
            fabc = ret_mid // abc
            
            nn = fa + fb + fc - fab - fbc - fac + fabc
            #print(('PXZTFBWTYJ',fa,fb,fc,fab,fbc,fac,fabc,nn))
            
            if nn < n:
                ret_min = ret_mid
                continue
            if nn > n:
                ret_max = ret_mid
                continue

            if ret_mid % a == 0:
                return ret_mid
            if ret_mid % b == 0:
                return ret_mid
            if ret_mid % c == 0:
                return ret_mid
            
            ret_max = ret_mid
