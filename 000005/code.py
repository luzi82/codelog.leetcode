class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        self.s = s

        # odd
        best1_center = None
        best1_r = -1
        r1 = [None for i in range(len(s))]

        last_center = None
        last_r = None

        for i in range(len(s)):
            if i == 0:
                best1_center = i
                best1_r = 0
                last_center = i
                last_r = 0
                r1[i]=0
                continue
        
            mirror_center = last_center - (i - last_center)
            if mirror_center < 0:
                r_start = 0
            else:
                mirror_radius = r1[mirror_center]
                if i + mirror_radius >= last_center+last_r:
                    r_start = mirror_radius
                else:
                    r1[i] = mirror_radius
                    continue
                
            radius = self.z1(i, r_start)
            r1[i] = radius
            if radius > r_start:
                last_center = i
                last_r = radius
                if radius > best1_r:
                    best1_r = radius
                    best1_center = i

        len1 = best1_r*2+1

        # even
        best0_center = 0
        best0_r = 0
        r0 = [None for i in range(len(s))]

        last_center = None
        last_r = None

        r_start = 0
        for i in range(len(s)-1):
            r_start = r_start - 1
            r_start = max(0, r_start)
            radius = self.z0(i, r_start)
            r_start = radius
            if radius > best0_r:
                best0_center = i
                best0_r = radius

        len0 = best0_r*2

        if len1>len0:
       return s[best1_center-best1_r:best1_center+best1_r+1]
        else:
            return s[best1_center-best1_r:best1_center+best1_r]

        
    def z1(self, center, r_start): # odd number, return radius
        # ---c---
        # 3210123
        r = r_start
        
        while(True):
            next_r = r+1
            if center-next_r < 0:
                break
            if center+next_r >= len(self.s):
                break
            if self.s[center-next_r] != self.s[center+next_r]:
                break
            r=next_r
            
        return r


    def z0(self, center, r_start): # event number, return radius
        # ---c---
        # 2100123

        r = r_start
        
        while(True):
            next_r = r+1
            if center-next_r < 0:
                break
            if center+next_r-1 >= len(self.s):
                break
            if self.s[center-next_r] != self.s[center+next_r-1]:
                break
            r=next_r
            
        return r
