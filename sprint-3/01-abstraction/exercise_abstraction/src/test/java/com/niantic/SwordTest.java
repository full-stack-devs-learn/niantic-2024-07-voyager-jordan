package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class SwordTest {

    private Sword sword;

    @BeforeEach
    void setup(){
        sword = new Sword("Pokey", 10);
    }
    @ParameterizedTest
    @CsvSource({
            "-10, 0",
            "0, 0",
            "50, 50",
            "100, 100",
            "150, 100"
    })
    public void setPercentCharge_givenValues_changePercentCharge(int inputIn, int expected)
    {
        //arrange
        //act
        sword.setPercentCharged(inputIn);
        int actual = sword.getPercentCharged();
        //assert
        assertEquals(expected, actual, "current  weapon charge is " + actual + ", you expected " + expected);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 10",
            "2, 20",
            "10, 100",
            "12, 100"
    })
    public void swordAttack_whenAttack_chargeIncrease(int timesUsed, int expected)
    {
        //arrange
        //act
        for(int i = 0; i < timesUsed; i++){
            sword.attack();
        }
        int actual = sword.getPercentCharged();
        //assert
        assertEquals(expected, actual, "current  weapon charge is " + actual + ", you expected " + expected);
    }
    @ParameterizedTest
    @CsvSource({
        "0, 10",
        "49, 59",
        "50, 0",
        "90, 40",
        "99, 49",
        "100, 0"

    })
    public void swordPowerAttack_whenPowerAttack_ifChargesGoodDecreaseElseIncrease(int inputCharge, int expectedIn)
    {
        //arrange
        sword.setPercentCharged(inputCharge);
        //act
        sword.powerAttack();
        int actual = sword.getPercentCharged();
        //assert
        assertEquals(expectedIn, actual, "Remaining charge expected " + expectedIn + " actual charge " + actual);
    }
    @Test
    public void getRange_returnRange()
    {
        //arrange
        int expected = 1;
        //act
        int actual = sword.getRange();
        //assert
        assertEquals(expected, actual, "Expected range " + expected + " actual range " + actual);
    }
}

