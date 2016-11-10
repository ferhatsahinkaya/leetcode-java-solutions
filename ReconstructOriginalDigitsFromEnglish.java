public class Solution {
    public String originalDigits(String s) {
        int length = s.length();
        if(length <= 0) return "";
        
        int[] letterCounts = new int[26];
        Arrays.fill(letterCounts, 0);
        
        for(int i=0; i<length; i++) {
            letterCounts[s.charAt(i) - 'a']++;
        }
        
        int[] digitCounts = new int[10];
        Arrays.fill(digitCounts, 0);
        
        char[] digitKeys = new char[] {'x', 's', 'v', 'f', 'g', 'h', 'z', 'w', 'o', 'i'};
        
        String[] digits = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i=0; i<10; i++) {
            char digitKey = digitKeys[i];
            int digitInt = getDigitInt(digitKey);
            int count = letterCounts[digitKey - 'a'];
            removeDigit(letterCounts, digits[digitInt], count);
            digitCounts[digitInt] = count;
        }
        String result = "";
        for(int i=0; i<10; i++) {
            result += repeatString(i, digitCounts[i]);
        }
        return result;
    }
    private void removeDigit(int[] letterCounts, String digit, int count) {
        int digitLength = digit.length();
        for(int i=0; i<digitLength; i++) {
            letterCounts[digit.charAt(i) - 'a'] -= count;
        }
    }
    private int getDigitInt(char ch) {
        if(ch == 'z') return 0;
        if(ch == 'o') return 1;
        if(ch == 'w') return 2;
        if(ch == 'h') return 3;
        if(ch == 'f') return 4;
        if(ch == 'v') return 5;
        if(ch == 'x') return 6;
        if(ch == 's') return 7;
        if(ch == 'g') return 8;
        return 9;
    }
    private String repeatString(int value, int count) {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<count; i++) {
            builder.append(value);
        }
        return builder.toString();
    }
}