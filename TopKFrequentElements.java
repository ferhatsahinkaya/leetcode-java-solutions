public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> valToCount = new HashMap<>();
        int length = nums.length;
        for(int i=0; i<length; i++) {
            Integer count = valToCount.get(nums[i]);
            count = (count == null) ? 0 : count;
            valToCount.put(nums[i], count+1);
        }
        
        PriorityQueue<Integer> counts = new PriorityQueue<>(length, Collections.reverseOrder());
        Map<Integer, List<Integer>> countToValues = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : valToCount.entrySet()) {
            List<Integer> values = countToValues.get(entry.getValue());
            values = (values == null) ? new ArrayList<>() : values;
            if(values.isEmpty()) {
                counts.add(entry.getValue());
            }
            values.add(entry.getKey());
            countToValues.put(entry.getValue(), values);
        }
        
        List<Integer> kFrequent = new ArrayList<>();
        int remaining = k;
        while(!counts.isEmpty() && remaining > 0) {
            Integer count = counts.poll();
            List<Integer> values = countToValues.get(count);
            if(values.size() <= remaining) {
                kFrequent.addAll(values);
                remaining -= values.size();
            } else {
                for(int i=0; i<remaining; i++) {
                    kFrequent.add(values.get(i));
                }
                break;
            }
        }
        return kFrequent; 
    }
}