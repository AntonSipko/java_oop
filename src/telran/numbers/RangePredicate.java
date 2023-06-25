package telran.numbers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class RangePredicate implements Iterable<Integer> {
    int minInclusive;
    int maxExclusive;
    Predicate<Integer> predicate;
    
    public RangePredicate(int minInclusive, int maxExclusive) {
        this.minInclusive = minInclusive;
        this.maxExclusive = maxExclusive;
    }
    
    public Predicate<Integer> getPredicate() {
        return predicate;
    }
    
    public void setPredicate(Predicate<Integer> predicate) {
        this.predicate = predicate;
    }
    
    public int[] toArray() {
        int arraySize = 0;
        for (int i = minInclusive; i < maxExclusive; i++) {
            if (predicate == null || predicate.test(i)) {
                arraySize++;
            }
        }
        
        int index = 0;
        int[] res = new int[arraySize];
        for (int i = minInclusive; i < maxExclusive; i++) {
            if (predicate == null || predicate.test(i)) {
                res[index++] = i;
            }
        }
        
        return res;
    }
    
    private class RangePredicateIterator implements Iterator<Integer> {
        int current;
        Predicate<Integer> innerPredicate;
        
        RangePredicateIterator(Predicate<Integer> predicate) {
            current = minInclusive;
            innerPredicate = predicate;
            moveToNextValidElement();
        }
        
        private void moveToNextValidElement() {
            while (current < maxExclusive && (innerPredicate == null || !innerPredicate.test(current))) {
                current++;
            }
        }
        
        @Override
        public boolean hasNext() {
            return current < maxExclusive;
        }
        
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int nextValue = current;
            current++;
            moveToNextValidElement();
            return nextValue;
        }
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new RangePredicateIterator(predicate);
    }
}
