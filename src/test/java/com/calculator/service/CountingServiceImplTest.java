package com.calculator.service;

import com.calculator.domain.ComplexObject;
import com.calculator.domain.Service;
import com.calculator.service.validation.ValidationService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CountingServiceImplTest {

    @Mock
    ValidationService validationService;

    @InjectMocks
    CountingService countingService = new CountingServiceImpl();

    @Test(expected = IllegalArgumentException.class)
    public void addWithInvalidComplexObjects(){
        ComplexObject obj1 = new ComplexObject(1, 1, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 1, Service.B);

        doThrow(IllegalArgumentException.class)
                .when(validationService)
                .checkCompatibilityAndValidity(any(ComplexObject.class), any(ComplexObject.class));

        countingService.add(obj1, obj2);
    }

    @Test
    public void addWithValidComplexObjects(){
        ComplexObject obj1 = new ComplexObject(1, 1, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 1, Service.A);

        ComplexObject result = countingService.add(obj1, obj2);

        ComplexObject expected = new ComplexObject(2, 2, Service.A);
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractWithInvalidComplexObjects(){
        ComplexObject obj1 = new ComplexObject(1, 1, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 1, Service.B);

        doThrow(IllegalArgumentException.class)
                .when(validationService)
                .checkCompatibilityAndValidity(any(ComplexObject.class), any(ComplexObject.class));

        countingService.subtract(obj1, obj2);
    }

    @Test
    public void subtractWithValidComplexObjects(){
        ComplexObject obj1 = new ComplexObject(2, 4, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 1, Service.A);

        ComplexObject result = countingService.subtract(obj1, obj2);

        ComplexObject expected = new ComplexObject(1, 3, Service.A);
        assertEquals(expected, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideWithInvalidComplexObjects(){
        ComplexObject obj1 = new ComplexObject(1, 1, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 1, Service.B);

        doThrow(IllegalArgumentException.class)
                .when(validationService)
                .checkCompatibilityAndValidity(any(ComplexObject.class), any(ComplexObject.class));

        countingService.divide(obj1, obj2);
    }

    @Test
    public void divideWithValidComplexObjects(){
        ComplexObject obj1 = new ComplexObject(6, 20, Service.A);
        ComplexObject obj2 = new ComplexObject(3, 4, Service.A);

        ComplexObject result = countingService.divide(obj1, obj2);

        ComplexObject expected = new ComplexObject(2, 5, Service.A);
        assertEquals(expected, result);
    }

    @Test(expected = ArithmeticException.class)
    public void divideByNull(){
        ComplexObject obj1 = new ComplexObject(1, 1, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 0, Service.A);

        ComplexObject result = countingService.divide(obj1, obj2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyWithInvalidComplexObjects(){
        ComplexObject obj1 = new ComplexObject(2, 7, Service.A);
        ComplexObject obj2 = new ComplexObject(4, 3, Service.B);

        doThrow(IllegalArgumentException.class)
                .when(validationService)
                .checkCompatibilityAndValidity(any(ComplexObject.class), any(ComplexObject.class));

        countingService.multiply(obj1, obj2);
    }

    @Test
    public void multiplyWithValidComplexObjects(){
        ComplexObject obj1 = new ComplexObject(2, 7, Service.A);
        ComplexObject obj2 = new ComplexObject(4, 3, Service.A);

        ComplexObject result = countingService.multiply(obj1, obj2);

        ComplexObject expected = new ComplexObject(8, 21, Service.A);
        assertEquals(expected, result);
    }
}