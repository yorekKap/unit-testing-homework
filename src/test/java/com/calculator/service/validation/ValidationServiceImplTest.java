package com.calculator.service.validation;

import com.calculator.domain.ComplexObject;
import com.calculator.domain.Service;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class ValidationServiceImplTest {

    @Mock
    FieldsValidator fieldsValidator;

    @Mock
    FieldsValidatorFactory fieldsValidatorFactory;

    @InjectMocks
    ValidationService service = new ValidationServiceImpl(fieldsValidatorFactory);

    @Before
    public void before() {
        when(fieldsValidatorFactory.getFieldsValidator(any(ComplexObject.class)))
                .thenReturn(fieldsValidator);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWithNullService() {
        ComplexObject obj = new ComplexObject(1, 1, null);

        service.validate(obj);
    }

    @Test(expected = IllegalArgumentException.class)
    public void validateWithFailingFieldValidator() {
        ComplexObject obj = new ComplexObject(1, 1, Service.A);
        doThrow(new IllegalArgumentException())
                .when(fieldsValidator)
                .validate(any(ComplexObject.class));

        service.validate(obj);
    }

    @Test
    public void validateWithRightValuesAndNotNullService() {
        ComplexObject complexObject = new ComplexObject(1, 1, Service.A);

        service.validate(complexObject);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCompatibilityWithDifferentServices(){
        ComplexObject obj1 = new ComplexObject(1, 1, Service.A);
        ComplexObject obj2 = new ComplexObject(1,1,Service.A);
        ComplexObject obj3 = new ComplexObject(1, 1, Service.B);

        service.checkCompatibility(obj1, obj2, obj3);
    }

    @Test
    public void checkCompatibilityWithSameServices(){
        ComplexObject obj1 = new ComplexObject(1,1,Service.A);
        ComplexObject obj2 = new ComplexObject(1, 1, Service.A);

        service.checkCompatibility(obj1, obj2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCompatibilityAndValidityWithIncompatibleObjects(){
        ComplexObject obj1 = new ComplexObject(1, 1, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 1, Service.B);

        service.checkCompatibilityAndValidity(obj1, obj2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCompatibilityAndValidityWithInvalidObjects(){
        ComplexObject obj1 = new ComplexObject(1, 1, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 1, Service.B);
        doThrow(new IllegalArgumentException())
                .when(fieldsValidator)
                .validate(any(ComplexObject.class));

        service.checkCompatibilityAndValidity(obj1, obj2);
    }

    @Test()
    public void checkCompatibilityAndValidityWithRightObjects(){
        ComplexObject obj1 = new ComplexObject(1, 1, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 1, Service.A);

        service.checkCompatibilityAndValidity(obj1, obj2);
    }
}
