package com.calculator.service.validation;

import com.calculator.domain.ComplexObject;

public interface ValidationService {
    void validate(ComplexObject complexObject);

    void checkCompatibility(ComplexObject... params);

    void checkCompatibilityAndValidity(ComplexObject... params);
}

