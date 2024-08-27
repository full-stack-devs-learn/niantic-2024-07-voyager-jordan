package com.niantic.models;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {

    Hand testHand = new Hand();

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 3",
            "4, 4",
            "5, 5",
    })
    public void dealTo_givenAValidCard_addToHand(int amountIn, int expectedHandSize){

        //Act
        for(int i = 0; i < amountIn; i++){
            testHand.dealTo(new Card(String.valueOf(i)));
        }
        var actual = testHand.getCardCount();
        var actualHand = testHand.toString();
        //Assert
        assertEquals(expectedHandSize, actual, "The expected hand size is: " + expectedHandSize + " but the current size is " + actual + " your hand: " + actualHand);
    }



    @ParameterizedTest
    @CsvSource({
        "1, 4",
        "2, 4",
        "3, 4",
        "4, 4",
        "5, 4",
    })
    public void removeCard_givenAValue_removeCardofValueFromHand(String valueIn, int expected)
    {
        //Arrange
        testHand.dealTo(new Card("1"));
        testHand.dealTo(new Card("2"));
        testHand.dealTo(new Card("3"));
        testHand.dealTo(new Card("4"));
        testHand.dealTo(new Card("5"));
        //Act
        testHand.removeCardofValue(valueIn);
        var actual = testHand.getCardCount();
        var actualHand = testHand.toString();
        //Assert
        assertEquals(expected, actual, "The expected hand size is: " + expected + " but the current size is " + actual + " your hand: " + actualHand);
    }
}
