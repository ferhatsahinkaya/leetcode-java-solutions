public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        if(num > 10) return result;
        
        Map<Integer, List<String>> hourMap = new HashMap<>();
        for(int i=0; i<12; i++) {
            int setBitCount = getSetBitCount(i, 4);
            List<String> values = hourMap.get(setBitCount);
            values = (values == null) ? new ArrayList<>() : values;
            values.add(String.valueOf(i));
            hourMap.put(setBitCount, values);
        }
        
        Map<Integer, List<String>> minuteMap = new HashMap<>();
        for(int i=0; i<60; i++) {
            int setBitCount = getSetBitCount(i, 6);
            List<String> values = minuteMap.get(setBitCount);
            values = (values == null) ? new ArrayList<>() : values;
            values.add(getMinuteValue(i));
            minuteMap.put(setBitCount, values);
        }
        
        for(int i=0; i<=num; i++) {
            List<String> hours = hourMap.get(i);
            List<String> minutes = minuteMap.get(num-i);
            if(hours == null || minutes == null) continue;
            for(String hour : hours) {
                for(String minute : minutes) {
                    result.add(hour + ":" + minute);
                }
            }
        }
        return result;
    }
    private int getSetBitCount(int value, int bitCount) {
        int setBits = 0;
        for(int i=0; i<bitCount; i++) {
            setBits += ((value & (1 << i)) == 0) ? 0 : 1;
        }
        return setBits;
    }
    private String getMinuteValue(int value) {
        if(value == 0) return "00";
        String minute = String.valueOf(value);
        return (1 == minute.length()) ? "0" + minute : minute;
    }
}