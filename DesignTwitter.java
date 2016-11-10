public class Twitter {
    class Tweet {
        int id;
        int tweetNo;
        
        Tweet(int id, int tweetNo) {
            this.id = id;
            this.tweetNo = tweetNo;
        }
    }
    private static int TWEET_ID = 1;
    
    private final Map<Integer, Set<Integer>> followingMap = new HashMap<>();
    private final Map<Integer, List<Tweet>> tweetMap = new HashMap<>();
    
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        List<Tweet> tweets = tweetMap.get(userId);
        tweets = (tweets != null) ? tweets : new ArrayList<>();
        tweets.add(new Tweet(TWEET_ID++, tweetId));
        tweetMap.put(userId, tweets);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> followees = followingMap.get(userId);
        followees = (followees != null) ? followees : new HashSet<>();
        followees.add(userId);
        
        PriorityQueue<Tweet> tweets = new PriorityQueue<>(10, new Comparator<Tweet>() {
            public int compare(Tweet t1, Tweet t2) {
                return t2.id - t1.id;
            }
        });
        for(Integer followeeId : followees) {
            tweets.addAll(getMostRecentTweets(followeeId, 10));
        }
        List<Integer> newsFeed = new ArrayList<>();
        for(int i=0; (i < 10) && (tweets.peek() != null); i++) {
            newsFeed.add(tweets.poll().tweetNo);
        }
        return newsFeed;
    }
    
    private List<Tweet> getMostRecentTweets(int userId, int count) {
        List<Tweet> tweets = tweetMap.get(userId);
        tweets = (tweets != null) ? new ArrayList<>(tweets) : new ArrayList<>();
        List<Tweet> result = new ArrayList<>();
        for(int i=tweets.size()-1; i >= 0 && count > 0; i--, count--) {
            result.add(tweets.get(i));
        }
        return result;
    } 
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = followingMap.get(followerId);
        followees = (followees != null) ? followees : new HashSet<>();
        followees.add(followeeId);
        followingMap.put(followerId, followees);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = followingMap.get(followerId);
        followees = (followees != null) ? followees : new HashSet<>();
        followees.remove(followeeId);
        followingMap.put(followerId, followees);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */