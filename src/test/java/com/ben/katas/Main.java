package com.ben.katas;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BookStoreTest.class);
        if (result.getFailures().size() == 0) {
            System.out.println("Tests completed successfully");
        }
        for (Failure failure : result.getFailures()) {
            System.out.println("Tests completed with errors");
            System.out.println(failure.toString());
        }
    }
}
