package org.cliveford.rover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RoverTest {

    Rover rover;

    @BeforeEach
    void setup() {rover = new Rover("woof", "hover", 1, 2, "N");}

    @Test
    @DisplayName("Check that rover object is not Null")
    void checkObjectNotNull() {
        assertNotNull(rover);
    }

    @Test
    void checkRoverInitialisesInstanceWithCorrectParameters() {
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
        Assertions.assertAll(
                () -> assertEquals(roverNameExpected, name),
                () -> assertEquals(roverTypeExpected, type),
                () -> assertEquals(xDropPointExpected, xCoordinate),
                () -> assertEquals(yDropPointExpected, yCoordinate),
                () -> assertEquals(facingExpected, direction)
        );
    }

}
