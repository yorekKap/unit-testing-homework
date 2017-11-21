package com.calculator.service;

public interface StatisticsService {
    int getAddCalls();

    int getSubtractCalls();

    int getMultiplyCalls();

    int getDivideCalls();

    public void incrementAddCalls();

    public void incrementSubtractCalls();

    public void incrementDivideCalls();


    public void incrementMultiplyCalls();

}
