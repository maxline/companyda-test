package com.paazl.cases.test1;

import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import static com.paazl.cases.common.Constants.QUESTIONS;
import static com.paazl.cases.common.Level.*;

public class Main {
    /*
     * TODO
     * Implement the main method:
     * * Show the user the questions from Constants.QUESTIONS on a console and collect the answers.
     * * If the user scores 0-3 points, print "You are a junior Java developer".
     * * If the user scores 4-7 points, print "You are a medior Java developer".
     * * If the user scores 8-10 points, print "You are a senior Java developer".
     */

    public static void main(String[] args) {

        int score = calculateInterviewScore();
        System.out.println("result = " + score);

        System.out.println(getLevelMessage(score));
    }

    private static int calculateInterviewScore() {
        int score = 0;
        for (String question : getQuestions()) {
            System.out.println(question);
            if (isRightAnswer(getUserAnswer(), question)) {
                score++;
            }
        }
        return score;
    }

    private static Set<String> getQuestions() {
        return QUESTIONS.keySet();
    }

    private static boolean isRightAnswer(String userAnswer, String question) {
        return userAnswer.toLowerCase().equals(getAnswer(question));
    }

    private static String getUserAnswer() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext(Pattern.compile("[nyNY]"))) {
            System.out.println("Please enter [y/n] answer!");
            scanner.next();
        }
        return scanner.next().toLowerCase();
    }

    private static String getAnswer(String question) {
        return QUESTIONS.get(question).toString().toLowerCase();
    }

    private static String getLevelMessage(int score) {
        String level = estimateLevel(score);
        return String.format("You are a %s Java developer", level);
    }

    private static String estimateLevel(int score) {
        if (score >= JUNIOR.getMin() && score <= JUNIOR.getMax()) {
            return JUNIOR.toString().toLowerCase();
        } else if (score >= MEDIOR.getMin() && score <= MEDIOR.getMax()) {
            return MEDIOR.toString().toLowerCase();
        } else if (score >= SENIOR.getMin() && score <= SENIOR.getMax()) {
            return SENIOR.toString().toLowerCase();
        } else {
            throw new IllegalArgumentException();
        }
    }
}