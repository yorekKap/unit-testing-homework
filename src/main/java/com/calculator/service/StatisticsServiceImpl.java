package com.calculator.service;

public class StatisticsServiceImpl implements StatisticsService {
    private int addCalls;
    private int subtractCalls;
    private int divideCalls;
    private int multiplyCalls;

    public int getAddCalls() {
        return addCalls;
    }

    public int getSubtractCalls() {
        return subtractCalls;
    }

    public int getDivideCalls() {
        return divideCalls;
    }

    public int getMultiplyCalls() {
        return multiplyCalls;
    }

    public void incrementAddCalls() {
        addCalls++;
    }

    public void incrementSubtractCalls() {
        subtractCalls++;
    }

    public void incrementDivideCalls() {
        divideCalls++;
    }

    public void incrementMultiplyCalls() {
        multiplyCalls++;
    }

}
