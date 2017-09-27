class SortedSet(object):
    
    def __init__(self):
        self.root = None
        self._len = 0
    
    def add(self,v):
        if self.root == None:
            self.root = SSNode(None, v)
        else:
            p = self.root
            while(True):
                if v < p.v:
                    if p.left == None:
                        p.left = SSNode(p, v)
                        break
                    else:
                        p = p.left
                else:
                    if p.right == None:
                        p.right = SSNode(p,v)
                        break
                    else:
                        p = p.right
        self._len += 1
    
    def get_min(self):
        if self.root == None:
            return None
        p = self.root
        while(p.left != None):
            p = p.left
        return p.v

    def pop_min(self):
        if self.root == None:
            return None
        p = self.root
        while(p.left != None):
            p = p.left
        v = p.v
        pp = p.parent
        right = p.right
        if pp is not None:
            pp.left = right
        else:
            self.root = right
        if right is not None:
            right.parent = pp
        self._len -= 1
        return v

    def get_max(self):
        if self.root == None:
            return None
        p = self.root
        while(p.right != None):
            p = p.right
        return p.v

    def pop_max(self):
        if self.root == None:
            return None
        p = self.root
        while(p.right != None):
            p = p.right
        v = p.v
        pp = p.parent
        left = p.left
        if pp is not None:
            pp.right = left
        else:
            self.root = left
        if left is not None:
            left.parent = pp
        self._len -= 1
        return v
    
    def __len__(self):
        return self._len

    def _rotate_left(self,n):
        nnew = n.right
        assert(nnew!=None)
        n.right = nnew.left
        nnew.left = n
        nnew.parent = n.parent
        n.parent = nnew
    
    def _rotate_right(self,n):
        nnew = n.left
        assert(nnew!=None)
        n->left = nnew.right
        nnew.right = n
        nnew.parent = n.parent
        n.parent = nnew

    def _insert(self, n):
        root = self.root
        self._insert_recurse(root, n)
        self._insert_repair_tree(n)
        root = n
        while root.parent != None:
            root = root.parent
        self.root = root

    def _insert_recurse(self, root, n):
        if (root != None) and ( n.v < root.v ):
            if root.left != None:
                self._insert_recurse(root.left, n)
                return
            else:
                root.left = n
        else if (root != None) :
            if root.right != None:
                self._insert_recurse(root.right, n)
                return
            else:
                root.right = n

        n.parent = root

    def _uncle(self,n):
        if n == None:
            return None
        p = n.parent
        if p == None
            return None
        pp = p.parent
        if pp == None
            return None
        if pp.left == p
            return pp.right
        else:
            return pp.left
        
    def _insert_repair_tree(self, n):
        if n.parent == None:
            self._insert_case1(n)
        elif n.parent.color == BLACK:
            self._insert_case2(n)
        elif self._uncle(n).color == RED:
            self._insert_case3(n)
        else
            self._insert_case4(n)

    def _insert_case1(self,n):
        if n.parent == None:
            n.color = BLACK

    def _insert_case2(self,n):
        pass

    def _insert_case3(self,n):
        n.parent.color = BLACK
        self._uncle(n).color = BLACK
        n.parent.parent.color = RED
        self._insert_repair_tree(n.parent.parent)

    def _insert_case4(self,n):
        p = n.parent
        pp = p.parent
        
        if n == pp.left.right:
            self._rotate_left(p)
            n = n.left
        elif n == pp.right.left:
            self._rotate_right(p)
            n = n.right
        
        if n == p.left:
            self._rotate_right(g)
        else
            self._rotate_left(g)
        
        p.color = BLACK
        g.color = RED

    def _delete_one_child...

BLACK = 1
RED = 0

class SSNode(object):
    
    def __init__(self, p, v):
        self.v = v
        self.parent = p
        self.left = None
        self.right = None
        self.color = RED

def test():
    import random
    ss = SortedSet()
    mirror = []
    for _ in range(10000):
        action_list = []
        if len(mirror) > 0:
            action_list.append('pop_min')
            action_list.append('pop_max')
        if len(mirror) > 30:
            action_list.append('pop_min')
            action_list.append('pop_max')
        if len(mirror) < 100:
            action_list.append('add')
            action_list.append('add')
        action = random.choice(action_list)
        if action == 'add':
            v = random.randint(0,100)
            mirror.append(v)
            ss.add(v)
        elif action == 'pop_min':
            v = ss.pop_min()
            vv = min(mirror)
            mirror.remove(vv)
            assert(v==vv)
        elif action == 'pop_max':
            v = ss.pop_max()
            vv = max(mirror)
            mirror.remove(vv)
            assert(v==vv)
        else:
            assert(False)
        print mirror
        assert(len(mirror)==len(ss))
        if len(mirror) > 0:
            assert(min(mirror)==ss.get_min())
            assert(max(mirror)==ss.get_max())

if __name__ == "__main__":
    test()
