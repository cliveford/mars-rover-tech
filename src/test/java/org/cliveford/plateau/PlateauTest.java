package org.cliveford.plateau;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauTest {

    @Test
    void checkPlateauInitialisesInstanceWithCorrectParameters() {
        Plateau plateau = new Plateau(10, 10);
        int xAxisResult = 10;
        int yAxisResult = 10;
        int xAxis = plateau.getXAxis();
        int yAxis = plateau.getYAxis();
        assertEquals(xAxisResult, xAxis);
        assertEquals(yAxisResult, yAxis);
    }

}
