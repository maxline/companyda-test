package com.paazl.cases.test3;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import static com.paazl.cases.common.Constants.QUESTIONS;

public class Interview {
    private static Interview instance = null;

    private Interview() {
    }

    public static Interview getInstance() {
        if (instance == null) {
            instance = new Interview();
        }
        return instance;
    }

    public int calculateInterviewScore() {
        return (int) getQuestions().stream()
                .filter(question -> {
                    System.out.println(question);
                    return isRightAnswer(getUserAnswer(), question);
                })
                .count();
    }

    private Set<String> getQuestions() {
        return QUESTIONS.keySet();
    }

    private String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext(Pattern.compile("[nyNY]"))) {
            System.out.println("Please enter [y/n] answer!");
            scanner.next();
        }
        return scanner.next().toLowerCase();
    }

    private boolean isRightAnswer(String userAnswer, String question) {
        return userAnswer.equals(getAnswer(question));
    }

    private String getAnswer(String question) {
        return QUESTIONS.get(question).toString().toLowerCase();
    }
}
