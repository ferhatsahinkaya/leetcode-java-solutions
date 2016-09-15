public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int nonOverlapArea = ((G-E) * (H-F)) + ((C-A) * (D-B));
        if((C < E) || (G < A) || (D < F) || (H < B)) {
            return nonOverlapArea;
        }
        
        int overlapArea = (Math.min(C,G) - Math.max(A,E)) * (Math.min(D,H) - Math.max(B,F));
        return nonOverlapArea - overlapArea;
    }
}