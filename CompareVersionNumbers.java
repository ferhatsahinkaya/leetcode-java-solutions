public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int v1Length = v1.length;
        int v2Length = v2.length;
        
        int index = 0;
        while(index < v1Length && index < v2Length) {
            int v1Value = Integer.parseInt(v1[index]);
            int v2Value = Integer.parseInt(v2[index]);
            
            int comparisonResult = compare(v1Value, v2Value);
            if(comparisonResult != 0) return comparisonResult;
            
            index++;
        }
        while(index < v1Length) {
            if(Integer.parseInt(v1[index++]) != 0) return 1;
        }
        while(index < v2Length) {
            if(Integer.parseInt(v2[index++]) != 0) return -1;
        }
        return 0;
    }
    private int compare(int v1, int v2) {
        if(v1 > v2) return 1;
        if(v2 > v1) return -1;
        return 0;
    }
}