package com.company;

import java.io.IOException;

public class MyException extends IOException {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
