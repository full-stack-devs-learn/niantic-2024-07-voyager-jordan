package com.niantic.part_2_challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameCharacterTests
{
    GameCharacter newCharacter;

    @BeforeEach
    public void setup()
    {
        newCharacter = new GameCharacter(100, "Jordan");
    }

    @Test
    public void createCharacter_returnCharacter_expectCharacterCreation()
    {
        // Arrange
        String expectedName = "Jordan";
        int expectedEnergyMaxLevel = 100;

        // Act
        String actualName = newCharacter.getName();
        int actualLevel = newCharacter.getMaxEnergyLevel();

        // Assert
        assertEquals(expectedName,actualName, "Expected 'Jordan' as name of character");
        assertEquals(expectedEnergyMaxLevel, actualLevel, "Expected '100' as max energy level");
    }

    @Test
    public void takeHit_calculateEnergyLevelAfterHit_expectZero()
    {
        // Arrange
        int incomingDamage = 110;
        int expectedEnergyRemainder = 0;
        // Act
        newCharacter.takeHit(incomingDamage);
        int actualEnergyRemainder = newCharacter.getEnergyLevel();
        // Assert
        assertEquals(expectedEnergyRemainder, actualEnergyRemainder, "Expected '0' --> 0(Current) - 10(Incoming)");
    }

    @Test
    public void takeHit_calculateEnergyLevelAfterHit_expect77()
    {
        // Arrange
        int incomingDamage = 23;
        int expectedEnergyRemainder = 77;
        // Act
        newCharacter.takeHit(incomingDamage);
        int actualEnergyRemainder = newCharacter.getEnergyLevel();
        // Assert
        assertEquals(expectedEnergyRemainder, actualEnergyRemainder, "Expected '77' --> 100(Current) - 23(Incoming)");
    }

    @Test
    public void heal_healCharacterIfKnocked_expectNoEnergyIncrease()
    {
        // Arrange
        int incomingHeal = 10;
        newCharacter.takeHit(100);
        int expectedEnergyLevel = 0;
        // Act
        newCharacter.heal(incomingHeal);
        int actualEnergyLevel = newCharacter.getEnergyLevel();
        // Assert
        assertEquals(expectedEnergyLevel, actualEnergyLevel, "Expect a increase of zero character is knocked");
    }

    @Test
    public void heal_healCharacter_expectEnergyIncrease()
    {
        // Arrange
        int incomingHeal = 10;
        newCharacter.takeHit(40);
        int expectedEnergyLevel = 70;
        // Act
        newCharacter.heal(incomingHeal);
        int actualEnergyLevel = newCharacter.getEnergyLevel();
        // Assert
        assertEquals(expectedEnergyLevel, actualEnergyLevel, "Expect a increase to character health");
    }

    @Test
    public void heal_healCharacter_expectEnergyToBeMax()
    {
        // Arrange
        int incomingHeal = 50;
        int expectedEnergyLevel = 100;
        // Act
        newCharacter.heal(incomingHeal);
        int actualEnergyLevel = newCharacter.getEnergyLevel();
        // Assert
        assertEquals(expectedEnergyLevel, actualEnergyLevel, "Expect a character health to be set to max");
    }

    @Test
    public void isKnocked_energyGreaterthan0_expectFalse()
    {
        // Arrange
        // Act
        boolean actualValue = newCharacter.isKnockedOut();
        //Arrange
        assertFalse(actualValue, "Should return false if not 0");
    }
    @Test
    public void isKnocked_energyEqualsZero_expectTrue()
    {
        // Arrange
        newCharacter.takeHit(newCharacter.getEnergyLevel());
        // Act
        boolean actualValue = newCharacter.isKnockedOut();
        //Arrange
        assertTrue(actualValue, "Should return true health is zero");
    }
}