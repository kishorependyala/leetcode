import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubstringTest {

    @Test
    void lcs() {
        assertEquals("bcd", new LongestCommonSubstring().lcs("kbcdf", new String[]{"abcef","abcdef"}));
        assertEquals("abcd", new LongestCommonSubstring().lcs("abcdf", new String[]{"abcef","abcdef"}));
    }

    @Test
    void lcsTake2() {
        assertEquals("bcd", new LongestCommonSubstring().lcsTake2("kbcdf", new String[]{"abcef","abcdef"}));
        assertEquals("abcd", new LongestCommonSubstring().lcsTake2("abcdf", new String[]{"abcef","abcdef"}));
    }

    @Test
    void lcsStr() {
        assertEquals("abcd", new LongestCommonSubstring().lcs("abcdf", "abcdef"));
        assertEquals("", new LongestCommonSubstring().lcs(null, "abcdef"));
        assertEquals("", new LongestCommonSubstring().lcs("abcdf", (String)null));
        assertEquals("hijklm", new LongestCommonSubstring().lcs("abcdedfghijklmkdfsljk", "hijklmnzaaa"));
        assertEquals("abcd", new LongestCommonSubstring().lcs("abcd", "abefabcdef"));
    }

    @Test
    void lcsStrTake2() {
        assertEquals("abcd", new LongestCommonSubstring().lcsTake2("abcdf", "abcdef"));
        assertEquals("", new LongestCommonSubstring().lcsTake2(null, "abcdef"));
        assertEquals("", new LongestCommonSubstring().lcsTake2("abcdf", (String)null));
        assertEquals("hijklm", new LongestCommonSubstring().lcsTake2("abcdedfghijklmkdfsljk", "hijklmnzaaa"));
        assertEquals("abcd", new LongestCommonSubstring().lcsTake2("abcd", "abefabcdef"));
    }


}