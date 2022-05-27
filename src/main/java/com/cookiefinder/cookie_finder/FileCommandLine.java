package com.cookiefinder.cookie_finder;

import com.cookiefinder.cookie_finder.model.CookieLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.io.File;
import java.util.List;
import java.util.Objects;

@CommandLine.Command
@Component
public class FileCommandLine implements Runnable {

    @CommandLine.Option(names = {"-f", "--file"}, description = "provide file", required = true)
    private File filename;


    @CommandLine.Option(names = {"-d", "--date"}, description = "provide date", required = true)
    String timestamp;

    @Autowired
    CookieCollector cookieCollector;

    @Autowired
    FileParser<List<CookieLog>> fileParser;

    @Override
    public void run() {
        if (Objects.nonNull(filename)) {
            List<CookieLog> allLines = fileParser.getResult(filename);
            cookieCollector.cookieCounter(allLines);
            System.out.println(cookieCollector.getCookieForDate(timestamp));
        }
    }
}
