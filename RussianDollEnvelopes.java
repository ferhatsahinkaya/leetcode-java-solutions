public class Solution {
    class Doll {
        int width;
        int height;
        
        Doll(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int envelopeCount = envelopes.length;
        List<Doll> dolls = new ArrayList<>();
        for(int i=0; i<envelopeCount; i++) {
            dolls.add(new Doll(envelopes[i][0], envelopes[i][1]));
        }
        Collections.sort(dolls, new Comparator<Doll>() {
           public int compare(Doll d1, Doll d2) {
               if(d1.width == d2.width) return 0;
               return (d1.width > d2.width) ? 1 : -1;
           }
        });
        int[] counts = new int[envelopeCount];
        int maxCount = 0;
        for(int i=0; i<envelopeCount; i++) {
            int count = 1;
            for(int j=0; j<i; j++) {
                if(dolls.get(i).width > dolls.get(j).width 
                    && dolls.get(i).height > dolls.get(j).height) {
                        
                    count = Math.max(count, counts[j]+1);
                }
            }
            counts[i] = count;
            maxCount = Math.max(maxCount, counts[i]);
        }
        return maxCount;
    }
}