public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int length = strs.length;
        if(length <= 0) return result;
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            
            String sorted = new String(chars);
            List<String> list = map.get(sorted);
            if(list == null) list = new ArrayList<>();
            list.add(strs[i]);
            map.put(sorted, list);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}