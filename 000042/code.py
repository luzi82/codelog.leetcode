class Solution(object):

    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) <= 2:
            return 0
        
        # 0,1,0,2,1,0,1,3,2,1,2,1
        min_height = min(height)
        
        # 0,0,1,1,2,2,2,2,3,3,3,3
        left_max = [None]*len(height)
        m = min_height
        for i in range(len(height)):
            if i != 0:
                m = max(m,height[i-1])
            left_max[i] = m

        # 3,3,3,3,3,3,3,2,2,2,1,0
        right_max = [None]*len(height)
        m = min_height
        for i in reversed(range(len(height))):
            if i != len(height) - 1:
                m = max(m,height[i+1])
            right_max[i] = m
        
        # 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        water_level = [None]*len(height)
        for i in range(len(height)):
            water_level[i] = min(left_max[i],right_max[i])

        # 0,-1, 1,-1, 1, 2, 1,-1, 0, 1,-1,-1
        water_height = [None]*len(height)
        for i in range(len(height)):
            water_height[i] = water_level[i] - height[i]

        #0, 0, 1, 0, 1, 2, 1, 0, 0, 1, 0, 0
        water_count = [None]*len(height)
        for i in range(len(height)):
            water_count[i] = max(0,water_height[i])

        answer = sum(water_count)
        
        return answer
