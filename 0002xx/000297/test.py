import code

def test(data):
    print(data)
    solution = code.Codec()
    tree = solution.deserialize(data)
    data2 = solution.serialize(tree)
    print(data2)
    assert(data == data2)

test([1,2,None,None,3,4,None,None,5,None,None])
test([None])
test([1,None,None])
