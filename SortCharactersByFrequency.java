public class Solution {
    public String frequencySort(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : str.toCharArray()) {
            Integer count = map.get(ch);
            count = (count != null) ? count : 0;
            map.put(ch, count+1);
        }
        TreeMap<Integer, List<Character>> treeMap = new TreeMap<>(new Comparator<Integer>() {
            public int compare(Integer int1, Integer int2) {
                if(int1 == int2) return 0;
                return (int1 > int2) ? -1 : 1;
            }
        });
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            List<Character> chars = treeMap.get(entry.getValue());
            chars = (chars != null) ? chars : new ArrayList<>();
            chars.add(entry.getKey());
            treeMap.put(entry.getValue(), chars);
        }
        String result = "";
        for(Map.Entry<Integer, List<Character>> entry : treeMap.entrySet()) {
            for(char ch : entry.getValue()) {
                result += repeat(String.valueOf(ch), entry.getKey());
            }
        }
        return result;
    }
    public static String repeat(String s, int n) {
    final StringBuilder sb = new StringBuilder(s.length() * n);
    for(int i = 0; i < n; i++) {
        sb.append(s);
    }
    return sb.toString();
}
}