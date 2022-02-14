package com.albonec.othercode.multithreading;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Caught Exception on Thread " + t.getId() + ", " + "Info: " + e.getClass().getName() + " " + e.getMessage() + ", StackTrace: " + e.getStackTrace());
        t.interrupt();
    }
}
