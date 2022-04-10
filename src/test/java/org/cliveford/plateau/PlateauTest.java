package org.cliveford.plateau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauTest {

    @Test
    void checkPlateauInitialisesInstanceWithCorrectParameters() {
        Plateau plateau = new Plateau(10, 10);
        int xAxisExpected = 10;
        int yAxisExpected = 10;
        int xAxis = plateau.getXAxis();
        int yAxis = plateau.getYAxis();
        assertEquals(xAxisExpected, xAxis);
        assertEquals(yAxisExpected, yAxis);
    }


}
