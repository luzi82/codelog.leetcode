import code
import code_1604676410_tle
import string
import random

def test(input,expected):
    print(input,expected)
    solution = code.Solution()
    result = solution.minInteger(*input)
    print(result)
    assert(result == expected)

# given
test(('4321',4),'1342')
test(('100',1),'010')
test(('36789',1000),'36789')
test(('22',22),'22')
test(('9438957234785635408',23),'0345989723478563548')

# brute test
random.seed(0)
for _ in range(10000):
    num_len = random.randrange(1,21)
    num = ''.join([random.choice(string.digits) for _ in range(num_len)])
    k = random.randrange(25)
    expected = code_1604676410_tle.Solution().minInteger(num,k)
    test((num,k), expected)
