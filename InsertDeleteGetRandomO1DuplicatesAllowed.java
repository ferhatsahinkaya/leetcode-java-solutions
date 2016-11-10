public class RandomizedCollection {
    private final Random random = new Random();
    private final List<Integer> list = new ArrayList<>();
    private final Map<Integer, Set<Integer>> map = new HashMap<>();

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> indexes = map.get(val);
        indexes = (indexes != null) ? indexes : new HashSet<>();
        boolean exists = indexes.size() > 0;
        indexes.add(list.size());
        list.add(val);
        map.put(val, indexes);
        return !exists;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> indexes = map.get(val);
        indexes = (indexes != null) ? indexes : new HashSet<>();
        Iterator<Integer> iterator = indexes.iterator();
        boolean exists = iterator.hasNext();
        if(exists) {
            int index = iterator.next();
            iterator.remove();
            
            if(index != list.size()-1) {
                int lastValue = list.get(list.size()-1);
                list.set(index, lastValue);
            
                Set<Integer> lastValueIndexes = map.get(lastValue);
                lastValueIndexes.remove(list.size()-1);
                lastValueIndexes.add(index);
            }
            list.remove(list.size()-1);
        }
        return exists;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */