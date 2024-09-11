package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DaggerTest {
    private Dagger dagger;

    @BeforeEach
    void setup(){
        dagger = new Dagger("Little Pokey", 5);
    }

    @Test
    public void addDagger_whenCalled_increaseCountByOne()
    {
        //Arrange
        int expected = dagger.getDaggerCount() + 1;
        //Act
        dagger.addDagger();
        int actual = dagger.getDaggerCount();
        //Assert
        assertEquals(expected, actual, "You have " + actual + " daggers, you expected to have " + expected);
    }

    @ParameterizedTest
    @CsvSource({
            "-2, 0",
            "0, 0",
            "1, 20",
            "2, 40",
            "4, 80",
            "5, 100",
            "6, 100"
    })
    public void daggerAttack_whenCalled_chargeIncreased(int timesIn, int expectedChargeIn)
    {
        //Arrange
        //Act
        for(int i = 0; i < timesIn; i++)
        {
            dagger.attack();
        }
        int actual = dagger.getPercentCharged();
        //Assert
        assertEquals(expectedChargeIn, actual, "You are at " + actual + "% charge, you expected to have " + expectedChargeIn +"% charges");
    }

    @ParameterizedTest
    @CsvSource({
            "-2, 1",
            "0, 1",
            "1, 1",
            "2, 1",
            "4, 1",
            "5, 1",
            "6, 1"
    })
    public void daggerAttack_whenCalled_countNeverChanges(int timesIn, int expectedCount)
    {
        //Arrange
        //Act
        for(int i = 0; i < timesIn; i++)
        {
            dagger.attack();
        }
        int actual = dagger.getDaggerCount();
        //Assert
        assertEquals(expectedCount, actual, "Your dagger count is  " + actual + " you expected to have " + expectedCount);
    }
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "50, 50",
            "75, 75",
            "100, 0"
    })
    public void daggerPowerAttack_whenFullyCharged_chargeDecreaseZero(int chargeStartIn, int expectedChargeIn)
    {
        //Arrange
        dagger.setPercentCharged(chargeStartIn);
        //Act
        dagger.powerAttack();
        int actual = dagger.getPercentCharged();
        //Assert
        assertEquals(expectedChargeIn, actual, "You are at " + actual + "% charge, you expected to have " + expectedChargeIn +"% charges");
    }
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "50, 50",
            "75, 75",
            "99, 99"
    })
    public void daggerPowerAttack_whenNotEnoughCharges_chargeNeverChanges(int chargeStartIn, int expectedChargeIn)
    {
        //Arrange
        dagger.setPercentCharged(chargeStartIn);
        //Act
        dagger.powerAttack();
        int actual = dagger.getPercentCharged();
        //Assert
        assertEquals(expectedChargeIn, actual, "You are at " + actual + "% charge, you expected to have " + expectedChargeIn +"% charges");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 1",
            "10, 9",
            "0, 0",

    })
    public void daggerPowerAttack_whenCalled_countDecreaseByOne(int daggerStartIn, int expectedCount)
    {
        //Arrange
        int chargeNeeded = 100;
        dagger.setPercentCharged(chargeNeeded);
        for (int i = 1; i < daggerStartIn; i++){
            dagger.addDagger();
        }
        //Act
        dagger.powerAttack();
        int actual = dagger.getDaggerCount();
        //Assert
        assertEquals(expectedCount, actual, "Your dagger count is  " + actual + " you expected to have " + expectedCount);
    }

    @Test
    public void getRange_whenCalled_return10()
    {
        //Arrange
        int expected = 10;
        //Act
        int actual = dagger.getRange();
        //Assert
        assertEquals(expected, actual, "Your range is " + actual + " you expected to have " + expected);
    }
}
