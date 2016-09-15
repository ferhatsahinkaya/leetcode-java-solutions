public class Solution {
	public int myAtoi(String str) {
		int length = str.length();
		char[] chars = str.toCharArray();
		int index = 0;
		while((index < length) && isWhiteSpace(chars[index])) index++;
		if(index == length) return 0;

		boolean isNegative = false;
		if(chars[index] == '-' || chars[index] == '+') {
			isNegative = (chars[index++] == '-');
		}

		long value = 0;
		while(index < length) {
			if(isValid(chars[index])) {
				value *= 10;
				value += (chars[index]-'0');
			} else {
				break;
			}
			if(value >= Integer.MAX_VALUE || value <= Integer.MIN_VALUE) break;
			index++;
		}
		while((index < length) && isWhiteSpace(chars[index])) index++;

		value = isNegative ? -value : value;
		if(value >= Integer.MAX_VALUE || value <= Integer.MIN_VALUE) {
			return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		return (int) value;
	}
	private boolean isWhiteSpace(char ch) {
		return (ch == ' ' || ch == '\t' || ch == '\n');
	}
	private boolean isValid(char ch) {
		return (ch >= '0' && ch <= '9');
	}
}
