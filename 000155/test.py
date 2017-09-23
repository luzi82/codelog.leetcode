import code
import random
import copy

minStack = code.MinStack()
mirror = []

for _ in range(1000):
	action_list = []
	
	if len(mirror) > 0:
		action_list.append('top')
		action_list.append('pop')
		action_list.append('getMin')
	if len(mirror) < 1000:
		action_list.append('push')
	
	action = random.choice(action_list)
	print action
	if action == 'top':
		v = minStack.top()
		vv = mirror[-1]
		assert(v==vv)
	elif action == 'pop':
		v = minStack.pop()
		mirror = mirror[:-1]
	elif action == 'getMin':
		v = minStack.getMin()
		vv = min(mirror)
		assert(v==vv)
	elif action == 'push':
		v = random.randint(0,1000)
		minStack.push(v)
		mirror.append(v)

	print(mirror)
