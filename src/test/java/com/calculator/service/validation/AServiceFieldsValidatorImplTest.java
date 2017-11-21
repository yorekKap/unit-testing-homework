package com.calculator.service.validation;

import com.calculator.domain.ComplexObject;
import com.calculator.domain.Service;
import org.junit.Test;

public class AServiceFieldsValidatorImplTest {

    FieldsValidator fieldsValidator = new AServiceFieldsValidatorImpl();

    @Test
    public void validateWithAnyValues() throws Exception {
        ComplexObject object1 = new ComplexObject(Integer.MAX_VALUE, Integer.MIN_VALUE, Service.A);
        ComplexObject object2 = new ComplexObject(Integer.MIN_VALUE, Integer.MAX_VALUE, Service.A);

        fieldsValidator.validate(object1);
        fieldsValidator.validate(object2);
    }

}