package com.calculator.service.validation;

import com.calculator.domain.ComplexObject;
import com.calculator.domain.Service;
import org.junit.Test;

import static org.junit.Assert.*;

public class CServiceFieldsValidatorImplTest {

    FieldsValidator fieldsValidator = new CServiceFieldsValidatorImpl();

    @Test
    public void validateWithRightValues(){
        ComplexObject obj1 = new ComplexObject(-100, -1, Service.C);
        ComplexObject obj2 = new ComplexObject(50, Integer.MIN_VALUE, Service.C);

        fieldsValidator.validate(obj1);
        fieldsValidator.validate(obj2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWithPositiveBValue(){
        ComplexObject obj = new ComplexObject(10, 1, Service.C);

        fieldsValidator.validate(obj);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWithAValueLowerThanNegative100() throws Exception {
        ComplexObject obj = new ComplexObject(-101, -100, Service.C);

        fieldsValidator.validate(obj);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWithAValueGreaterThan50(){
        ComplexObject obj = new ComplexObject(51, -100, Service.C);

        fieldsValidator.validate(obj);
    }

}