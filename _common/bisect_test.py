import bisect

# bisect.bisect_left (l,x,hi,lo) : LIST[left]  >= x
# bisect.bisect_right(l,x,hi,lo) : LIST[right] >  x

LIST =         [  1,  3  ]
IDX  =         [  0,  1  ]

X_LIST       = [0,1,2,3,4]
BISECT_LEFT  = [0,0,1,1,2]
BISECT_RIGHT = [0,1,1,2,2]

for x, left, right in zip(X_LIST, BISECT_LEFT, BISECT_RIGHT):
    assert(bisect.bisect_left(LIST,x)==left)
    assert(bisect.bisect_right(LIST,x)==right)
    assert((left <len(LIST) and LIST[left] >=x) or (left ==len(LIST) and LIST[-1]< x) )
    assert((right<len(LIST) and LIST[right]> x) or (right==len(LIST) and LIST[-1]<=x) )
