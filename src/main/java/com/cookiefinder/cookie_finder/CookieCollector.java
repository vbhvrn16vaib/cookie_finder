package com.cookiefinder.cookie_finder;

import com.cookiefinder.cookie_finder.model.CookieLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CookieCollector {
    private Map<LocalDate, String> cookieWithDate = new HashMap<>();

    @Autowired
    TimeParser timeParser;

    public String getCookieForDate(String date) {
        return cookieWithDate.getOrDefault(timeParser.fromLocalDateString(date), "Doesn't exist");
    }

    public void cookieCounter(List<CookieLog> allLines) {
        updateMostActiveCookie(allLines);
    }

    private void updateMostActiveCookie(List<CookieLog> allLines) {
        if (allLines == null || allLines.isEmpty()) return;

        LocalDate currentTime = LocalDate.MIN;
        String maxCurrentCookie = null;
        int maxCurrentCookieCount = 0;
        Map<String, Integer> map = new HashMap<>();


        for (CookieLog log : allLines) {
            if (!currentTime.isEqual(log.getTime())) {
                cookieWithDate.put(currentTime, maxCurrentCookie);
                currentTime = log.getTime();
                maxCurrentCookie = log.getCookie();
                maxCurrentCookieCount = 0;
                map.clear();
            }
            map.put(log.getCookie(), map.getOrDefault(log.getCookie(), 0) + 1);
            if (map.get(log.getCookie()) > maxCurrentCookieCount) {
                maxCurrentCookieCount = map.get(log.getCookie());
                maxCurrentCookie = log.getCookie();
            }
        }

        cookieWithDate.put(currentTime, maxCurrentCookie);
    }

}
