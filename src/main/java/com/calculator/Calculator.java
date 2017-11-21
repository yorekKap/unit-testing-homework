package com.calculator;

import com.calculator.domain.ComplexObject;
import com.calculator.domain.Service;
import com.calculator.service.CountingService;
import com.calculator.service.StatisticsService;
import com.calculator.service.validation.FieldsValidator;
import com.calculator.service.validation.ValidationService;

import java.util.Map;

public class Calculator {

    private CountingService countingService;
    private StatisticsService statisticsService;

    public Calculator() {
    }

    public Calculator(CountingService countingService,
                      StatisticsService statisticsService) {

        this.countingService = countingService;
        this.statisticsService = statisticsService;
    }

    public ComplexObject add(ComplexObject param1, ComplexObject param2) {
        ComplexObject result = countingService.add(param1, param2);
        statisticsService.incrementAddCalls();
        return result;

    }

    public ComplexObject subtract(ComplexObject param1, ComplexObject param2) {
        ComplexObject result = countingService.subtract(param1, param2);
        statisticsService.incrementSubtractCalls();
        return result;

    }

    public ComplexObject divide(ComplexObject param1, ComplexObject param2) {
        ComplexObject result = countingService.divide(param1, param2);
        statisticsService.incrementDivideCalls();
        return result;

    }

    public ComplexObject multiply(ComplexObject param1, ComplexObject param2) {
        ComplexObject result = countingService.multiply(param1, param2);
        statisticsService.incrementMultiplyCalls();

        return countingService.multiply(param1, param2);
    }



}
