public class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) return s;
        
        int length = s.length();
        
        String result = "";
        int total = 2 * numRows - 2;
        int currentStep = total;
        for(int i=0; i<numRows; i++) {
            currentStep = (currentStep == 0) ? total : currentStep; 
            int step = currentStep;
            
            int j = i;
            while(j < length) {
                result += String.valueOf(s.charAt(j));
                j += step;
                step = total - step;
                step = (step == 0) ? total : step;
            }
            currentStep -= 2;
        }
        return result;
    }
}