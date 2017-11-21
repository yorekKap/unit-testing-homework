package com.calculator.service.validation;

import com.calculator.domain.ComplexObject;

public class CServiceFieldsValidatorImpl implements FieldsValidator {
    public void validate(ComplexObject complexObject) {
        if (!(complexObject.getValueA() >= -100 &&
                complexObject.getValueA() <= 50 &&
                complexObject.getValueB() < 0)){

            throw new IllegalArgumentException("Wrong values for the C Service ComplexObjects: " +
                    "required: -100 <= A >= 50, B < 0; found:  A = " +
                    complexObject.getValueA()  + " B = " + complexObject.getValueB());
        }
    }
}
