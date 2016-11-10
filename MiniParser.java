/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        return deserialize(s, 0, s.length()-1);
    }
    private NestedInteger deserialize(String s, int start, int end) {
        if(start > end) return new NestedInteger();
        if(s.charAt(start) == '[') {
            NestedInteger result = new NestedInteger();
            int i = start+1;
            while(i < end) {
                int endIndex = getEndIndex(s, i, end);
                result.add(deserialize(s, i, endIndex));
                i = endIndex + 2;
            }
            return result;
        } else {
            return new NestedInteger(Integer.parseInt(s.substring(start, end+1))); 
        }
    }
    private int getEndIndex(String s, int start, int end) {
        int depth = 0;
        for(int i=start; i<=end; i++) {
            if(s.charAt(i) == '[') depth++;
            if(s.charAt(i) == ']') {
                depth--;
                if(depth < 0) return i-1;
                if(depth == 0) return i;
            }
            if(s.charAt(i) == ',') {
                if(depth <= 0) return i-1;
            }
        }
        return -1;
    }
}