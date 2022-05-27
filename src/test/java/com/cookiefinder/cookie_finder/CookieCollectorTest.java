package com.cookiefinder.cookie_finder;

import com.cookiefinder.cookie_finder.model.CookieLog;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CookieCollectorTest {

    private CookieCollector cookieCollector;

    @BeforeEach
    void setUp() {
        cookieCollector = new CookieCollector();
        cookieCollector.timeParser = new TimeParser();
    }

    @Test
    void shouldBeAbleToUpdateCookie() {
        List<CookieLog> cookieLogs = mockLogs();
        cookieCollector.cookieCounter(cookieLogs);
        assertEquals("AtY0laUfhglK3lC7", cookieCollector.getCookieForDate("2018-12-09"));
        assertEquals("SAZuXPGUrfbcn5UA", cookieCollector.getCookieForDate("2018-12-08"));
    }

    private List<CookieLog> mockLogs() {
        return Arrays.asList(
                new CookieLog("AtY0laUfhglK3lC7", cookieCollector.timeParser.fromZonedDateString("2018-12-09T14:19:00+00:00")),
                new CookieLog("SAZuXPGUrfbcn5UA", cookieCollector.timeParser.fromZonedDateString("2018-12-09T10:13:00+00:00")),
                new CookieLog("5UAVanZf6UtGyKVS", cookieCollector.timeParser.fromZonedDateString("2018-12-09T07:25:00+00:00")),
                new CookieLog("AtY0laUfhglK3lC7", cookieCollector.timeParser.fromZonedDateString("2018-12-09T06:19:00+00:00")),
                new CookieLog("SAZuXPGUrfbcn5UA", cookieCollector.timeParser.fromZonedDateString("2018-12-08T22:03:00+00:00")),
                new CookieLog("4sMM2LxV07bPJzwf", cookieCollector.timeParser.fromZonedDateString("2018-12-08T21:30:00+00:00")),
                new CookieLog("fbcn5UAVanZf6UtG", cookieCollector.timeParser.fromZonedDateString("2018-12-08T09:30:00+00:00")),
                new CookieLog("4sMM2LxV07bPJzwf", cookieCollector.timeParser.fromZonedDateString("2018-12-07T23:30:00+00:00"))
        );
    }
}