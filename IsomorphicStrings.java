public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        Map<Character, Character> sToTMap = new HashMap<>();
        Map<Character, Character> tToSMap = new HashMap<>();
        for(int i=0; i<length; i++) {
            Character tMappedValue = sToTMap.get(s.charAt(i));
            if(tMappedValue == null) {
                sToTMap.put(s.charAt(i), t.charAt(i));
            } else if(tMappedValue != t.charAt(i)) {
                return false;
            }
            
            Character sMappedValue = tToSMap.get(t.charAt(i));
            if(sMappedValue == null) {
                tToSMap.put(t.charAt(i), s.charAt(i));
            } else if(sMappedValue != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}