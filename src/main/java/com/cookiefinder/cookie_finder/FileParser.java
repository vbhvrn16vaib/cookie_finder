package com.cookiefinder.cookie_finder;

import java.io.File;

public interface FileParser<T> {
    T getResult(File file);
}
