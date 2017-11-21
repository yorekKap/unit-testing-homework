package com.calculator;

import com.calculator.domain.Service;
import com.calculator.domain.ComplexObject;
import com.calculator.service.CountingService;
import com.calculator.service.StatisticsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {

    @Mock
    private CountingService countingService;

    @Mock
    private StatisticsService statisticsService;

    @InjectMocks
    private Calculator calculator = new Calculator();

    @Test
    public void add() {
        //Given
        ComplexObject obj1 = new ComplexObject(1, 1, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 1, Service.A);
        
        ComplexObject expected = new ComplexObject(2, 2, Service.A);
        when(countingService.add(obj1, obj2)).thenReturn(expected);

        //When
        ComplexObject result = calculator.add(obj1, obj2);

        //Then
        assertEquals(expected, result);
        verify(statisticsService, times(1)).incrementAddCalls();
    }

    @Test
    public void subtract() {
        //Given
        ComplexObject obj1 = new ComplexObject(3, 6, Service.A);
        ComplexObject obj2 = new ComplexObject(1, 8, Service.A);

        ComplexObject expected = new ComplexObject(3, -2, Service.A);
        when(countingService.subtract(obj1, obj2)).thenReturn(expected);

        //When
        ComplexObject result = calculator.subtract(obj1, obj2);

        //Then
        assertEquals(expected, result);
        verify(statisticsService, times(1)).incrementSubtractCalls();
    }

    @Test
    public void divide() {
        //Given
        ComplexObject obj1 = new ComplexObject(10, 18, Service.A);
        ComplexObject obj2 = new ComplexObject(2, 3, Service.A);

        ComplexObject expected = new ComplexObject(5, 6, Service.A);
        when(countingService.divide(obj1, obj2)).thenReturn(expected);

        //When
        ComplexObject result = calculator.divide(obj1, obj2);

        //Then
        assertEquals(expected, result);
        verify(statisticsService, times(1)).incrementDivideCalls();
    }

    @Test
    public void multiply() {
        //Given
        ComplexObject obj1 = new ComplexObject(40, 4, Service.A);
        ComplexObject obj2 = new ComplexObject(2, 3, Service.A);

        ComplexObject expected = new ComplexObject(80, 12, Service.A);
        when(countingService.multiply(obj1, obj2)).thenReturn(expected);

        //When
        ComplexObject result = calculator.multiply(obj1, obj2);

        //Then
        assertEquals(expected, result);
        verify(statisticsService, times(1)).incrementMultiplyCalls();
    }
}
