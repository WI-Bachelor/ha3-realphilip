package htw.berlin;

import htw.berlin.ui.InputParser;
import htw.berlin.ui.CommaAndWhitespaceSplittingInputParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {

    @Test
    @DisplayName("should count how often specified keywords occur")
        //despite display name, the test only tests for keywords that occur on one or no occasions
    void canCountKeywords() {
        InputParser classUnderTest = new CommaAndWhitespaceSplittingInputParser();
        Set<String> keywords = new HashSet<>(Arrays.asList("Rindfleisch", "Eisbergsalat", "Tomate", "Ketchup", "Mayo", "Avocado"));
        String inputLine = "Ich haette gerne einen Burger mit Rindfleisch, Eisbergsalat, Tomate, und Ketchup";
        var expected = Map.of(
                "Rindfleisch", 1,
                "Eisbergsalat", 1,
                "Tomate", 1,
                "Ketchup", 1,
                "Mayo", 0,
                "Avocado", 0);
        assertEquals(expected, classUnderTest.countKeywords(inputLine, keywords));
    }
    @Test
    @DisplayName("should test whether InputParser accounts for keywords mentioned multiple times")
    void canCountMultipleKeywords() {
        InputParser classUnderTest = new CommaAndWhitespaceSplittingInputParser();
        Set<String> keywords = new  HashSet<>(Arrays.asList("Rindfleisch", "Eisbergsalat", "Tomate", "Ketchup", "Mayo", "Avocado"));
        String inputLine = "Ich haette gerne einen Burger mit Rindfleisch mit Mayo, Eisbergsalat mit Mayo, Tomate mit Mayo, Ketchup, und Mayo";
        var expected = Map.of(
                "Rindfleisch", 1,
                "Eisbergsalat", 1,
                "Tomate", 1,
                "Ketchup", 1,
                "Mayo", 4,
                "Avocado", 0);
        assertEquals(expected, classUnderTest.countKeywords(inputLine, keywords));
    }

    @Test
    @DisplayName("should check for case insensitivity")
    void isCaseInsensitive() {
        InputParser classUnderTest = new CommaAndWhitespaceSplittingInputParser();
        Set<String> keywords = new  HashSet<>(Arrays.asList("Rindfleisch", "Eisbergsalat", "Tomate", "Ketchup", "Mayo", "Avocado"));
        String inputLine = "Ich haette gerne einen Burger mit RINDFleisch mit MayO, eisbergsalat mit mayo, Tomate mit Mayo, Ketchup, und Mayo";
        var expected = Map.of(
                "Rindfleisch", 1,
                "Eisbergsalat", 1,
                "Tomate", 1,
                "Ketchup", 1,
                "Mayo", 4,
                "Avocado", 0);
        assertEquals(expected, classUnderTest.countKeywords(inputLine, keywords));
    }


}




