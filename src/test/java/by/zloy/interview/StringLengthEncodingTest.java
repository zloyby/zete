package by.zloy.interview;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringLengthEncodingTest {

    private StringLengthEncoding stringLengthEncoding = new StringLengthEncoding();

    @ParameterizedTest
    @NullAndEmptySource
    void runLength(String test) {
        assertEquals("", stringLengthEncoding.runLength(test));
    }

    @ParameterizedTest
    @CsvSource({"AAABBAAAAABBBCCCCCCCCCAAAAA,3A2B5A3B9C5A", "AAA,3A", "A,1A", "Java,1J1a1v1a"})
    void runLength(String test, String expected) {
        assertEquals(expected, stringLengthEncoding.runLength(test));
    }
}