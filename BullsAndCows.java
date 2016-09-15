public class Solution {
    public String getHint(String secret, String guess) {
        int length = secret.length();
        Map<Character, Integer> map = new HashMap<>();
        int bulls = 0;
        for(int i=0; i<length; i++) {
            if(guess.charAt(i) == secret.charAt(i)) bulls++;
            else {
                Integer count = map.get(secret.charAt(i));
                count = (count != null) ? count : 0;
                map.put(secret.charAt(i), count+1);
            }
        }
        int cows = 0;
        for(int i=0; i<length; i++) {
            if(guess.charAt(i) == secret.charAt(i)) continue;
            
            Integer count = map.get(guess.charAt(i));
            count = (count != null) ? count : 0;
            if(count > 0) {
                map.put(guess.charAt(i), count-1);
                cows++;
            }
        }
        return String.format("%dA%dB", bulls, cows);
    }
}