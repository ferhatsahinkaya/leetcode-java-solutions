public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            boolean divisibleByThree = divisible(i, 3);
            boolean divisibleByFive = divisible(i, 5);
            String value = "";
            if(!divisibleByThree && !divisibleByFive) {
                value = String.valueOf(i);
            } else {
                if(divisibleByThree) {
                    value += "Fizz";
                }
                if(divisibleByFive) {
                    value += "Buzz";
                }
            }
            result.add(value);
        }
        return result;
    }
    private boolean divisible(int value, int divisor) {
        return (value % divisor == 0);
    }
}