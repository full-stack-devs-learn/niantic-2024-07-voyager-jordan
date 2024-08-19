package com.niantic.part_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTests
{
    /*
    Methods Tested
    Get Area
    - Positive values for rectangle
    - Negative values for rectangle
    Get Perimeter
    - Positive values for rectangle
    - Negative values for rectangle
    */

    @Test
    public void emptyConstructor_returnRectangleValues_expected5x5Rectangle()
    {
        // Arrange
        Rectangle rectangle = new Rectangle();
        // Act
        int currentHeight = rectangle.getHeight();
        int expectedHeight = 5;
        // Assert
        assertEquals(expectedHeight, currentHeight);
    }
    @Test
    public void getArea_positiveValues_expectedZero()
    {
        // Arrange
        int expectedWidth = 5;
        int expectedHeight = 10;
        int expectedArea = 50;
        Rectangle rectangle = new Rectangle(expectedWidth, expectedHeight);
        // Act
        int actualArea = rectangle.getArea();
        // Assert
        assertEquals(expectedArea, actualArea, "Expected to get the Area based off positive rectangle values");
    }
    @Test
    public void getArea_negativeValues_expectedZero()
    {
        // Arrange
        int expectedWidth = -5;
        int expectedHeight = 10;
        int expectedArea = 0;
        Rectangle defaultRectangle = new Rectangle(expectedWidth, expectedHeight);
        // Act
        int actualArea = defaultRectangle.getArea();
        // Assert
        assertEquals(expectedArea, actualArea, "Expected to get the Area based off negative rectangle values");

    }
    @Test
    public void getPerimeter_returnPerimeterPositiveValues_expectedHeightPlusWidthTimesTwo()
    {
        // Arrange
        Rectangle rectangle = new Rectangle();
        int expectedPerimeter = 20;
        // Act
        int actualPerimeter = rectangle.getPerimeter();
        // Assert
        assertEquals(expectedPerimeter, actualPerimeter, "Expected perimeter of the rectangle");
    }
    @Test
    public void getPerimeter_returnPerimeterNegativeValues_expectedZero()
    {
        // Arrange
        int expectedWidth = -5;
        int expectedHeight = 20;
        int expectedPerimeter = 0;
        Rectangle rectangle = new Rectangle(expectedWidth, expectedHeight);
        // Act
        int actualPerimeter = rectangle.getPerimeter();
        // Assert
        assertEquals(expectedPerimeter, actualPerimeter, "Expected perimeter of the rectangle to be zero");
    }
}