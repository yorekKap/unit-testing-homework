package com.calculator.service.validation;

import com.calculator.domain.ComplexObject;
import com.calculator.domain.Service;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BServiceFieldsValidatorImplTest {

    FieldsValidator fieldsValidator = new BServiceFieldsValidatorImpl();

    @Rule
    public ExpectedException expectedException;

    @Test(expected = IllegalArgumentException.class)
    public void validateWithNegativeA() throws Exception {
        ComplexObject complexObject = new ComplexObject(-1 , 100, Service.B);

        fieldsValidator.validate(complexObject);


    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWithNegativeBValue(){
        ComplexObject complexObject = new ComplexObject(0, -1, Service.B);

        fieldsValidator.validate(complexObject);
    }

    @Test
    public void validateWithPositiveValues(){
        ComplexObject complexObject = new ComplexObject(1, 1, Service.B);

        fieldsValidator.validate(complexObject);
    }

}