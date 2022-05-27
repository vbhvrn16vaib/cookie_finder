package com.cookiefinder.cookie_finder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CookieLog {
    private String cookie;
    private LocalDate time;
}
