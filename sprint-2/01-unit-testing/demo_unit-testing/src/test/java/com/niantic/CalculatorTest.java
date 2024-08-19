package com.niantic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest
{
    //Class level variable
    Calculator calculator = new Calculator();

    //Setup before every test
    @BeforeEach
    public void setup()
    {
        calculator = new Calculator();
    }

    @Test
    public void add_shouldReturn_sumOfNumbers()
    {
        // arrange
        Calculator calculator = new Calculator();
        int firstNumber = 10;
        int secondNumber = 3;
        double expected = 13;
        // act
        double actual = calculator.add(firstNumber, secondNumber);
        // assert
        Assertions.assertEquals(expected, actual, "" );
        //OR
        //assertEquals(expected, actual);
    }
}