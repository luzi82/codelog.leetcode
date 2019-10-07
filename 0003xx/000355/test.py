import code

# given
twitter = code.Twitter()

# User 1 posts a new tweet (id = 5).
twitter.postTweet(1, 5)

# User 1's news feed should return a list with 1 tweet id -> [5].
ret = twitter.getNewsFeed(1)
print(ret)
assert(ret == [5])

# User 1 follows user 2.
twitter.follow(1, 2)

# User 2 posts a new tweet (id = 6).
twitter.postTweet(2, 6)

# User 1's news feed should return a list with 2 tweet ids -> [6, 5].
# Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
ret=twitter.getNewsFeed(1)
print(ret)
assert(ret == [6,5])

# User 1 unfollows user 2.
twitter.unfollow(1, 2)

# User 1's news feed should return a list with 1 tweet id -> [5],
# since user 1 is no longer following user 2.
ret = twitter.getNewsFeed(1)
print(ret)
assert(ret == [5])

# wa case
twitter = code.Twitter()
twitter.postTweet(1, 5)
twitter.follow(1, 1)
ret=twitter.getNewsFeed(1)
print(ret)
assert(ret == [5])


