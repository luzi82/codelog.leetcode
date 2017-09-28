# https://leetcode.com/problems/lru-cache/description/
#from collections import deque

class LRUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.dd = {}
        self.ts = set()
        self.tk = {}
        self.kt = {}
        self.next_t = 1

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if key in self.dd:
            old_t = self.kt[key]
            self.ts.remove(old_t)
            del self.tk[old_t]

            new_t = self.next_t
            self.next_t += 1
            
            self.ts.add(new_t)
            self.tk[new_t] = key
            self.kt[key] = new_t
            
            return self.dd[key]
        return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        #print ('add '+str(key))
        #print(self.ts,self.tk,self.kt,self.dd)

        key_exist = key in self.dd
        
        if key_exist:
            old_t = self.kt[key]
            old_k = key
            self.ts.remove(old_t)
            del self.tk[old_t]
            del self.kt[old_k]
            del self.dd[old_k]
        
        #print ('key_exist '+str(key_exist))
        if (len(self.dd) >= self.capacity):
            old_t = min(self.ts)
            old_k = self.tk[old_t]
            self.ts.remove(old_t)
            del self.tk[old_t]
            del self.kt[old_k]
            del self.dd[old_k]
            
        #print(len(self.dd),len(self.qq))
        
        new_t = self.next_t
        self.next_t += 1

        self.ts.add(new_t)
        self.tk[new_t] = key
        self.kt[key] = new_t
        self.dd[key] = value
        #self.qq.appendleft(key)
        
        #print(self.ts,self.tk,self.kt,self.dd)


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
