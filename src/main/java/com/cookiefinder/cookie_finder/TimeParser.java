package com.cookiefinder.cookie_finder;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Component
public class TimeParser {
    public LocalDate fromZonedDateString(String timestamp){
        return ZonedDateTime.parse(timestamp).toLocalDate();
    }

    public LocalDate fromLocalDateString(String timestamp){
        return LocalDate.parse(timestamp);
    }
}
