from typing import List
import collections

class Twitter:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.next_timestamp = 1
        self.userid_to_tweetid_deque_dict = {}
        self.userid_to_followee_userid_set_dict = {}

    def postTweet(self, userId: int, tweetId: int) -> None:
        """
        Compose a new tweet.
        """
        if userId not in self.userid_to_tweetid_deque_dict:
            self.userid_to_tweetid_deque_dict[userId] = collections.deque()
        tweetid_deque = self.userid_to_tweetid_deque_dict[userId]
        tweetid_deque.append((self.next_timestamp,tweetId))
        self.next_timestamp += 1
        while len(tweetid_deque) > 10:
            tweetid_deque.popleft()
        #print(tweetid_deque)

    def getNewsFeed(self, userId: int) -> List[int]:
        """
        Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
        """
        tweetid_list = []
        if userId in self.userid_to_tweetid_deque_dict:
            tweetid_deque = self.userid_to_tweetid_deque_dict[userId]
            tweetid_list.extend(tweetid_deque)

        if userId in self.userid_to_followee_userid_set_dict:
            followee_userid_set = self.userid_to_followee_userid_set_dict[userId]
            for followee_userid in followee_userid_set:
                if followee_userid not in self.userid_to_tweetid_deque_dict: continue
                tweetid_deque = self.userid_to_tweetid_deque_dict[followee_userid]
                tweetid_list.extend(tweetid_deque)

        tweetid_list.sort()
        tweetid_list = tweetid_list[-10:]
        tweetid_list.reverse()
        tweetid_list = map(lambda i:i[1],tweetid_list)
        tweetid_list = list(tweetid_list)
        return tweetid_list

    def follow(self, followerId: int, followeeId: int) -> None:
        """
        Follower follows a followee. If the operation is invalid, it should be a no-op.
        """
        if followerId == followeeId: return
        if followerId not in self.userid_to_followee_userid_set_dict:
            self.userid_to_followee_userid_set_dict[followerId] = set()
        followee_userid_set = self.userid_to_followee_userid_set_dict[followerId]
        followee_userid_set.add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        """
        Follower unfollows a followee. If the operation is invalid, it should be a no-op.
        """
        if followerId == followeeId: return
        if followerId not in self.userid_to_followee_userid_set_dict: return
        followee_userid_set = self.userid_to_followee_userid_set_dict[followerId]
        if followeeId not in followee_userid_set: return
        followee_userid_set.remove(followeeId)


# Your Twitter object will be instantiated and called as such:
# obj = Twitter()
# obj.postTweet(userId,tweetId)
# param_2 = obj.getNewsFeed(userId)
# obj.follow(followerId,followeeId)
# obj.unfollow(followerId,followeeId)
