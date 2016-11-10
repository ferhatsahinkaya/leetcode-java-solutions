// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer cached;
    private Iterator<Integer> iterator;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    this.cached = peek();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
	    if(cached != null) return cached;
	    if(iterator.hasNext()) {
	        cached = iterator.next();
	    }
	    return cached;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer result;
	    if(cached != null) {
	        result = cached;
	        cached = null;
	    } else {
	        result = iterator.next();
	    }
	    return result;
	}

	@Override
	public boolean hasNext() {
	    return (cached != null) || iterator.hasNext();
	}
}