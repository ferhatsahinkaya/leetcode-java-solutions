public class Solution {
    public List<List<String>> partition(String s) {
        Map<Integer, List<List<String>>> map = new HashMap<>();
        
        int length = s.length();
        for(int i=0; i<length; i++) {
            List<List<String>> partitions = new ArrayList<>();
            for(int j=i; j>=0; j--) {
                if(isPalindrome(s, j, i)) {
                    if(j == 0) {
                        List<String> partition = new ArrayList<>();
                        partition.add(s.substring(0, i+1));
                        partitions.add(partition);
                    } else {
                        List<List<String>> existingPartitions = map.get(j-1);
                        for(List<String> existingPartition : existingPartitions) {
                            List<String> newPartition = new ArrayList<>(existingPartition);
                            newPartition.add(s.substring(j, i+1));
                            partitions.add(newPartition);
                        }
                    }
                }
            }
            map.put(i, partitions);
        }
        return map.get(length-1);
    }
    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}