import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    @org.junit.jupiter.api.Test
    void reverse() {
        assertEquals(21,new ReverseInteger().reverse(12));
        assertEquals(21,new ReverseInteger().reverse(120));
        assertEquals(0,new ReverseInteger().reverse(1534236469));

    }
}