package com.calculator.service.validation;

import com.calculator.domain.ComplexObject;

public class BServiceFieldsValidatorImpl implements FieldsValidator {
    public void validate(ComplexObject complexObject) {
        if ( !(complexObject.getValueA() >= 0 && complexObject.getValueB() >= 0)){
            throw new IllegalArgumentException("Wrong values for the B Service ComplexObjects: " +
                    "required: A >= 0, B >= 0; found:  A = " +
                    complexObject.getValueA()  + " B = " + complexObject.getValueB());
        }
    }
}
