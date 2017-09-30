def cal_palindrome_radius(s, dummy='_'):
    # edge cases
    if len(s) == 0:
        return []
    if len(s) == 1:
        return [0]
    
    # si: insert dummy in middle of each char in s
    si = dummy.join(s)
    
    # ri_list: cal radius on each si char
    ri_list = [ None ] * len(si)

    ## center of palindrome reach of Right Most char of si
    ## si[c-r:c+r+1] , c=center, r=radius
    rm_center = None

    ## check all palindrome center from left to right
    
    for c in range(len(si)):
        if c == 0:
            rm_center = 0
            ri_list[0] = 0
            continue
            
        ri = 0 # radius at c
        
        ## use last right most palindrome to get min value of r
        rm_right = rm_center + ri_list[rm_center]
        if c < rm_right:
            mirror_c = rm_center - (c-rm_center)
            ri = min(rm_right-c,ri_list[mirror_c])
        
        ## expend r if possible to expend
        if c+ri >= rm_right:
            while(True):
                next_ri     = ri+1
                next_left  = c-next_ri
                next_right = c+next_ri
                if next_left < 0:
                    break
                if next_right >= len(si):
                    break
                if si[next_left] != si[next_right]:
                    break
                ri = next_ri
            # renew right most palindrome found
            if c+ri > rm_right:
                rm_center = c
        
        ri_list[c] = ri
    
    # r_list: remove dummy effect from ri_list
    r_list = [None] * len(si)
    for c, ri in zip(range(len(si)),ri_list):
        if c%2 == 0: # even index, odd len
            r_list[c] = ri_list[c] // 2
        else: # odd index, even len
            r_list[c] = (ri_list[c]+1) // 2
    
    # return r_list
    return r_list

def check_palindrome(s,lo=0,hi=None):
    if hi is None:
        hi = len(s)

    if lo < 0:
        return False
    if hi > len(s):
        return False
    if lo == hi:
        return True

    hi -= 1
    while hi>lo:
        if s[lo]!=s[hi]:
            return False
        lo+=1
        hi-=1

    return True
