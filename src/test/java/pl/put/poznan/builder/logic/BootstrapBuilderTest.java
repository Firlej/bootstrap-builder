package pl.put.poznan.builder.logic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BootstrapBuilderTest {

    @Test
    void testToStringEmpty() {
        BootstrapBuilder bsBuilder = new BootstrapBuilder("", "", "", "", "", "");

        assertEquals("", bsBuilder.toString());
    }

    @Test
    void testToString() {
        String toTest = "preHeader meta header postHeader footer postFooter";
        List<String> words = List.of(toTest.split(" "));
        String expected = String.join("", words);

        BootstrapBuilder bsBuilder = new BootstrapBuilder(words.get(0), words.get(1), words.get(2), words.get(3), words.get(4), words.get(5));

        assertEquals(expected, bsBuilder.toString());
    }
}