package com.cookiefinder.cookie_finder;

import com.cookiefinder.cookie_finder.model.CookieLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CookieFinderCSVParserTest {

    CookieFinderCSVParser parser;


    @BeforeEach
    void setUp() {
        parser = new CookieFinderCSVParser();
        parser.timeParser = new TimeParser();
    }

    @Test
    void shouldBeAbleToParseCorrectFile() {
        List<CookieLog> result = parser.getResult(getFile("/cookiefile.csv"));
        assertFalse(result.isEmpty());
        assertNotNull(result.get(0));
    }

    private File getFile(String filename) {
        return new File(CookieFinderCSVParserTest.class.getResource(filename).getFile());
    }
}