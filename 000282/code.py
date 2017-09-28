class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        
        result = []
        
        self.dfs(num,target,0,0,0,"",result)
        
        return result
    
    def dfs(self, num, target, i, ssum, product, prefix, result):
        if i == len(num):
            if ssum + product == target:
                result.append(prefix)
            return

        for j in range(i+1,len(num)+1):
            if (num[i] == '0') and (j-i>1):
                break
            ij_num = int(num[i:j])
            if i == 0:
                self.dfs(num,target,j,0,ij_num,str(ij_num),result)
            else:
                self.dfs(num,target,j,ssum+product,        ij_num,'{}+{}'.format(prefix,ij_num),result)
                self.dfs(num,target,j,ssum+product,       -ij_num,'{}-{}'.format(prefix,ij_num),result)
                self.dfs(num,target,j,ssum        ,product*ij_num,'{}*{}'.format(prefix,ij_num),result)
