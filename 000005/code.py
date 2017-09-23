import math

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        ss = '.'.join(list(s))
        #print(ss)
        left, right = self.lp1(ss)
        #print(ss[left:right])
        #left = int(math.floor((left+1)/2))
        #right = int(math.floor((right+1)/2))
        return s[left:right]

    def lp1(self, s): # return (left, right)
        self.s = s
        
        best_left = None
        best_right = None
        r1 = [None for i in range(len(s))]

        last_center = None
        last_r = None

        for i in range(len(s)):
            if i == 0:
                best_left = 0
                best_right = 1
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
                    r_start = last_center+last_r-i
                else:
                    r1[i] = mirror_radius
                    continue
            
                
            radius = self.z1(i, r_start)
            #print(s, i, r_start,radius, s[i-radius:i+radius+1])
            r1[i] = radius
            if radius > r_start:
                last_center = i
                last_r = radius

            my_left = i-radius
            my_left = int((my_left+1)/2)
            my_right = i+radius+1
            my_right = int((my_right+1)/2)
            if my_right-my_left > best_right-best_left:
                best_left = my_left
                best_right = my_right

        return (best_left, best_right)

        
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
