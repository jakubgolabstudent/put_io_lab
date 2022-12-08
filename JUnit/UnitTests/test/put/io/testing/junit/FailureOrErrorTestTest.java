package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureOrErrorTestTest {

    @Test
    public void test1() {
        assertEquals(1, 2);
    }

    @Test
    public void test2() throws Exception {
        throw new Exception("Hi, I am exception :-)");
    }

    @Test
    public void test3() throws Throwable {
        try {
            assertEquals(3, 5);
        } catch (Throwable e) {
            System.out.println(e.toString());
        }
    }
}