package com.paazl.cases.common;

public enum Level {
    SENIOR(8, 11),
    MEDIOR(4, 7),
    JUNIOR(0, 3);

    private final int min;
    private final int max;

    Level(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }
}