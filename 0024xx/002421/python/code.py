from typing import List
import collections
import math

class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
      val2IdxListDict = {}
      for i in range(len(vals)):
        if vals[i] not in val2IdxListDict:
          val2IdxListDict[vals[i]] = []
        val2IdxListDict[vals[i]].append(i)

      valUniqList = sorted(list(set(vals)))

      val2EdgeListDict = {}
      for ab in edges:
        a,b = ab
        maxVal = max(vals[a],vals[b])
        if maxVal not in val2EdgeListDict:
          val2EdgeListDict[maxVal] = []
        val2EdgeListDict[maxVal].append(ab)

      idxToUidxList = list(range(len(vals)))
      ret = 0

      for val in valUniqList:
        if val in val2EdgeListDict:
          edgeList = val2EdgeListDict[val]
          for ab in edgeList:
            a,b = ab
            self.join(idxToUidxList, a, b)

        uidxToNodeList = {}

        for idx in val2IdxListDict[val]:
          uidx = self.uidx(idxToUidxList,idx)
          if uidx not in uidxToNodeList:
            uidxToNodeList[uidx] = []
          uidxToNodeList[uidx].append(idx)
        
        for k,v in uidxToNodeList.items():
          cnt = len(v)
          #print(val, k, cnt)
          ret += cnt * (cnt-1) // 2
          ret += cnt
      
      return ret
      
    def join(self,idxToUidxList,a,b):
      if a > b:
        idxToUidxList[a] = self.uidx(idxToUidxList,b)
      else:
        uidx = self.uidx(idxToUidxList,a)
        if uidx < b:
          idxToUidxList[b] = uidx
        else:
          idxToUidxList[uidx] = b
    
    def uidx(self,idxToUidxList,idx):
      if idxToUidxList[idx] == idx:
        return idx
      ret = self.uidx(idxToUidxList,idxToUidxList[idx])
      idxToUidxList[idx] = ret
      return ret
