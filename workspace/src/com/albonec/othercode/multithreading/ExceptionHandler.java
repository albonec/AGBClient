package com.albonec.othercode.multithreading;

import java.lang.Thread;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Caught Exception on Thread " + t.getId() + ", " + "Info: " + e.getClass().getName() + " " + e.getMessage());
        t.interrupt();
    }
}
