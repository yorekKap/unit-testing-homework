package com.calculator.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatisticsServiceImplTest {
    
    StatisticsService statisticsService = new StatisticsServiceImpl();
   
    @Test
    public void incrementAddCalls() throws Exception {
        statisticsService.incrementAddCalls();
        statisticsService.incrementAddCalls();
        
        assertEquals(2, statisticsService.getAddCalls());
    }

    @Test
    public void incrementSubtractCalls() throws Exception {
        statisticsService.incrementSubtractCalls();
        statisticsService.incrementSubtractCalls();

        assertEquals(2, statisticsService.getSubtractCalls());
    }

    @Test
    public void incrementDivideCalls() throws Exception {
        statisticsService.incrementDivideCalls();
        statisticsService.incrementDivideCalls();

        assertEquals(2, statisticsService.getDivideCalls());
    }

    @Test
    public void incrementMultiplyCalls() throws Exception {
        statisticsService.incrementMultiplyCalls();
        statisticsService.incrementMultiplyCalls();

        assertEquals(2, statisticsService.getMultiplyCalls());
    }

}