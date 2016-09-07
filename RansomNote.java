public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int noteLength = magazine.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<noteLength; i++) {
            Integer count = map.get(magazine.charAt(i));
            count = (count != null) ? count : 0;
            map.put(magazine.charAt(i), count+1);
        }
        int magazineLength = ransomNote.length();
        for(int i=0; i<magazineLength; i++) {
            Integer count = map.get(ransomNote.charAt(i));
            count = (count != null) ? count : 0;
            if(count == 0) return false;
            map.put(ransomNote.charAt(i), count-1);
        }
        return true;
    }
}