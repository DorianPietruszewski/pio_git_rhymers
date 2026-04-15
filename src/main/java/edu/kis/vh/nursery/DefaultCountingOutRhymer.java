package edu.kis.vh.nursery;

/**
 * Basic counting-out rhymer implementation using an internal fixed-size array.
 */
public class DefaultCountingOutRhymer {

    private static final int DEFAULT_RETURN = -1;
    private static final int EMPTY = -1;
    private static final int MAX_CAPACITY = 12;
    private static final int FULL = MAX_CAPACITY - 1;
    private final int[] numbers = new int[MAX_CAPACITY];
    private int total = EMPTY;

    /**
     * Returns current index of the top element.
     *
     * @return top index or empty indicator when structure is empty
     */
    public int getTotal() {
        return total;
    }

    /**
     * Adds a value to the rhymer if capacity is not exceeded.
     *
     * @param in value to be added
     */
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    /**
     * Checks whether the rhymer is empty.
     *
     * @return true when empty, otherwise false
     */
    public boolean callCheck() {
        return total == EMPTY;
    }

    /**
     * Checks whether the rhymer reached maximum capacity.
     *
     * @return true when full, otherwise false
     */
    public boolean isFull() {
        return total == FULL;
    }

    protected int peekaboo() {
        if (callCheck())
            return DEFAULT_RETURN;
        return numbers[total];
    }

    /**
     * Removes and returns the current top value.
     *
     * @return top value or default return value when empty
     */
    public int countOut() {
        if (callCheck())
            return DEFAULT_RETURN;
        return numbers[total--];
    }

}
