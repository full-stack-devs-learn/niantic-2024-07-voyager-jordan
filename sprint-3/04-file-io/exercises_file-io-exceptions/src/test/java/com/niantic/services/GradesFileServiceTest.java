package com.niantic.services;

import com.niantic.models.Assignment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GradesFileServiceTest {

    private File directory;
    private GradesFileService gradesService;

    @BeforeEach
    public void setup(){
        directory = new File("files");
        gradesService = new GradesFileService();
    }

    @Test
    public void getFileName_shouldReturnFiles_inDirectoryFiles()
    {
        //Arrange
        int expected = 5;
        //Act
        var actual = gradesService.getFileNames().length;
        //Assert
        assertEquals(expected, actual, "expected length of data: " + expected + " , actual length of data " + actual);
    }
}