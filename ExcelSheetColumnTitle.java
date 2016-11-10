public class Solution {
    public String convertToTitle(int n) {
        String title = "";
        while(n > 0) {
            n--;
            title = String.valueOf((char) ((n % 26) + 'A')) + title;
            n /= 26;
        }
        return title;
    }
}