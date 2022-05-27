package com.cookiefinder.cookie_finder;

import com.cookiefinder.cookie_finder.model.CookieLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class CookieFinderCSVParser implements FileParser<List<CookieLog>> {
    private static final Logger LOG = LoggerFactory.getLogger(CookieFinderCSVParser.class);
    private static final String DELIMITER = ",";

    @Autowired
    TimeParser timeParser;

    @Override
    public List<CookieLog> getResult(File file) {
        List<CookieLog> allLines = null;
        try {
            allLines = Files.lines(Path.of(file.getName()))
                    .map(x -> x.split(DELIMITER))
                    .map(arr -> new CookieLog(arr[0], timeParser.fromZonedDateString(arr[1])))
                    .toList();
        } catch (IOException e) {
            LOG.error("Failed to parse the file {}", e.getMessage());
        }
        return allLines;
    }
}
