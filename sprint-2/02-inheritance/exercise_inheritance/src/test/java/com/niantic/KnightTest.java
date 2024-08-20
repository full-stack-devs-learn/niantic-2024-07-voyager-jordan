package com.niantic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KnightTest {

    public Knight defaultKnight = new Knight("Jordan", 100, 1, 0, 5);

    @ParameterizedTest
    @CsvSource({
        "-5, 0",
        "1, 1",
        "10, 10"
    })
    void getArmor_should_returnArmorValueOfCreatedKnight(int armorIn, int expected)
    {
        //Arrange
        Knight testKnight = new Knight("Jordan", 100, 1, 0, armorIn);
        //Act
        int actual = testKnight.getArmor();
        //Assert
        assertEquals(expected, actual, "You expected " + expected + " but got" + actual);
    }

    @ParameterizedTest
    @CsvSource({
            "-5, 10, 90",
            "5, 10, 95",
            "10, 10, 100",
            "20, 10, 100"
    })
    public void takeDamage_withAndWithoutArmorShould_calculateHealth(int armorIn, int incomingDamage, int expected)
    {
        //Arrange
        Knight testKnight = new Knight("Jordan", 100, 1, 0, armorIn);

        //Act
        testKnight.takeDamage(incomingDamage);
        int actual = testKnight.getHealth();

        //Assert
        assertEquals(expected, actual, "You expected to have " + expected + " health remaining, after receiving " + incomingDamage + " damage");
    }

    @ParameterizedTest
    @CsvSource({
            "1, 5, true, 2, 10",
            "1, 5, false, 1, 5",
    })
    public void levelUp_whileNotDefeated_doesLevelUpAndArmorUp(int levelIn, int armorIn, boolean isAlive, int expectedLevel, int expectedArmor)
    {
        //Arrange
        Knight testKnight;

        if(isAlive){
            testKnight = new Knight("Jordan", 100, levelIn, 0, armorIn);
        } else {
            testKnight = new Knight("Jordan", 0, levelIn, 0, armorIn);
        }

        //Act
        testKnight.levelUp();
        int actualLevel = testKnight.getLevel();
        int actualArmor = testKnight.getArmor();
        //Assert
        assertEquals(expectedLevel, actualLevel, "You expected to be level " + expectedLevel + " but currently have " + actualLevel);
        assertEquals(expectedArmor, actualArmor, "You expected to have " + expectedArmor + " armor but currently have " + actualArmor);
    }

}
