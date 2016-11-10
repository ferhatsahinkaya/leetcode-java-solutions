public class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<Integer> geneSet = new HashSet<>();
        populateGeneSet(geneSet, bank);

        int startGene = getInteger(start);
        int endGene = getInteger(end);
        
        int step = 1;
        LinkedList<Integer> level = new LinkedList<>();
        level.add(startGene);
        
        Set<Integer> used = new HashSet<>();
        used.add(startGene);
        
        while(!level.isEmpty()) {
            LinkedList<Integer> nextLevel = new LinkedList<>();
            
            while(!level.isEmpty()) {
                Integer value = level.removeFirst();
                for(int i=0; i<8; i++) {
                    int gene = filter(value, 8 - i);
                    for(int j=0; j<4; j++) {
                        if(gene != j) {
                            int newValue = set(value, 8 - i, j);
                            
                            if(geneSet.contains(newValue)) {
                                if(newValue == endGene) return step;
                                
                                if(!used.contains(newValue)) {
                                    used.add(newValue);
                                    nextLevel.add(newValue);
                                }
                            }
                        }
                    }
                }
            }
            level = nextLevel;
            step++;
        }
        return -1;
    }
    private int set(int value, int index, int gene) {
        index <<= 1;
        return (value & ~(3 << index)) | (gene << index);
    }
    private int filter(int value, int index) {
        int mask = 3;
        index <<= 1;
        return (value & (mask << index)) >> index;
    }
    private void populateGeneSet(Set<Integer> geneSet, String[] bank) {
        for(String gene : bank) {
            geneSet.add(getInteger(gene));
        }
    }
    private int getInteger(String gene) {
        int value = 0;
        for(int i=0; i<8; i++) {
            value |= getInteger(gene.charAt(i));
            value <<= 2;
        }
        return value;
    }
    private int getInteger(char ch) {
        if(ch == 'A') return 0;
        if(ch == 'C') return 1;
        if(ch == 'G') return 2;
        return 3;
    }
}