public class Solution {
    public String simplifyPath(String path) {
        String[] values = path.split("/");
        int length = values.length;
        
        String result = "/";
        for(int i=0; i<length; i++) {
            if(".".equals(values[i]) || "".equals(values[i])) continue;
            if("..".equals(values[i])) {
                result = remove(result);
            } else {
                result = add(result, values[i]);
            }
        }
        return result;
    }
    private String remove(String path) {
        if("/".equals(path)) return path;
        int lastEnd = path.lastIndexOf('/');
        String result = path.substring(0, lastEnd);
        return result.equals("") ? "/" : result;
    }
    private String add(String path, String element) {
        if("/".equals(path)) return path + element;
        return path + "/" + element;
    }
}