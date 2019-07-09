package com.paazl.cases.test2;

import com.paazl.cases.common.developer.DeveloperFactory;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import static com.paazl.cases.common.Constants.QUESTIONS;

public class Main {
    /*
     * TODO
     * Implement a main method that is functionally identical to Test #1. In
     * this case, use a DeveloperFactory that is able to produce 3 types of
     * developers that implement a "print" method. The Factory should have a
     * create method that takes the user's score as an argument.
     */
    public static void main(String[] args) throws IOException {

        int score = calculateInterviewScore();
        System.out.println("result = " + score);

        new DeveloperFactory().create(score).print();
    }

    private static int calculateInterviewScore() {
        return (int) getQuestions().stream()
                .filter(question -> {
                    System.out.println(question);
                    return isRightAnswer(getUserAnswer(), question);
                })
                .count();
    }

    private static Set<String> getQuestions() {
        return QUESTIONS.keySet();
    }

    private static String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext(Pattern.compile("[nyNY]"))) {
            System.out.println("Please enter [y/n] answer!");
            scanner.next();
        }
        return scanner.next().toLowerCase();
    }

    private static boolean isRightAnswer(String userAnswer, String question) {
        return userAnswer.equals(getAnswer(question));
    }

    private static String getAnswer(String question) {
        return QUESTIONS.get(question).toString().toLowerCase();
    }

}