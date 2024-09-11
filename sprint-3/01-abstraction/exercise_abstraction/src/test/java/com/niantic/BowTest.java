package com.niantic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowTest {

    @ParameterizedTest
    @CsvSource({
        "Explosive, Explosive",
        "Poison, Poison",
        "Standard, Standard",
        "Sticky, IllegalArgument "
    })
    public void createBow_givenInvalidName_cannotCreate(String expectedName)
    {
        //Arrange
        int damage = 5;
        int quiverSize = 10;
        //Act
        Bow testBow = new Bow(expectedName, damage, quiverSize);
        String actual = testBow.getName();
        //Assert
        assertEquals(expectedName, actual, "You have a bow of type: " + actual + " but expected " + expectedName);
    }
}
