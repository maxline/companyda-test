package com.paazl.cases.common.developer;


import static com.paazl.cases.common.Level.MEDIOR;
import static com.paazl.cases.common.Level.SENIOR;

public class DeveloperFactory {

    public Developer create(int score) {

        if (score >= MEDIOR.getMin() && score <= MEDIOR.getMax()) {
            return new MediorDeveloper();
        } else if (score >= SENIOR.getMin() && score <= SENIOR.getMax()) {
            return new SeniorDeveloper();
        } else {
            return new JuniorDeveloper();
        }
    }
}
