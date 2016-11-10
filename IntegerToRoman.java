public class Solution {
    public String intToRoman(int num) {
        Map<Integer, Character> map = new HashMap<>();
        populateMap(map);
        
        int power = 1;
        String result = "";
        while(num > 0) {
            int digit = num % 10;
            if(digit == 9) {
                result = String.valueOf(map.get(power)) + String.valueOf(map.get(10 * power)) + result;
            } else if(digit >= 5) {
                for(int i=5; i<digit; i++) {
                    result = String.valueOf(map.get(power)) + result;
                }
                result = String.valueOf(map.get(5 * power)) + result;
            } else if(digit >= 4) {
                result = String.valueOf(map.get(power)) + String.valueOf(map.get(5 * power)) + result;
            } else {
                for(int i=0; i<digit; i++) {
                    result = String.valueOf(map.get(power)) + result;
                }
            }
            power *= 10;
            num /= 10;
        }
        return result;
    }
    private void populateMap(Map<Integer, Character> map) {
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
    }
}