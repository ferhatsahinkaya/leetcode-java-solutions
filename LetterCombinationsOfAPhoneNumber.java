public class Solution {
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        if(length <= 0) return new ArrayList<>();
        
        Map<Character, String> map = new HashMap<>();
        initializeMap(map);
        List<String> combinations = new ArrayList<>();
        letterCombinations(digits, 0, length-1, map, combinations);
        return combinations;
    }
    private void letterCombinations(String digits, int start, int end, Map<Character, String> map, List<String> combinations) {
        if(start > end) {
            combinations.add("");
        } else {
            letterCombinations(digits, start+1, end, map, combinations);
            int combinationCount = combinations.size();
            for(int i=0; i<combinationCount; i++) {
                String combination = combinations.get(i);
                String letters = map.get(digits.charAt(start));
                int letterCount = letters.length();
                for(int j=0; j<letterCount; j++) {
                    String newCombination = String.valueOf(letters.charAt(j)) + combination;
                    if(j != letterCount-1) {
                        combinations.add(newCombination);
                    } else {
                        combinations.set(i, newCombination);
                    }
                }
            }
        }
    }
    private void initializeMap(Map<Character, String> map) {
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}