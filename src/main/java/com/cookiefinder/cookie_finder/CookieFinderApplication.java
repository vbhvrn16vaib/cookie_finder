package com.cookiefinder.cookie_finder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

@SpringBootApplication
public class CookieFinderApplication implements CommandLineRunner {

    FileCommandLine fileCommandLine;

	public static void main(String[] args) {
		SpringApplication.run(CookieFinderApplication.class, args);
	}

    @Autowired
    public CookieFinderApplication(FileCommandLine fileCommandLine){
        this.fileCommandLine = fileCommandLine;
    }

    @Override
    public void run(String... args) throws Exception {
        CommandLine cl = new CommandLine(fileCommandLine);
        cl.parseWithHandler(new CommandLine.RunLast(),args);
    }
}
