package org.cliveford.plateau;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauTest {

    Plateau plateau;

    @BeforeEach
    void setUp() {
        plateau = new Plateau("quietplace", 10, 10);
    }

    @Test
    @DisplayName("Check that plateau object is not Null")
    void checkObjectNotNull() {
        assertNotNull(plateau);
    }

    @Test
    @DisplayName("Check that Plateau initialises correctly")
    void checkPlateauInitialisesInstanceWithCorrectParameters() {
        String nameExpected = "quietplace";
        int xAxisExpected = 10;
        int yAxisExpected = 10;
        String nameResult = plateau.getPlateauName();
        int xAxis = plateau.getXAxis();
        int yAxis = plateau.getYAxis();
        Assertions.assertAll(
                // checks all assertions even if 1st or 2nd fails
                () -> assertEquals(nameExpected, nameResult),
                () -> assertEquals(xAxisExpected, xAxis),
                () -> assertEquals(yAxisExpected, yAxis)
        );
    }

}
