from typing import List
import collections
import math

class Solution:
    def numberOfGoodPaths(self, vals: List[int], edges: List[List[int]]) -> int:
        edgeNodeToNodeListDict = {}
        for ab in edges:
          a,b = ab
          if a not in edgeNodeToNodeListDict:
            edgeNodeToNodeListDict[a] = []
          if b not in edgeNodeToNodeListDict:
            edgeNodeToNodeListDict[b] = []
          edgeNodeToNodeListDict[a].append(b)
          edgeNodeToNodeListDict[b].append(a)
        ret = 0
        doneNodeSet = set()
        for i in range(len(vals)):
          ret += self.dfs(i, doneNodeSet, i, vals, edgeNodeToNodeListDict)
        return ret

    def dfs(self, rootIdx, doneNodeSet, idx, vals, edgeNodeToNodeListDict):
      if vals[idx] > vals[rootIdx]: return 0
      ret = 0;
      if (idx<=rootIdx) and (vals[idx]==vals[rootIdx]):
        ret += 1
      if idx not in edgeNodeToNodeListDict:
        return ret
      doneNodeSet.add(idx)
      for node in edgeNodeToNodeListDict[idx]:
        if node in doneNodeSet: continue
        ret += self.dfs(rootIdx, doneNodeSet, node, vals, edgeNodeToNodeListDict)
      doneNodeSet.remove(idx)
      return ret
