package problem0015;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void test_0x0() {
        assertEquals(0, App.f(0, 0));
    }

    @Test public void test_1x1() {
        assertEquals(2, App.f(1, 1));
    }

    @Test public void test_1x2() {
        assertEquals(3, App.f(1, 2));
    }

    @Test public void test_2x1() {
        assertEquals(3, App.f(2, 1));
    }

    @Test public void test_2x2() {
        assertEquals(6, App.f(2));
    }
}
