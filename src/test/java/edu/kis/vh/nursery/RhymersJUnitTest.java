package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

// Testy uruchomione pomyslnie

public class RhymersJUnitTest {

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }

    @Test
    public void testFifoRhymerBoundaryAndEmptyCases() {
        FifoRhymer rhymer = new FifoRhymer();
        final int EMPTY_VALUE = -1;
        final int CAPACITY = 12;
        final int OVERFLOW_TEST_VALUE = 999;
        final int REUSE_TEST_VALUE = 42;

        Assert.assertEquals(EMPTY_VALUE, rhymer.countOut());

        for (int i = 1; i <= CAPACITY; i++) {
            rhymer.countIn(i);
        }

        rhymer.countIn(OVERFLOW_TEST_VALUE);

        for (int i = 1; i <= CAPACITY; i++) {
            Assert.assertEquals(i, rhymer.countOut());
        }

        Assert.assertEquals(EMPTY_VALUE, rhymer.countOut());

        rhymer.countIn(REUSE_TEST_VALUE);
        Assert.assertEquals(REUSE_TEST_VALUE, rhymer.countOut());
        Assert.assertEquals(EMPTY_VALUE, rhymer.countOut());
    }

}
