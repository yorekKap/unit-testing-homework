package com.calculator.service;

import com.calculator.domain.ComplexObject;
import com.calculator.service.validation.ValidationService;
import com.calculator.service.validation.ValidationServiceImpl;

public class CountingServiceImpl implements CountingService {

    ValidationService validationService;

    public CountingServiceImpl() {
    }

    public CountingServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    public ComplexObject add(ComplexObject param1, ComplexObject param2) {
        validationService.checkCompatibilityAndValidity(param1, param2);

        return new ComplexObject(
                param1.getValueA() + param2.getValueA(),
                param1.getValueB() + param2.getValueB(),
                param1.getService());
    }

    public ComplexObject subtract(ComplexObject param1, ComplexObject param2) {
        validationService.checkCompatibilityAndValidity(param1, param2);

        return new ComplexObject(
                param1.getValueA() - param2.getValueA(),
                param1.getValueB() - param2.getValueB(),
                param1.getService());
    }

    public ComplexObject divide(ComplexObject param1, ComplexObject param2) {
        validationService.checkCompatibilityAndValidity(param1, param2);

        return new ComplexObject(
                param1.getValueA() / param2.getValueA(),
                param1.getValueB() / param2.getValueB(),
                param1.getService());
    }

    public ComplexObject multiply(ComplexObject param1, ComplexObject param2) {
        validationService.checkCompatibilityAndValidity(param1, param2);

        return new ComplexObject(
                param1.getValueA() * param2.getValueA(),
                param1.getValueB() * param2.getValueB(),
                param1.getService());
    }
}
