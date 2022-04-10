package org.cliveford.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    @Test
    void checkRoverInitialisesInstanceWithCorrectParameters() {
        Rover rover = new Rover("woof", "hover", 1, 2, "N");
        String roverNameExpected = "woof";
        String roverTypeExpected = "hover";
        int xDropPointExpected = 1;
        int yDropPointExpected = 2;
        String facingExpected = "N";
        String name = rover.getName();
        String type = rover.getType();
        int xCoordinate = rover.getXCoordinate();
        int yCoordinate = rover.getYCoordinate();
        String direction = rover.getDirection();
        assertEquals(roverNameExpected, name);
        assertEquals(roverTypeExpected, type);
        assertEquals(xDropPointExpected, xCoordinate);
        assertEquals(yDropPointExpected, yCoordinate);
        assertEquals(facingExpected, direction);
    }
}
