package com.niantic.part_2_challenge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrinterTests
{
    @Test
    public void print_givenPages_calculatesTotalPagesPrinted()
    {
        // Arrange
        int sheets = 500;
        int toner = 1000;
        Printer printer = new Printer(sheets, toner);

        int pagesToPrint = 20;
        int expected = 20;

        // Act
        int actual = printer.print(pagesToPrint);

        // Assert
        assertEquals(expected, actual, "The actual pages printed wasn't the expected amount"  );
    }
    @Test
    public void print_givenMaxPages_calculatesTotalPagesPrinted()
    {
        // Arrange
        int sheets = 500;
        int toner = 1000;
        Printer printer = new Printer(sheets, toner);

        int pagesToPrint = Integer.MAX_VALUE;
        int expected = Math.min(toner, sheets);

        // Act
        int actual = printer.print(pagesToPrint);

        // Assert
        assertEquals(expected, actual, "The actual pages printed wasn't the expected amount"  );
    }
    @Test
    public void print_givenNegativePages_calculatesTotalPagesPrinted()
    {
        // Arrange
        int sheets = 500;
        int toner = 1000;
        Printer printer = new Printer(sheets, toner);

        int pagesToPrint = -10;
        int expected = 0;

        // Act
        int actual = printer.print(pagesToPrint);

        // Assert
        assertEquals(expected, actual, "The actual pages printed wasn't the expected amount"  );
    }

    @Test
    public void addPaper_givenPaper_addPaperToPrinter()
    {
        int sheets = 50;
        int toner = 1000;
        Printer printer = new Printer(sheets, toner);
        int expected = 100;
        int papersToAdd = 50;

        printer.addPaper(papersToAdd);
        int actual = printer.getSheets();

        assertEquals(expected, actual, "Function didn't calculate adding paper correctly");
    }
    @Test
    public void addPaper_givenMaxPaper_paperSetToMaxCapacity()
    {
        int sheets = 50;
        int toner = 1000;
        Printer printer = new Printer(sheets, toner);
        int expected = 500;
        int papersToAdd = Integer.MAX_VALUE;

        printer.addPaper(papersToAdd);
        int actual = printer.getSheets();

        assertEquals(expected, actual, "Function didn't calculate adding paper correctly");

    }
    @Test
    public void addPaper_givenNegativePaper_doesNotAddPaperToPrinter()
    {
        int sheets = 50;
        int toner = 1000;
        Printer printer = new Printer(sheets, toner);
        int expected = 50;
        int papersToAdd = Integer.MIN_VALUE;

        printer.addPaper(papersToAdd);
        int actual = printer.getSheets();

        assertEquals(expected, actual, "Function didn't calculate adding paper correctly");

    }

    @Test
    public void replaceToner_tonerCalledWithinTonerBoundries_resetTonerToMaxValue()
    {
        int sheets = 500;
        int toner = 500;
        Printer printer = new Printer(sheets, toner);
        int expected = 1000;

        printer.replaceToner();
        int actual = printer.getToner();

        assertEquals(expected, actual, "Toner didn't calculate properly");

    }
    @Test
    public void replaceToner_whenTonerCalledAtMax_resetTonerToMaxValue()
    {
        int sheets = 500;
        int toner = 1000;
        Printer printer = new Printer(sheets, toner);
        int expected = 1000;

        printer.replaceToner();
        int actual = printer.getToner();

        assertEquals(expected, actual, "Toner didn't calculate properly");

    }

}