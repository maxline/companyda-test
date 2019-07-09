package com.paazl.cases.test3;

import com.paazl.cases.common.developer.DeveloperFactory;

import java.io.IOException;

public class Main {
    /*
     * TODO
     * Implement a main method that is functionally identical to Test #2. In
     * this case, use a Singleton that poses the questions and gathers the answers.
     */
    public static void main(String[] args) throws IOException {

        int score = Interview.getInstance().calculateInterviewScore();
        System.out.println("result = " + score);
        new DeveloperFactory().create(score).print();
    }
}